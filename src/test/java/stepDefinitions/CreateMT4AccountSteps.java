package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.SigninPage;
import pageObjects.SignupPage;
import factory.BaseClass;
import org.apache.logging.log4j.Logger;
import pageObjects.MyAccounts_CreateAccountMT4;
import pageObjects.Navigation;

public class CreateMT4AccountSteps {
    private Faker faker = new Faker();
    private WebDriver driver;  // Declare the driver
    private Navigation navigation;
    private MyAccounts_CreateAccountMT4 createAccountPage;
    private static final Logger logger = BaseClass.getLogger(); 

    // Constructor to initialize WebDriver and Page Objects
    public CreateMT4AccountSteps() {
        this.driver = BaseClass.getDriver(); // Get the WebDriver from BaseClass
        this.navigation = new Navigation(driver);
        this.createAccountPage = new MyAccounts_CreateAccountMT4(driver);
    }

    @When("the user navigates to the My Accounts page")
    public void the_user_navigates_to_the_my_accounts_page() {
        navigation.clickOnMyAccounts();
        logger.info("Navigated to My Accounts page.");
    }

    @When("the user clicks on the Create Account option")
    public void the_user_clicks_on_the_create_account_option() {
        navigation.clickOnCreateAccount();
        logger.info("Clicked on Create Account option.");
    }

    @When("the user selects {string} as the trading platform")
    public void the_user_selects_as_the_trading_platform(String tradingPlatform) {
        createAccountPage.selectTradingPlatformOption(tradingPlatform);
        logger.info("Selected trading platform: " + tradingPlatform);
    }

    @When("the user enters a random account name")
    public void the_user_enters_a_random_account_name() {
        String accountName = faker.letterify("?????");
        createAccountPage.setAccountName(accountName);
        logger.info("Entered random account name: " + accountName);
    }

    @When("the user selects {string} as the wallet option")
    public void the_user_selects_as_the_wallet_option(String walletOption) {
        createAccountPage.selectWalletOption(walletOption);
        logger.info("Selected wallet option: " + walletOption);
    }

    @When("the user sets the deposit amount to {string}")
    public void the_user_sets_the_deposit_amount_to(String depositAmount) {
        createAccountPage.setAmount(depositAmount);
        logger.info("Set deposit amount to: " + depositAmount);
    }

    @When("the user confirms account creation")
    public void the_user_confirms_account_creation() {
        createAccountPage.clickIConfirm();
        logger.info("User confirmed account creation.");
    }

    @When("the user clicks the Create Account button")
    public void the_user_clicks_the_create_account_button() {
        createAccountPage.clickCreateAccountBtn();
        logger.info("Clicked on Create Account button.");
    }

    @Then("the user should see the newly created MT4 account number")
    public void the_user_should_see_the_newly_created_mt4_account_number() {
        String mt4AccountNumber = createAccountPage.getMT4AccountNumber();
        logger.info("MT4 Account created with number: " + mt4AccountNumber);
        Assert.assertNotNull(mt4AccountNumber, "MT4 account number should not be null.");
    }

    @Then("the user dismisses the account creation modal")
    public void the_user_dismisses_the_account_creation_modal() {
        createAccountPage.clickDismissModal();
        logger.info("Dismissed the account creation modal.");
    }
}
