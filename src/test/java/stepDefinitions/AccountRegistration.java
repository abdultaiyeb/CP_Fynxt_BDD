package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.SigninPage;
import pageObjects.SignupPage;
import factory.BaseClass;
import org.apache.logging.log4j.Logger;

public class AccountRegistration {

    private static final Logger logger = BaseClass.getLogger(); 
    private WebDriver driver = BaseClass.getDriver();
    private SigninPage signinPage = new SigninPage(driver);
    private SignupPage signupPage = new SignupPage(driver);
    private Faker faker = new Faker();  
    private String email;  

   

    @When("the user clicks on the Sign-Up button")
    public void the_user_clicks_on_the_sign_up_button() {
        signinPage.clickSignUp();
        logger.info("Clicked on Sign-Up button");
    }

    @And("the user enters a random username")
    public void the_user_enters_a_random_username() {
        String username = faker.name().username(); 
        signupPage.enterUserName(username);
        logger.info("Entered random username: {}", username);
    }

    @And("the user enters a random first name")
    public void the_user_enters_a_random_first_name() {
        String firstName = faker.name().firstName();
        signupPage.enterFirstName(firstName);
        logger.info("Entered random first name: {}", firstName);
    }

    @And("the user enters a random last name")
    public void the_user_enters_a_random_last_name() {
        String lastName = faker.name().lastName();
        signupPage.enterLastName(lastName);
        logger.info("Entered random last name: {}", lastName);
    }

    @And("the user enters a random email address")
    public void the_user_enters_a_random_email_address() {
        email = faker.internet().emailAddress();
        signupPage.enterEmailAddress(email);
        logger.info("Entered random email address: {}", email);
    }

    @And("the user confirms the entered email address")
    public void the_user_confirms_the_entered_email_address() {
        signupPage.enterConfirmEmailAddress(email);
        logger.info("Entered confirmation email address: {}", email);
    }

    @And("the user enters a random password")
    public void the_user_enters_a_random_password() {
        String password = generatePassword(); 
        signupPage.enterPassword(password);
        logger.info("Entered random password: {}", password); 
    }

    @And("the user enters a random phone number")
    public void the_user_enters_a_random_phone_number() {
        String phoneNumber = generatePhoneNumber();
        signupPage.enterPhoneNumber(phoneNumber);
        logger.info("Entered random phone number: {}", phoneNumber);
    }

    @And("the user clicks the Sign-Up button")
    public void the_user_clicks_the_sign_up_button() {
        signupPage.clickSignUpButton();
        logger.info("Clicked on Sign-Up button");
    }

    @Then("the account should be successfully created")
    public void the_account_should_be_successfully_created() {       
        // You may want to add a verification step here.
        logger.info("Account registration successful.");
    }

    private String generatePassword() {
        return faker.internet().password(8, 12, true, true, true);
    }

    private String generatePhoneNumber() {
    	 String prefix = "8866";
    	    String randomDigits = String.format("%06d", faker.number().numberBetween(0, 999999));
    	    return prefix + randomDigits;    }
}
