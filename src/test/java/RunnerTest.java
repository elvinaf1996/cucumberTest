import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "step_definitions",
        tags = "@All",
        dryRun = false,
        snippets = CucumberOptions.SnippetType.UNDERSCORE)
public class RunnerTest {
}
