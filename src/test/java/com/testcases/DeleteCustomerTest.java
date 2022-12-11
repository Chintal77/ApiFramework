package com.testcases;

import org.apache.poi.ss.usermodel.DateUtil;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.businessAPI.CreateCustomerAPI;
import com.businessAPI.DeleteCustomerAPI;
import com.google.gson.JsonObject;
import com.setUp.BaseTest;
import com.utilities.DataUtils;
import com.utilities.TestUtils;

import extentlisteners.ExtentListeners;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class DeleteCustomerTest extends BaseTest {

	@Test(priority = 1, dataProviderClass = DataUtils.class, dataProvider = "data")
	public void deleteCustomer(Hashtable<String, String> data)

	{

		
		Response res = DeleteCustomerAPI.sendDelRequestToDeleteCustomerwithValidID(data);
		res.prettyPrint();
		ExtentListeners.testReport.get().info(data.toString());	
		//System.out.println("Deleted id form the respomse : "+res.jsonPath().get("id").toString());
		String fetched = res.jsonPath().get("id").toString();
		int status=res.getStatusCode();
		
		
		System.out.println(status);
		Assert.assertEquals(fetched, data.get("id"),"Id Not Matched");
//		Assert.assertEquals(status, 200);
//		
//		Assert.assertTrue(TestUtils.JsonHasKey(res.asString(), "id"),"Id Not Matched");
//		
		
		
	}
}
