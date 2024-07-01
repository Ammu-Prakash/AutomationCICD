package Ammu.resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReporterObject()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"\\reports\\index.html"));
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ammu Prakash");
		return extent;
	}

}
