package cucumber.stepDefinitions;

import Utility.Constants;
import Utility.Reusable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

public class OrangeHRM_StepDef extends Reusable {

    @Given("User launch the {string} Browser")
    public void userLaunchTheBrowser(String browser) {
        String Browser = Constants.CONFIG.getProperty(browser);
        openBrowser(Browser);
        System.out.println("User launched "+Browser+" browser");
    }

    @When("User enters the orangeHRM{string}")
    public void userEntersTheOrangeHRM(String url) {
        String URL = Constants.CONFIG.getProperty(url);
        driver.navigate().to(URL);
        System.out.println("Url Entered is: "+URL);
    }

    @And("User enters Username {string} and Password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        String val_username = Constants.CONFIG.getProperty(username);
        String val_password = Constants.CONFIG.getProperty(password);
        String Obj_username = "//input[@name='username']";
        String Obj_password = "//input[@name='password']";
        sendKeys(Obj_username,val_username);
        sendKeys(Obj_password,val_password);
        System.out.println("User has entered Username: "+val_username+" Password: "+val_password);
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        String Obj_loginButton = "//button[@type='submit']";
        click(Obj_loginButton);
        System.out.println("User has clicked on login button");
    }

    @Then("User verifies the that he is logged in successfully.")
    public void userVerifiesTheThatHeIsLoggedInSuccessfully() {
        String username = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText();
        Assert.assertEquals("mohammed imran",username);
        System.out.println("User name is verified on Homepage");
    }
}
