package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import pageObjects.SigninPage;
import pageObjects.Dashboard;
import org.apache.logging.log4j.Logger;

public class LoginSteps {

    private static final Logger logger = BaseClass.getLogger();
    private WebDriver driver = BaseClass.getDriver(); 
    private Dashboard dashboardPage = new Dashboard(driver);
 
    @Then("the user should be redirected to the Dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        String expectedDashboardText = "Dashboard"; 
        String actualDashboardText = dashboardPage.verifyDashboardHeading();
        Assert.assertEquals("User is not redirected to the Dashboard", expectedDashboardText, actualDashboardText);
        logger.info("User successfully redirected to the Dashboard.");
    }
}
