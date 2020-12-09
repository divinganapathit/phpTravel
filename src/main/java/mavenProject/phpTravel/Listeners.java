package mavenProject.phpTravel;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners extends TestEnvironment implements ITestListener{
	
 
    public void onFinish(ITestContext result) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onStart(ITestContext result) {					
        // TODO Auto-generated method stub
        		
    }		

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestFailure(ITestResult result) {	
    	BasePage objBasePage = new BasePage(TestEnvironment.driver);
    	try {
			objBasePage.getScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		
    }		

    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub
    	Reporter.log("Method to be executed: " + result.getName());
        		
    }		

    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub	
    	Reporter.log("Status of execution"+result.getStatus());
        		
    }

}
