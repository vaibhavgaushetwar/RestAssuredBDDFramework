package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	   features={"src\\test\\resources\\Spotifyfeature\\playlist.feature"},
       glue= {"steps"},
	   plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
	   publish=true
	   
)
public class playlistRunner extends AbstractTestNGCucumberTests {

	
}
