package stepDefinitions;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import factory.BaseClass;
import io.cucumber.java.*;

public class Hooks {

	 WebDriver driver;
	 Properties p;
    
	@Before
   public void setup() throws IOException
   {
   	driver=BaseClass.initializeBrowser(); 	    	
   	p=BaseClass.getProperties();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
   	driver.get(p.getProperty("appURL"));
   	driver.manage().window().maximize();
   			
	}
		
   
   @After
   public void tearDown() {     		
      driver.quit();    
   }
   

   @AfterStep
   public void addScreenshot(Scenario scenario) {      
       if(scenario.isFailed()) {     	
       	TakesScreenshot ts=(TakesScreenshot) driver;
       	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
       	scenario.attach(screenshot, "image/png",scenario.getName());     	            
       }   
   }
  
   
   
}
