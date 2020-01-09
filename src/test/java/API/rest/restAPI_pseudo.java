package API.rest;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class restAPI_pseudo 
{
    
	public void testrun()
	{
    	
    	payload p=new payload();
    	
		RestAssured.baseURI="http://216.10.245.166";
		//key= qaclick123
		Response res=given().queryParam("key", "qaclick123").
		body(p.addplace().toString()).expect().defaultParser(Parser.JSON).log().all().
		when().post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().header("Content-Type", "application/json;charset=UTF-8").and()
		.body("status",equalTo("OK")).extract().response();
		
		
		
		System.out.println(res.toString());
		
		
		
		
		//JsonPath js= new JsonPath(res.asString());
		
		//System.out.println(js.get("status"));

	}
    
    
    @Test
    public void getdata()
    {
    	RestAssured.baseURI="https://maps.googleapis.com";
    	///place/nearbysearch/json
    	
    	
    	Response res=given().param("location", "-33.8670522,151.1957362").param("radius", "1500").
    	param("type", "restaurant").param("keyword", "cruise").param("key", "AIzaSyDVhs-RJqoIrXVRbY3o_EC5jq2R48VkjGY").
    	when().get("/maps/api/place/nearbysearch/json").
    	then().assertThat().statusCode(200).log().all().extract().response();
    	
    	//System.out.println(res.toString()); 
    	System.out.println(res.asString());
    	
    	JsonPath js=new JsonPath(res.asString());
    	
    	String s=js.get("results[0].name");
    	System.out.println("s value is"+s);
    	
    	System.out.println("size of arraylist :"+js.get("results.size()"));
    	
    	
    	
    	for(int i=0;i<js.getInt("results.size()");i++)
    	{
    		
    		String s1="results["+i+"].name";
    		
    		
    		System.out.println(js.get(s1));
    	}
    	
    	
    	//System.out.println(res);
    	
    }

}
