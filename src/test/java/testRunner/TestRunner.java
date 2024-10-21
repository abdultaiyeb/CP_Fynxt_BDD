package testRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import java.io.File;
import java.awt.Desktop;
import java.io.IOException;


@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//Features/login.feature",".//Features/AccountRegistration.feature", ".//Features/Create_mt4_account.feature",".//Features/Transfer_funds.feature"},
					
					//features= {"@target/rerun.txt"},
					glue={"stepDefinitions","hooks"},
					plugin= {
								"pretty", "html:reports/myreport.html",   
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"rerun:target/rerun.txt",
							
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true   // to publish report in cucumber server
					
		)
public class TestRunner {
	 @AfterClass
	    public static void openReport() {
	        try {
	            File reportFile = new File("Reports/myreport.html");

	            if (Desktop.isDesktopSupported()) {
	                Desktop.getDesktop().browse(reportFile.toURI()); 
	            } else {
	                System.out.println("Desktop is not supported. Unable to open the report.");
	            }
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
	    }
}


