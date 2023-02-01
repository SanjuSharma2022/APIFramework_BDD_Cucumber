Feature: Validating place API's

@AddPlace@Regression
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
	Given Add Place payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" using "Post" http request
	Then the API call is success with status code 200
	And "status" in APIresponse body is "OK"
	And "scope" in APIresponse body is "APP"
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
	
Examples:
		|name         |language  |address          |
		|Nexon car    |Hindi     |Pune, India      |


@DeletePlace	
Scenario: Verify if delete place API is working
	
	Given DeletePlacePayload
	When user calls "deletePlaceAPI" using "Post" http request
	Then the API call is success with status code1 200
	And "status" in APIresponse body is1 "OK"