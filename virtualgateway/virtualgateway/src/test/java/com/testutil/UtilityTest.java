package com.testutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.TestBase;

public class UtilityTest extends TestBase{
	public static Workbook book;
	public static Sheet sheet;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\mv114t\\virtualgateway\\src\\test\\java\\com\\testdata\\CRMtestdata.xlsx";
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	public int sendrownumber(String sheetName) {
		sheet = book.getSheet(sheetName);
		return sheet.getLastRowNum();
	}
	public int sendcolnumber(String sheetName) {
		sheet = book.getSheet(sheetName);
		return sheet.getRow(0).getLastCellNum();
	}
}
