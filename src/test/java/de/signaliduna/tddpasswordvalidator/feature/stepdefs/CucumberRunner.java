package de.signaliduna.tddpasswordvalidator.feature.stepdefs;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/de/signaliduna/tddpasswordvalidator/feature/resources/Security.feature"}
)
public class CucumberRunner {


}