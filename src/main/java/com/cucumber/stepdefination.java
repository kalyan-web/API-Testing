package com.cucumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import io.cucumber.java.en.And;
//import io.cucumber.core.gherkin.vintage.internal.gherkin.ast.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.RestAssuredExtension;



public class stepdefination<RequestSpecification> {

	public static String BaseURI ="https://api.ratesapi.io/api";
	
	public RequestSpecification request;
	public static Response response;
	
	@When("^I make a request with \"(.*?)\" Date and Base \"(.*?)\"$")
	public void i_make_a_request_with_Date_and_Base(String date, String base/*, DataTable table*/) {
		try {
				response = RestAssured.given().accept("application/JSON")
						.when().get(BaseURI+"/" +date+ "?symbols="+base).then().assertThat().statusCode(200)
						.contentType("application/JSON").extract().response();
				System.out.println("Rate on " +date+" for "+base+" is -->"+response.asString());
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	@When("^I make a request with LatestDate and Base \"(.*?)\"$")
	public void i_make_a_request_with_Date_and_Base(String base) {
		try {
				response = RestAssured.given().accept("application/JSON")
						.when().get(BaseURI+"/" +"latest"+ "?symbols="+base).then().assertThat().statusCode(200)
						.contentType("application/JSON").extract().response();
				System.out.println("Latest Rate for "+base+" is -->"+response.asString());
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
		
	@And("^I got the response and validating with below parameters$")
	public void i_got_the_response_and_validating_with_below_parameters(DataTable table) {
		try {
				HashMap<String, String> Map = new HashMap<String, String>();
				for(DataTableRow row:table.getGherkinRows()) {
					Map.put(row.getCells().get(0),row.getCells().get(1));
				}
			for(Map.Entry<String,String> field: Map.entrySet()) {
				String key = field.getKey();
				System.out.println(key);
				String listValue = response.jsonPath().get(key);
				System.out.println("Actual list of values -->"+listValue);
				assert listValue.equals(field.getValue());
			}
		}
		catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
	}
	



