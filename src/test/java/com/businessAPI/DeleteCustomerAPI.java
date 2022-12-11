package com.businessAPI;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.setUp.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest {

	public static Response sendDelRequestToDeleteCustomerwithValidID(Hashtable<String, String> data) {

		Response res = given().auth().basic(conf.getProperty("validSecret"), "")
				.delete(conf.getProperty("customerEndPoint")+"/"+data.get("id"));

		return res;

	}

}
