package Step_Defination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonSerializationContext;
import io.restassured.RestAssured;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.hamcrest.core.Is;
import org.json.JSONObject;
import org.mozilla.javascript.PolicySecurityController;

import static io.restassured.RestAssured.*;


public class Defination {

	public Response res;
	public Response res1;
	public Response res2;
	String jsonBody;
	@Given("I perform Get operation for employee data")
	public void i_perform_Get_operation_for_employee_data() throws Throwable {
	    
		
	    
	}

	@When("I perfrom Get operation for employee {string}")
	public void i_perfrom_Get_operation_for_employee(String string) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		 res=given()
		.contentType(ContentType.JSON)
		.pathParam("id", string)
		.when()
		.get("http://dummy.restapiexample.com/api/v1/employee/{id}")
		.then()
		.extract().response();
		
		
		jsonBody=res.getBody().asString();
			
		 System.out.println(jsonBody);
		//Assert.assertTrue(jsonBody.contains("Conradags0v2w58rl"));;
		
	}

	@Then("I see status code as {string} and employee name as {string}")
	public void i_see_status_code_as_and_employee_name_as(String string, String string2) throws Throwable {
		
		int response_code=res.getStatusCode();
		System.out.println(response_code);
		//Assert.assertEquals(string, response_code);
		//Assert.assertTrue(jsonBody.contains(string2));;
	} 
	
	@Given("I perform post operation for employee data")
	public void I_perform_post_operation_for_employee_data() throws Throwable{
	
	
		HashMap<String, String> postContent=new HashMap<String, String>();
		postContent.put("name", "xyz");
		postContent.put("salary","254");
		postContent.put("age", "91");
		
		res2=	given()
		.contentType(ContentType.JSON).
		with()
		.body(postContent).
		when()
		.post("http://dummy.restapiexample.com/api/v1/create")
		.then()
		.extract().response();
		jsonBody=res2.getBody().asString();
		JSONObject obj = new JSONObject(jsonBody);
		System.out.println("-----------------------------------------");
		String name1=obj.getString("name");
		/*String salary=obj.getString("salary");
		System.out.println(name1);
		System.out.println(salary);
		System.out.println(jsonBody);*/
		assertThat(name1, equalTo("xyz"));
		 
	
	}
	

@Given("I Want to Update the data for employee data {string}")
public void i_Want_to_Update_the_data_for_employee_data(String string) throws Throwable{
    
	HashMap<String, String> postContent=new HashMap<String, String>();
	
	postContent.put("name","ankit");
	postContent.put("salary","214");
	postContent.put("age", "81");
	res1=given()
			.with()
	.contentType(ContentType.JSON)
    .pathParam("id",string)
    .when()
        .put("http://dummy.restapiexample.com/api/v1/update/{id}")
    .then()
        .extract().response();
	
	jsonBody=res1.getBody().asString();
	System.out.println(res1.statusCode());
	System.out.println(jsonBody);
   
}
		
	
	
}
