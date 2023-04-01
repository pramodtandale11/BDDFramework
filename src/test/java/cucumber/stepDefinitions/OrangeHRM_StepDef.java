package cucumber.stepDefinitions;

import PageObjects.LoginPage;
import Utility.Constants;
import Utility.Reusable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class OrangeHRM_StepDef extends Reusable {

    public WebDriver driver;
    public LoginPage loginPage;

    @Given("User launch the {string} Browser")
    public void userLaunchTheBrowser(String browser) {
        String Browser = Constants.CONFIG.getProperty(browser);
        this.driver=openBrowser(Browser);
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(val_username);
        loginPage.enterPassword(val_password);
        System.out.println("User has entered Username: "+val_username+" Password: "+val_password);
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage.clickOnSubmitButton();
    }

    @Then("User verifies the that he is logged in successfully.")
    public void userVerifiesTheThatHeIsLoggedInSuccessfully() {
        boolean username = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).isDisplayed();
        Assert.assertEquals(true,username);
        System.out.println("User logged in to the OrangeHRM homepage");
    }
}
