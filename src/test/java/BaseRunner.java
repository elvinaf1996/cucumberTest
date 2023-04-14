import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SimpleReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "step_definitions",
        dryRun = false,
        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        snippets = CucumberOptions.SnippetType.UNDERSCORE)
public abstract class BaseRunner {

    private final SimpleReport report = new SimpleReport();

    @Before
    public void setUp(Scenario scenario) {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000L;
        scenario.log("Starting " + scenario.getName());
        report.start();
    }

    @After
    public void turnDown(Scenario scenario) {
        Selenide.closeWebDriver();
        scenario.log("Finished " + scenario.getName());
        report.finish(scenario.getName());
    }
}
