package Sample_Test;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.BaseClass;

public class Listeners implements ITestListener{

	
	BaseClass obj = new BaseClass();
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("Test started" );
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("Test executed successfully " );
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		try {
			obj.getScreenshot(result.getName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Test executed failed " );
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("Test skipped successfully " );
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test executed completed " );
	}

}
