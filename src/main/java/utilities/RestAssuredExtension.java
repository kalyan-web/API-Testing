package utilities;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredExtension {
	
	public static String BaseURI;
	public static RequestSpecification rspec;
	public static PropertiesConfiguration config;
	public RequestSpecBuilder builder;
	public ResponseSpecBuilder rsbuilder;
	public static ResponseSpecification responseSpecs;
	public static final String userDir = System.getProperty("user.dir").replace("\\","/");
	public String ConfigFile=userDir+"//ConfigFiles//Config.properties";
	
	public RestAssuredExtension() throws ConfigurationException{
		try {
			config = new PropertiesConfiguration(ConfigFile);
			builder = new RequestSpecBuilder();
			rsbuilder = new ResponseSpecBuilder();
			rsbuilder.expectStatusCode(200);
			rsbuilder.expectContentType(ContentType.JSON);
			responseSpecs = rsbuilder.build();
			builder.setBaseUri(BaseURI);
			builder.setContentType(ContentType.JSON);
			rspec = builder.build();
		}
		catch (Exception e){
			
		}
		
		
		
	}

}
