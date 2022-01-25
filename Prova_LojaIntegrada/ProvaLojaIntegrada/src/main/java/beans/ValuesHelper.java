package beans;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ValuesHelper {

	private static String scenarioName;


	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		ValuesHelper.scenarioName = scenarioName;
	}


}
