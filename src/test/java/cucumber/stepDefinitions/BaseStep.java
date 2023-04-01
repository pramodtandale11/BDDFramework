package cucumber.stepDefinitions;

import Utility.Constants;
import io.cucumber.java.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseStep {

    public static String ScenarioName;
    @Before
    public void initialization(Scenario scenario) throws IOException {
        ScenarioName = scenario.getName();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//main//config//config.properties");
        Constants.CONFIG = new Properties();
        Constants.CONFIG.load(fs);
    }
}
