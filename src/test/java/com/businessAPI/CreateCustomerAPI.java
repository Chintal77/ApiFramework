package com.businessAPI;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.setUp.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest{

	public static Response sendPostRequestToCreateCustomerwithValidKey(Hashtable<String, String> data) {

		Response res = given().auth().basic(conf.getProperty("validSecret"), "").formParam("name", data.get("name"))
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(conf.getProperty("customerEndPoint"));
		
		return res;
		
	}

	public static Response sendPostRequestToCreateCustomerwithinValidKey(Hashtable<String, String> data) {

		Response res = given().auth().basic(conf.getProperty("invalidSecret"), "").formParam("email", data.get("email"))
				.formParam("description", data.get("description")).post(conf.getProperty("customerEndPoint"));
		
		return res;
	}

}
