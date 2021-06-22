package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	private static String path ="./src/test/resources/testdata/OpenCartTestData.xlsx"; 
	private static Workbook workbook;
	private static Sheet sheet;
	static int rows;
	static int cols;
		
	public static Object[][] getData(String sheetName) {
		 Object[][] data = null;
		try {
			FileInputStream ip = new FileInputStream(path);
			workbook=WorkbookFactory.create(ip);
			sheet= workbook.getSheet(sheetName);
			rows= sheet.getLastRowNum();
			cols=sheet.getRow(0).getLastCellNum();
			
		  data = new Object[rows][cols];
		 	for(int i=1;i<rows;i++) {
		 		for(int j=0;j<cols;j++) {
		 			data[i][j]= sheet.getRow(i).getCell(j).toString();
		 			System.out.println("val of FIle stream:-" +data[i][j]);
		 		}
		 	}
		
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}	 return data;	
	}
	
}
