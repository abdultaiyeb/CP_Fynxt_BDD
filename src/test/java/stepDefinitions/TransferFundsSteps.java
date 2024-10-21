package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pageObjects.MyAccounts_TransferFunds;
import pageObjects.Navigation;
import factory.BaseClass;

public class TransferFundsSteps extends BaseClass {

    private Navigation navigation;
    private MyAccounts_TransferFunds transferFunds;

   

    @When("the user navigates to the My Wallet page")
    public void the_user_navigates_to_the_my_wallet_page() {
        navigation = new Navigation(driver);
        navigation.clickOnMyWallet();
        logger.info("User navigated to My Wallet page.");
    }

    @And("the user clicks on the Transfer Funds option")
    public void the_user_clicks_on_the_transfer_funds_option() {
        navigation.clickOnTransferFunds();
        logger.info("User clicked on the Transfer Funds option.");
    }

    @And("the user selects {string} as the source wallet")
    public void the_user_selects_source_wallet(String fromWallet) {
        transferFunds = new MyAccounts_TransferFunds(driver);
        transferFunds.selectFromWallet(fromWallet);
        logger.info("User selected from wallet: " + fromWallet);
    }

    @And("the user selects {string} as the destination wallet")
    public void the_user_selects_destination_wallet(String toWallet) {
        transferFunds.selectToWallet(toWallet);
        logger.info("User selected to wallet: " + toWallet);
    }

    @And("the user enters {string} as the transfer amount")
    public void the_user_enters_transfer_amount(String amount) {
        transferFunds.enterAmount(amount);
        logger.info("User entered transfer amount: " + amount);
    }

    @And("the user clicks on the confirm transfer button")
    public void the_user_clicks_on_the_confirm_transfer_button() {
        transferFunds.clickConfirmTransfer();
        logger.info("User clicked on the confirm transfer button.");
    }


    @Then("the user should see a success message {string}")
    public void the_user_should_see_a_success_message(String expectedMessage) {
        String actualMessage = transferFunds.getSuccessMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Success message does not match the expected value.");
        logger.info("Fund transfer successful. Success message verified.");
    }
}
