package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

    protected static WebDriver driver;
    static Properties properties;
    protected static Logger logger;

    public static WebDriver initializeBrowser() throws IOException {
        properties = getProperties();  // Load properties here
        String executionEnv = properties.getProperty("execution_env");
        String browser = properties.getProperty("browser").toLowerCase();
        String os = properties.getProperty("os").toLowerCase();

        if (executionEnv.equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            // OS Configuration
            switch (os) {
                case "windows":
                    capabilities.setPlatform(Platform.WINDOWS);
                    break;
                case "mac":
                    capabilities.setPlatform(Platform.MAC);
                    break;
                case "linux":
                    capabilities.setPlatform(Platform.LINUX);
                    break;
                default:
                    System.out.println("No matching OS");
                    return null;
            }

            // Browser Configuration
            switch (browser) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("No matching browser");
                    return null;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } else if (executionEnv.equalsIgnoreCase("local")) {
            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("No matching browser");
                    driver = null;
            }
        }

        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        }

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties getProperties() throws IOException {
        if (properties == null) {  // Only load if not already loaded
            FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
            properties = new Properties();
            properties.load(file);
        }
        return properties;
    }

    public static Logger getLogger() {
        logger = LogManager.getLogger();
        return logger;
    }

    public static String getProperty(String key) {
        if (properties == null) {
            try {
                getProperties();  
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }
}
