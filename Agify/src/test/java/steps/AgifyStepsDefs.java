package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class AgifyStepsDefs {
    private Response response;

    @When("I request age for name {string}")
    public void request_age(String name) {
        response = given().baseUri("https://api.agify.io").queryParam("name", name).when().get();
    }

    @Then("status code is {int}")
    public void check_status(int status) {
        assertEquals(status, response.getStatusCode());
    }

    @And("response has age field")
    public void check_age_field() {
        JsonObject json = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();
        assertTrue(json.has("age"));
    }

    @And("age is between {int} and {int}")
    public void check_age_range(int min, int max) {
        JsonObject json = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();
        int age = json.get("age").getAsInt();
        assertTrue(age >= min && age <= max);
    }
}