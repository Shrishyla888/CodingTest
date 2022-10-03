package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author 91636
 *
 */
public class ExcelUtility 	
{
	/**
	 * to read data from the excel 
	 * @return
	
	 */

	public String readExcelData(String name,int row ,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/ddt.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(name);
		Row roW = sheet.getRow(row);
		Cell cell1 = roW.getCell(cell);
		String value = cell1.toString();
		return value;
	}
	
	/**
	 * to write data from excel
	 * @return
	 */
	public String writeExcelData(String name,int row ,int cell,String data) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/ddt.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(name);
		Row roW = sheet.getRow(row);
		Cell cell1 = roW.getCell(cell);
		cell1.setCellValue(name);
		FileOutputStream fout= new FileOutputStream("./src/test/resources/ddt.xlsx");
		book.write(fout);
		return data;
	}
	
	
}
