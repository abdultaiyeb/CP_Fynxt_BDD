package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.logging.Logger;

public class Dashboard extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Dashboard.class.getName());

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/form[@novalidate='novalidate']/div/h5[1]")
    private WebElement dashboardHeading;

    public String verifyDashboardHeading() {
        
        String actualText = dashboardHeading.getText().trim();
        
        
        return actualText;
    }
}
