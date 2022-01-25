package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        monochrome = true,
        strict = true,
        plugin = {"pretty", "html:test-output", "json:target/cucumber.json"},
        features = {"src//test//resources//features"},
        glue = {"steps", "steps.runner.Hooks"},
        tags = { "@realizarCadastro", "@cupomFreteGratis", "@cupomOff10", "@cupom30Reais"}
)
public class RunnerTest {

}

