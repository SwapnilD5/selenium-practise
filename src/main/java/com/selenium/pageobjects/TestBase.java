package com.selenium.pageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class TestBase {

	static String projectPath = System.getProperty("user.dir");
	static FileInputStream fin;
	static Properties prop;

	public static void testBase() throws Exception {

		try {
			fin = new FileInputStream(projectPath + "\\configbase.properties");
			 prop = new Properties();
			prop.load(fin);
		} catch (Exception e) {

			System.out.println("File Not found !!!");
		}

	}

	public static void initialize() throws Exception {
				
		testBase();
		if (prop.getProperty("os").equalsIgnoreCase("window")) {
			
			fin = new FileInputStream(projectPath + "\\config_window.properties");
			 prop = new Properties();
			prop.load(fin);

		}else if (prop.getProperty("os").equalsIgnoreCase("mac")) {
			
			fin = new FileInputStream(projectPath + "\\config.properties");
			 prop = new Properties();
			prop.load(fin);
			
		}else if (prop.getProperty("os").equalsIgnoreCase("linux")) {
		
			fin = new FileInputStream(projectPath + "\\config_linux.properties");
			 prop = new Properties();
			prop.load(fin);
		}


	}

}
