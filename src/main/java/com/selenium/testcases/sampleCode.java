package com.selenium.testcases;

import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

class StudentInfo {

public static void assertall(SoftAssert st,ITestResult a) {	
	
	try {
		st.assertAll();
		}catch(Throwable t) {
			
			a.setStatus(a.FAILURE);
			a.setThrowable(t);
		}

}
}
