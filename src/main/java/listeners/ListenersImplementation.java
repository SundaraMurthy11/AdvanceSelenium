package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.BaseClass;

public class ListenersImplementation implements ITestListener, ISuiteListener{

	
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("Reporter Configuration", true);
		Date d= new Date();
		String newDate=d.toString().replaceAll(" ", "_").replace(":", "_");
		spark= new ExtentSparkReporter("./AdvanceReports/report_"+newDate+".html");
		spark.config().setDocumentTitle("NinzaCRM Test Results");
		spark.config().setReportName("CRM Reports");
		spark.config().setTheme(Theme.DARK);
		
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("Browser", "Edge");
		
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("Reporter backup", true);
		report.flush();

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "===="+result.getMethod().getMethodName()+"Execution starts");
		//Reporter.log("===="+result.getMethod().getMethodName()+"Execution starts====",true);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("===="+result.getMethod().getMethodName()+"Execution success====",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName= result.getMethod().getMethodName();
		Reporter.log("===="+testName+"FAILURE===", true);
		
		Date d= new Date();
		String newDate=d.toString().replaceAll(" ", "_").replace(":", "_");
		
		TakesScreenshot ts= (TakesScreenshot)BaseClass.sdriver;
	//	File temp=ts.getScreenshotAs(OutputType.FILE);
		String temp=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp,testName+newDate);
		test.log(Status.FAIL,"==="+testName+"FAILURE");
		
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	
	
}
