package stepDefinations ;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIresources;
import resources.TestDataBuild;
import resources.Utils;

@RunWith(io.cucumber.junit.Cucumber.class)
public class stepDefination extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_Id;
    @Given("Add Place payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws Throwable {
    	
	res=given().spec(requestspecification())
		.body(data.addplacePayload(name, language, address));
		
    }

    @When("user calls {string} using {string} http request")
    public void user_calls_post_http_request(String resource, String method) throws Throwable {
    	
    	APIresources resourceAPI=APIresources.valueOf(resource);
    	System.out.println(resourceAPI.getresource());
    	resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        
        if(method.equalsIgnoreCase("POST"))
        	response = res.when().post(resourceAPI.getresource());
        else if(method.equalsIgnoreCase("GET"))
        	response = res.when().get(resourceAPI.getresource());
        	
    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) throws Throwable {
        assertEquals(response.getStatusCode(),200);
        
    }

    @And("{string} in APIresponse body is {string}")
    public void something_in_APIresponse_body_is_something(String strArg1, String strArg2) throws Throwable {
        assertEquals(getJsonPath(response,strArg1),strArg2);
                
    }
    @And("verify place_Id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String Expectedname, String resource) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	place_Id = getJsonPath(response,"place_id");
    	res = given().spec(requestspecification()).queryParam("place_id", place_Id);
    	user_calls_post_http_request(resource,"GET");
    	String actualname = getJsonPath(response, "name");
    	assertEquals(actualname, Expectedname);
    	
    }
    
    @Given("DeletePlacePayload")
    public void delete_place_payload() throws IOException {
    	res=given().spec(requestspecification())
    			.body(data.deleteplacepayload(place_Id));
    
            
     }
    @Then("the API call is success with status code1 {int}")
    public void the_api_call_is_success_with_status_code1(Integer int2) throws Throwable {
    	assertEquals(response.getStatusCode(),200);
    	
    	}
    @And("{string} in APIresponse body is1 {string}")
    public void status_in_APIresponse_body_is1_something(String actualstatus, String expectedstatus) throws Throwable {
    	assertEquals(getJsonPath(response,actualstatus),expectedstatus);
    	System.out.println("API automation completed successfully");
    }
    
    




}