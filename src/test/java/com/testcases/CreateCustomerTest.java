package com.testcases;

import org.apache.poi.ss.usermodel.DateUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.businessAPI.CreateCustomerAPI;
import com.setUp.BaseTest;
import com.utilities.DataUtils;

import extentlisteners.ExtentListeners;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class CreateCustomerTest extends BaseTest {

	@Test(priority = 1, dataProviderClass = DataUtils.class, dataProvider = "data")
	public void validSecret(Hashtable<String, String> data)

	{
		Response res = CreateCustomerAPI.sendPostRequestToCreateCustomerwithValidKey(data);
		System.out.println(res.prettyPrint());
		ExtentListeners.testReport.get().info(data.toString());	
		System.out.println(res.getStatusCode());
	}

	@Test(priority = 2, dataProviderClass = DataUtils.class, dataProvider = "data")
	public void invalidSecret(Hashtable<String, String> data)

	{
		
		Response res = CreateCustomerAPI.sendPostRequestToCreateCustomerwithinValidKey(data); 		
		System.out.println(res.prettyPrint());
		ExtentListeners.testReport.get().info(data.toString());
		int act_code = res.getStatusCode();

		System.out.println(act_code);

		Assert.assertEquals(act_code, 200);
	}

}
