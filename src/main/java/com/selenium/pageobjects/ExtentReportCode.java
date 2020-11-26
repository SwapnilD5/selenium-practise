package com.selenium.pageobjects;

import java.io.IOException;
import java.util.*;
import org.testng.*;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportCode implements IReporter {
	
	    
	    private static final String OUTPUT_FOLDER = "test-output/";
	    private static final String FILE_NAME = "Extent.html";
	    
	    private ExtentReports extent;

		public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
	        init();
	        
	        for (ISuite suite : suites) {
	            Map<String,ISuiteResult> result = suite.getResults();
	            
	            for (ISuiteResult r : result.values()) {
	                ITestContext context = r.getTestContext();
	                
	                try {
						buildTestNodes(context.getFailedTests(), Status.FAIL);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                try {
						buildTestNodes(context.getSkippedTests(), Status.SKIP);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                try {
						buildTestNodes(context.getPassedTests(), Status.PASS);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                
	            }
	        }
	        
	        for (String s : Reporter.getOutput()) {
	            extent.setTestRunnerOutput(s);
	        }
	        
	        extent.flush();
	    }
	    
	    private void init() {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
	        htmlReporter.config().setDocumentTitle("ExtentReports - Created by TestNG Listener");
	        htmlReporter.config().setReportName("ExtentReports - Created by TestNG Listener");
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        
	        extent.setReportUsesManualConfiguration(true);
	    }
	    
	    private void buildTestNodes(IResultMap tests, Status status) throws Exception {
	        ExtentTest test;
	        
	        if (tests.size() > 0) {
	            for (ITestResult result : tests.getAllResults()) {
	                test = extent.createTest(result.getMethod().getMethodName());
	                
	                for (String group : result.getMethod().getGroups())
	                    test.assignCategory(group);

	                if (result.getThrowable() != null) {
	                    test.log(status, result.getThrowable());
	                    
	                    String filePath=FDObject.captureScreenshot(result, "fail");
	                    
	                    MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(FDObject.projectPath + "\\ScreenShot\\Fail\\"+filePath).build();
	                    test.fail("details", mediaModel);	
	                }
	                else {
	                	 String filePath=FDObject.captureScreenshot(result, "pass");
		                    
		                    MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(FDObject.projectPath + "\\ScreenShot\\Pass\\"+filePath).build();
		                   test.pass("details", mediaModel);	
	                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
	                }
	                
	                test.getModel().setStartTime(getTime(result.getStartMillis()));
	                test.getModel().setEndTime(getTime(result.getEndMillis()));
	            }
	        }
	    }
	    
	    private Date getTime(long millis) {
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTimeInMillis(millis);
	        return calendar.getTime();      
	    }

			
		
	

}
