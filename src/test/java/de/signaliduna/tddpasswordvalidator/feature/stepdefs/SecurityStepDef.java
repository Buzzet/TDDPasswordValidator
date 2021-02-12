package de.signaliduna.tddpasswordvalidator.feature.stepdefs;

import de.signaliduna.tddpasswordvalidator.PasswordValidator;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecurityStepDef {
    private StringBuilder pw = new StringBuilder("");
    private final Pattern NUMBER_PATTERN =
            Pattern.compile("[0-9]");
    private final Pattern SPECIAL_CHARS_PATTERN =
            Pattern.compile("[%&?+#]");
    private final char[] SPECIAL_CHARS = {'%', '&', '?', '+', '#'};

    @Angenommen("ein Nutzer gibt ein neues Passwort ein")
    public void ein_nutzer_gibt_ein_neues_passwort_ein() {
        int length = 13;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        pw.append(generatedString);
    }

    @Wenn("das Passwort mindestens {int} Zeichen beinhaltet")
    public void das_passwort_mindestens_zeichen_beinhaltet(Integer int1) {
        while(pw.length() < int1){
            pw.append('a');
        }
    }

    @Wenn("das Passwort mindestens {int} Zahlen beinhaltet")
    public void das_passwort_mindestens_zahlen_beinhaltet(Integer int1) {
        Matcher numberMatcher = NUMBER_PATTERN.matcher(pw);
        int count = 0;
        while (numberMatcher.find()) {
            count++;
        }
        while(count < int1){
            Random random = new Random();
            pw.append(random.nextInt(10));
            count++;
        }

    }

    @Wenn("das Passwort mindestens {int} Sonderzeichen beinhaltet")
    public void das_passwort_mindestens_sonderzeichen_beinhaltet(Integer int1) {
        Matcher specialCharacterMatcher = SPECIAL_CHARS_PATTERN.matcher(pw);
        int count = 0;
        while (specialCharacterMatcher.find()) {
            count++;
        }
        while(count < int1){
            Random random = new Random();
            pw.append(SPECIAL_CHARS[random.nextInt(SPECIAL_CHARS.length)]);
            count++;
        }
    }

    @Dann("wird die Nachricht {string} zurückgegeben")
    public void wird_die_nachricht_zurückgegeben(String string) {
        System.out.println("Getester wurde folgendes Passwort: " + pw + " und dieses sollte " + string + " sein.");
        Assertions.assertThat(PasswordValidator.validate(pw.toString())).isEqualTo(string);
    }

    @Wenn("das Passwort keine {int} Zeichen beinhaltet")
    public void das_passwort_keine_zeichen_beinhaltet(Integer int1) {
        Random random = new Random();
        while(pw.length() >= int1){
            int randomIndex = random.nextInt(pw.length());
            Matcher numberMatcher = NUMBER_PATTERN.matcher("" + pw.charAt(randomIndex));
            Matcher specialCharacterMatcher = SPECIAL_CHARS_PATTERN.matcher("" + pw.charAt(randomIndex));
            if(!numberMatcher.matches() && !specialCharacterMatcher.matches()){
                pw.deleteCharAt(randomIndex);
            }
        }
    }

    @Wenn("das Passwort nicht mindestens {int} Zahlen beinhaltet")
    public void das_passwort_nicht_mindestens_zahlen_beinhaltet(Integer int1) {
        Matcher numberMatcher = NUMBER_PATTERN.matcher(pw);
        int count = 0;
        while (numberMatcher.find()) {
            count++;
        }
        int i = 0;
        while(i < pw.length() && count > int1){
            Matcher singleNumberMatcher = NUMBER_PATTERN.matcher("" + pw.charAt(i));
            if(singleNumberMatcher.matches()){
                pw.deleteCharAt(i);
            } else {
                i++;
            }
        }
    }

    @Wenn("das Passwort nicht mindestens {int} Sonderzeichen beinhaltet")
    public void das_passwort_nicht_mindestens_sonderzeichen_beinhaltet(Integer int1) {
        Matcher numberMatcher = SPECIAL_CHARS_PATTERN.matcher(pw);
        int count = 0;
        while (numberMatcher.find()) {
            count++;
        }
        int i = 0;
        while(count > int1){
            Matcher singleCharacterMatcher = SPECIAL_CHARS_PATTERN.matcher("" + pw.charAt(i));
            if(singleCharacterMatcher.matches()){
                pw.deleteCharAt(i);
            } else {
                i++;
            }
        }
    }
}
