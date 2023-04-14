import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "step_definitions")
public abstract class BaseRunner {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000L;
    }

    @After
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}
