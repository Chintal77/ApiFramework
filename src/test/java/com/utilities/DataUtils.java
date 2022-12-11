package com.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.setUp.BaseTest;

public class DataUtils extends BaseTest {

	
	
	@DataProvider(name="data")
	public Object[][] getData(Method m ) {

		ExcelReader ex = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\excel_data\\testdata.xlsx");
		int rows = ex.getRowCount(Constants.DATA_Sheet);
		System.out.println("Total rows are : " + rows);
		int col = ex.getColumnCount(Constants.DATA_Sheet);
		System.out.println("Total columns are : " + col);

		String testname = m.getName();
		System.out.println(testname);
		// String testname = "OpenAccountTest";

		// Code to find row no. of testcase starting point
		int tcRowNum = 1;

		for (tcRowNum = 1; tcRowNum <= rows; tcRowNum++) {
			String tcName = ex.getCellData(Constants.DATA_Sheet, 0, tcRowNum);

			if (tcName.equalsIgnoreCase(testname))
				break;
		}

		System.out.println("==============================================");
		System.out.println("TestCase Starts from row : " + tcRowNum);
		System.out.println("==============================================");

		// Checking total no. of rows associated to a single testcase
		int dataStartRowNum = tcRowNum + 2;
		int testrows = 0;

		while (!ex.getCellData(Constants.DATA_Sheet, 0, dataStartRowNum + testrows).equals("")) {
			testrows++;
		}

		System.out.println("==============================================");
		System.out.println("Total Rows of Data : " + testrows);
		System.out.println("==============================================");

		// Checking total no. of columns associated to a single testcase
		int testcol = 0;
		int colStartColNum = tcRowNum + 1;

		while (!ex.getCellData(Constants.DATA_Sheet, testcol, colStartColNum).equals("")) {
			testcol++;
		}

		System.out.println("==============================================");
		System.out.println("Total column count : " + testcol);
		System.out.println("==============================================");

		// printing data associated with a single testcase

		Object[][] data = new Object[testrows][1];

		int i = 0;
		for (int rnum = dataStartRowNum; rnum < (dataStartRowNum + testrows); rnum++) {
			Hashtable<String, String> tb = new Hashtable<String, String>();
			for (int cnum = 0; cnum < testcol; cnum++) {
				String testData = ex.getCellData(Constants.DATA_Sheet, cnum, rnum);
				String colName = ex.getCellData(Constants.DATA_Sheet, cnum, colStartColNum);

				tb.put(colName, testData);
			}

			data[i][0] = tb;
			i++;

		}

		return data;

	}

}
