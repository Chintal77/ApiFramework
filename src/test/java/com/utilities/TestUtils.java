package com.utilities;

import org.json.JSONObject;

public class TestUtils {
	
	public static boolean JsonHasKey(String json, String key)
	{
		
		JSONObject obj = new JSONObject(json);
		return obj.has(key);
		
	}

}
