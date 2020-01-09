package API.rest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class payload 
{
  
	public JSONObject addplace()
	{
		JSONObject jo=new JSONObject();
		JSONArray ja=new JSONArray();
		JSONObject ja_1=new JSONObject();
		ja_1.put("lat", -40.383494);
		ja_1.put("lng", 42.427362);
		ja.add("shoe pack");
		ja.add("shop");
		jo.put("location", ja_1);
		jo.put("accuracy", 50);
		jo.put("name","job1");
		jo.put("phone_number","(+91) 983 893 3937");
		jo.put("address", "29, side layout, cohen 09");
		jo.put("types",ja);
		jo.put("website", "http://google.com");
		jo.put("language", "French-IN");
		
		return jo;
		
	}
}
