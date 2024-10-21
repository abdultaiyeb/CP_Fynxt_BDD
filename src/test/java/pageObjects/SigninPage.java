package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends BasePage {
	 public SigninPage(WebDriver driver) {
	        super(driver);
	    }
	 
    @FindBy(xpath = "//button[@id='btnLoginSignupFlip']")
    private WebElement signUpBtn;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailTxt;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTxt;

    @FindBy(xpath = "//button[@id='btnCustomerLogin']")
    private WebElement signInBtn;

    @FindBy(xpath = "//div[@aria-live='assertive']//div")
    private WebElement errorTxt;

   

    public void clickSignUp() {
        waitAndClick(signUpBtn);
    }

    public void enterEmail(String username) {
        waitAndClearAndSendKeys(emailTxt, username);
    }

    public void enterPassword(String password) {
        waitAndClearAndSendKeys(passwordTxt, password);
    }

    public void clickSignIn() {
        waitAndClick(signInBtn);
    }

    public boolean isErrorVisible() {
        waitForVisibility(errorTxt);
        return errorTxt.isDisplayed();
    }
}
