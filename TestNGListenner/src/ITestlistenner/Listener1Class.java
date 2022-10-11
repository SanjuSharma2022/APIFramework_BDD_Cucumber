package ITestlistenner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener1Class implements ITestListener {
	
	@Override
	public void onTestStart (ITestResult result) {
		System.out.println("Test Method "+result.getName()+ " Starts");
	}
	@Override
	public void onTestSuccess (ITestResult result) {
		System.out.println("Test Method "+result.getName()+ " passes");
	}
	@Override
	public void onTestFailure (ITestResult result) {
		System.out.println("Test Method "+result.getName()+ " fails");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Method "+result.getName()+ " skips");
	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Method "+context.getName()+ " Start");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Method "+context.getName()+ " End");
	}
	

}
