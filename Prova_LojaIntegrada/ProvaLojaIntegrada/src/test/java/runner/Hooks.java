package runner;

import beans.ValuesHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.TestDataReader;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;


public class Hooks {

	private static final Logger log = LoggerFactory.getLogger(Hooks.class);
	static TestDataReader data = new TestDataReader();
	public static ValuesHelper helper = new ValuesHelper();
	
	@Before()
	public static void setup(Scenario scenario) {
		log.info("Acessando pagina QA Store Desafio Loja Integrada");
		getDriver().get("https://qastoredesafio.lojaintegrada.com.br/");
		log.info("Feature name: " + scenario.getName());
		helper.setScenarioName(scenario.getName());
		Object[] arraysTag = scenario.getSourceTagNames().toArray();
		for (Object tag : arraysTag) {
			data.setCtKey(tag.toString().replace("@", ""));
			System.out.println(data.getCtKey());
		}
	}
	
	@After
	public void tearDown() {
		killDriver();
	}
}

