package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforescenario() throws Throwable {
		stepDefination step = new stepDefination();
		if(stepDefination.place_Id==null) 
		{
		step.add_place_payload_with("API", "Java", "India");
		step.user_calls_post_http_request("AddPlaceAPI", "POST");
		step.verify_place_id_created_maps_to_using("API", "getPlaceAPI");
			 }

}
}