package com.setUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {

	public static Properties conf = new Properties();
	private FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(
			".\\src\\test\\resources\\excel_data\\testdata.xlsx");

	@BeforeSuite
	public void setUp() {
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conf.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestAssured.baseURI = "https://api.stripe.com";
		//RestAssured.basePath = conf.getProperty("basePath");
		RestAssured.basePath = "/v1";
	}

	@AfterSuite
	public void tearDown() {

	}

}
