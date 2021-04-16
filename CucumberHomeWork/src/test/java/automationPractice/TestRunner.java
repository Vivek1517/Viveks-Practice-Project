package automationPractice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/Feature"},
        publish = true,
        tags = "@Personal"
)
public class TestRunner {
}
