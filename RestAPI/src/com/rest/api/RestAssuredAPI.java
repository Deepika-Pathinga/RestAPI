package com.rest.api;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredAPI {
	JSONParser parser = new JSONParser();
	
	@Test(priority =1)
	public void question1_1_Get_UserNameValue() throws FileNotFoundException, IOException, ParseException {
		Object obj = parser.parse(new FileReader("C:\\Users\\deepi\\eclipse-workspace\\RestAPI\\Question1Data.json"));
		JSONObject jsonUserName = (JSONObject) obj;
		String username = (String) jsonUserName.get("username");
		System.out.println();
		System.out.println("Question 1_1: Get username:");
		System.out.println("username: "+username);
		System.out.println();		
	}
	
	@Test(priority=2)
	public void question1_2_GetAll_SessionIDValues() throws FileNotFoundException, IOException, ParseException {
		Object obj = parser.parse(new FileReader("C:\\Users\\deepi\\eclipse-workspace\\RestAPI\\Question1Data.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		JSONArray sessionID = (JSONArray) jsonObject.get("sessionid");
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> itSession = sessionID.iterator();
		System.out.println("Question 1_2: Get all Session IDs:");
		while(itSession.hasNext()) {
			System.out.println(itSession.next());
		}
		System.out.println();				
	}
	
	@Test(priority=3)
	public void question1_3_GetLastValue_SessionID() throws FileNotFoundException, IOException, ParseException {
		Object obj = parser.parse(new FileReader("C:\\Users\\deepi\\eclipse-workspace\\RestAPI\\Question1Data.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		JSONArray sessionID = (JSONArray) jsonObject.get("sessionid");
		//System.out.println(sessionID.size());
		System.out.println("Question 1_3: Get last Session ID:");
		int last_session = sessionID.size()-1;
		int count =0;
		@SuppressWarnings("unchecked")
		Iterator<JSONObject> itSession = sessionID.iterator();
		while(itSession.hasNext()) {
			count++;
			itSession.next();
			if(count==last_session) {
				System.out.println(itSession.next());
			}			
		}
		System.out.println();			
	}
	
	@Test(priority=4)
	public void question1_4_GetAllMarks_SecondStudent() throws FileNotFoundException, IOException, ParseException {
		Object obj = parser.parse(new FileReader("C:\\Users\\deepi\\eclipse-workspace\\RestAPI\\Question1Data.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray students = (JSONArray) jsonObject.get("students");
		ObjectMapper map = new ObjectMapper();
		if(students!=null) {
			System.out.println("Question 1_4: All marks of second student");
			StudentDetails student2 = map.readValue(students.get(1).toString(), StudentDetails.class);
			for(int i =0;i<student2.getMarks().size();i++) {
				System.out.println("Mark "+(i+1)+": "+student2.getMarks().get(i).toString());				
			}	
		}
		System.out.println();
		
	}
	
	@Test(priority=5)
	public void question1_5_GetSecondStateValue_FirstStudent() throws FileNotFoundException, IOException, ParseException {
		Object obj = parser.parse(new FileReader("C:\\Users\\deepi\\eclipse-workspace\\RestAPI\\Question1Data.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray students = (JSONArray) jsonObject.get("students");
		ObjectMapper map = new ObjectMapper();
			
		if(students!=null) {			
			StudentDetails student1 = map.readValue(students.get(0).toString(), StudentDetails.class);
			System.out.println("Question 1_5: Second state of the first student:");			
			System.out.println("State 2: "+student1.getAddress().get(1).getState().toString());	
			System.out.println();						
		}		
	}
	
	@Test(priority=6)
	public void question1_6_GetSecondContactValue_FirstStudent() throws FileNotFoundException, IOException, ParseException {
		Object obj = parser.parse(new FileReader("C:\\Users\\deepi\\eclipse-workspace\\RestAPI\\Question1Data.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray students = (JSONArray) jsonObject.get("students");
		ObjectMapper map = new ObjectMapper();
		if(students!=null) {			
			StudentDetails student1 = map.readValue(students.get(0).toString(), StudentDetails.class);
			System.out.println("Question 1_6: Second contact of the first student:");			
			System.out.println("Contact 2: "+student1.getContact().get(1).toString());	
			System.out.println();
						
		}
	}
	
	@Test(priority=7)
	public void question1_7_GetAllCities_SecondStudent() throws FileNotFoundException, IOException, ParseException {
		Object obj = parser.parse(new FileReader("C:\\Users\\deepi\\eclipse-workspace\\RestAPI\\Question1Data.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray students = (JSONArray) jsonObject.get("students");
		ObjectMapper map = new ObjectMapper();
		if(students!=null) {
			System.out.println("Question 1_7: All cities of second student");
			StudentDetails student2 = map.readValue(students.get(1).toString(), StudentDetails.class);
			for(int i =0;i<student2.getAddress().size();i++) {
				System.out.println("City "+(i+1)+": "+student2.getAddress().get(i).getCity().toString());				
			}	
		}
		System.out.println();
		
	}
	
	@Test(priority=8)
	public void question1_8_GetContacts_AllStudents() throws FileNotFoundException, IOException, ParseException {
		Object obj = parser.parse(new FileReader("C:\\Users\\deepi\\eclipse-workspace\\RestAPI\\Question1Data.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray students = (JSONArray) jsonObject.get("students");
		ObjectMapper map = new ObjectMapper();
		if(students!=null) {
			System.out.println("Question 1_8: Contacts of all students");
			StudentDetails student1 = map.readValue(students.get(0).toString(), StudentDetails.class);
			System.out.println(student1.getContact().toString());
			StudentDetails student2 = map.readValue(students.get(1).toString(), StudentDetails.class);
			System.out.println(student2.getContact().toString());			
		}
		System.out.println();
	}
	
	@Test(priority=9)
	public void question1_9_GetAddress_FirstStudent() throws FileNotFoundException, IOException, ParseException {
		ObjectMapper map = new ObjectMapper();
		Object obj = parser.parse(new FileReader("C:\\Users\\deepi\\eclipse-workspace\\RestAPI\\Question1Data.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray students = (JSONArray) jsonObject.get("students");
			
		if(students!=null) {			
			StudentDetails student1 = map.readValue(students.get(0).toString(), StudentDetails.class);
			System.out.println("Question 1_9: First Student Address:");
			for(int i =0;i<student1.getAddress().size();i++) {
				System.out.println("State "+(i+1)+": "+student1.getAddress().get(i).getState().toString()+" and City "+(i+1)+": "
		  	       +student1.getAddress().get(i).getCity().toString());				
			}			
		}
		System.out.println();
	}
	
	@Test(priority=10)
	public void question2_1_Get_UserID7AndTitle() {
		
		Response response = RestAssured.given().when()
							.get("https://jsonplaceholder.typicode.com/posts")
							.then().statusCode(200).
							assertThat().contentType("application/json")
							.extract().response();
		List<HashMap<String,String>> jsonResponse = response.jsonPath().get("$");
		System.out.println("Question 2: Get userId 7 and Title:");
		int count=0;
		for(int i=0; i<jsonResponse.size();i++) {
			String userID = String.valueOf(jsonResponse.get(i).get("userId"));
			if(userID.contentEquals("7")) {
				count++;				
				System.out.println(count+". user ID: "+userID+" Title: "+jsonResponse.get(i).get("title"));
				
			}
		}
		System.out.println();
	}

}
