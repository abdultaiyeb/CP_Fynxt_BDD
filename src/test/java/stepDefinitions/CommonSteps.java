package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.SigninPage;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import org.apache.logging.log4j.Logger;

public class CommonSteps {
    private WebDriver driver = BaseClass.getDriver();

	    private SigninPage signinPage = new SigninPage(driver);
	    private static final Logger logger = BaseClass.getLogger();
	    
	    
    @Given("the user is on the Sign-In page")
    public void the_user_is_on_the_sign_in_page() {   	
        logger.info("User is on the Sign-In page.");
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
    	 signinPage = new SigninPage(driver); 

         signinPage.enterEmail(BaseClass.getProperty("username"));
         logger.info("Entered username");

         signinPage.enterPassword(BaseClass.getProperty("password"));
         logger.info("Entered password");

         signinPage.clickSignIn();
        logger.info("User is logged in.");
    }
    
    
    @When("the user enters the username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
    	signinPage.enterEmail(username);
    	signinPage.enterPassword(password);
    	logger.info("Entered username: {}", username);
        logger.info("Entered password: {}", password);
    }

   

    @When("clicks on the Sign-In button")
    public void clicks_on_the_sign_in_button() {
    	signinPage.clickSignIn();
        logger.info("Clicked on Sign-In button.");
    }

    
}
