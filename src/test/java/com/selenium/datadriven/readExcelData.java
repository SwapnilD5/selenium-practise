package com.selenium.datadriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class readExcelData {

	public static void main(String[] args)throws Exception {

        String projectPath=System.getProperty("user.dir");
        DataFormatter df=new DataFormatter();
        
		FileInputStream fin=new FileInputStream(projectPath+"\\testdata\\FDCal.xlsx");		
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		XSSFRow row=sheet.getRow(1);		
		XSSFCell cell=row.getCell(3);
		
		String cellValue=df.formatCellValue(cell);		
		System.out.println(cellValue);
		
		int rowCount=sheet.getLastRowNum();
		
		System.out.println(rowCount);
		
		
	}

}
