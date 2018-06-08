package com.actiTIME.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Priya
 *
 */
public class FileDataLib {
	
	/* path for the test data files */
	String pathFile = "./Test_Data/CommonData.properties";
	String pathExcel = "./Test_Data//TestData.xlsx";
	
	/**
	 * This method with return the object of the Properties class which is pointing to the property file
	 * @return object of Properties class
	 * @throws Throwable 
	 */
	public Properties getPropertiesFileObject() throws Throwable {
		/* Get the java object of the physical file in read mode */
		FileInputStream fObj = new FileInputStream(pathFile);
		Properties pObj = new Properties();
		pObj.load(fObj);
		return pObj;
	}
		
	/**
	 * This method will read the data from workbook(excel) 
	 * from the given sheet name, row number and column number.
	 * @param sheetName - Enter the Sheet Name
	 * @param rowNumRead - Enter the Row Number 
	 * @param colNumRead - Enter the Column Number 
	 * @return - returns string data from the cell which is at that particular row number and column number 
	 * @throws Throwable 
	 */
	public String getExcelData(String sheetName, int rowNumRead, int colNumRead) throws Throwable {
		/* Get the Java object of the physical excel file */ 
		FileInputStream fObj = new FileInputStream(pathExcel);
		/* Open workbook in read mode */
		Workbook wb = WorkbookFactory.create(fObj);
		/* Get the control of the sheet */
		Sheet sh = wb.getSheet(sheetName);
		/* Get the control of the row */
		Row row = sh.getRow(rowNumRead);
		/* Get the data from the specific cell at the rowNum and colNum */
		String data = row.getCell(colNumRead).getStringCellValue();
		/* close the workbook*/
		wb.close();
		/* return data */
		return data;
	}
	
	/**
	 * This method will write the data in the workbook(excel) 
	 * at the given sheet, at the specific row number and column number.
	 * @param sheetName - Enter the sheet name where you want to write the data
	 * @param rowNumWrite - Enter row number to read data
	 * @param colNumWrite - Enter column number to read data
	 * @param dataToEnter - Enter the data for new cell
	 * @throws Throwable
	 */
	public void setExcelData(String sheetName, int rowNumWrite, int colNumWrite, String dataToEnter) throws Throwable {
		/* Get the Java object of the physical excel file in read mode */
		FileInputStream fObj = new  FileInputStream(pathExcel);
		/* open the file in read only mode */
		Workbook wb = WorkbookFactory.create(fObj);
		/* Get control of the sheet */
		Sheet sh = wb.getSheet(sheetName);
		/* Get control of the row */
		Row row = sh.getRow(rowNumWrite);
		/* Create a new cell and set data in the cell */
		row.createCell(5).setCellValue(dataToEnter);
		/* Get the java object of the physical excel file in write mode */
		FileOutputStream fOs = new FileOutputStream(pathExcel);
		/* Write in the workbook */
		wb.write(fOs);
		/* close the workbook */
		wb.close();
	}
}
