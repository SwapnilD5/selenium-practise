package com.selenium.keyworddriven;

import java.io.*;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) throws Exception{

	String projectPath=System.getProperty("user.dir");
	
    FileInputStream fin=new FileInputStream(projectPath+"\\config.properties");
	
    Properties prop=new Properties();
    prop.load(fin);
   // prop.getProperty("url")
    
    System.out.println(prop.getProperty("url"));
    System.out.println(prop.getProperty("browser"));
    
	}

}



