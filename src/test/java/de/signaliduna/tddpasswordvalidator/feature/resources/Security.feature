# language: de
  Funktionalität: Als Nutzer möchte ich Passwörter setzten, welche sicher sind.

    Grundlage: Sonderzeichen bestehen nur aus den Zeichen "%", "&", "?", "+", "#"

    Szenario: Wenn ein Nutzer ein sicheres Passwort eingibt, bekommt er die Nachricht "sicher".
      Angenommen ein Nutzer gibt ein neues Passwort ein
      Wenn das Passwort mindestens 12 Zeichen beinhaltet
      Und das Passwort mindestens 3 Zahlen beinhaltet
      Und das Passwort mindestens 1 Sonderzeichen beinhaltet
      Dann wird die Nachricht "sicher" zurückgegeben

    Szenario: Wenn ein Nutzer ein unsicheres Passwort eingibt, welches zu kurz ist, bekommt er die Nachricht "unsicher" zurück.
      Angenommen ein Nutzer gibt ein neues Passwort ein
      Wenn das Passwort mindestens 3 Zahlen beinhaltet
      Und das Passwort mindestens 1 Sonderzeichen beinhaltet
      Aber das Passwort keine 12 Zeichen beinhaltet
      Dann wird die Nachricht "unsicher" zurückgegeben

    Szenario: Wenn ein Nutzer ein unsicheres Passwort eingibt, welches keine Zahlen beinhaltet, bekommt er die Nachricht "unsicher".
      Angenommen ein Nutzer gibt ein neues Passwort ein
      Wenn das Passwort mindestens 12 Zeichen beinhaltet
      Und das Passwort mindestens 1 Sonderzeichen beinhaltet
      Aber das Passwort nicht mindestens 3 Zahlen beinhaltet
      Dann wird die Nachricht "unsicher" zurückgegeben

    Szenario: Wenn ein Nutzer ein unsicheres Passwort eingibt, welches keine Sonderzeichen enthält, bekommt er die Nachricht "sicher".
      Angenommen ein Nutzer gibt ein neues Passwort ein
      Wenn das Passwort mindestens 12 Zeichen beinhaltet
      Und das Passwort mindestens 3 Zahlen beinhaltet
      Aber das Passwort nicht mindestens 1 Sonderzeichen beinhaltet
      Dann wird die Nachricht "unsicher" zurückgegeben
