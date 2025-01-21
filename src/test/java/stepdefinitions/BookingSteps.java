package stepdefinitions;

import com.framework.models.Booking;
import com.framework.models.BookingDates;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class BookingSteps {

    private RequestSpecification request;
    private Response response;
    private int bookingId;

    @Given("the booking details are provided")
    public void the_booking_details_are_provided() {
        BookingDates dates = new BookingDates("2022-01-01", "2024-01-01");
        Booking booking = new Booking("testFirstName", "lastName", 10.11, true, dates, "testAdd");

        request = given().header("Content-Type", "application/json").body(booking);
    }

    @When("the user creates a new booking")
    public void the_user_creates_a_new_booking() {
        response = request.when().post("https://restful-booker.herokuapp.com/booking");
        System.out.println("Response for Create Booking:");
        response.prettyPrint(); // Prints the response body
        bookingId = response.jsonPath().getInt("bookingid");
        // System.out.println(bookingId);
    }

    @Then("the booking should be successfully created")
    public void the_booking_should_be_successfully_created() {
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(bookingId, "Booking ID should not be null");
    }

    @Then("the booking details should be validated using the ID")
    public void the_booking_details_should_be_validated_using_the_id() {
        Response getResponse = given().pathParam("id", bookingId).when().get("https://restful-booker.herokuapp.com/booking/{id}");
        System.out.println("Response for Retrieve Booking:");
        getResponse.prettyPrint(); // Prints the response body
        Assert.assertEquals(getResponse.getStatusCode(), 200);
        Assert.assertEquals(getResponse.jsonPath().getString("firstname"), "testFirstName");
        Assert.assertEquals(getResponse.jsonPath().getString("lastname"), "lastName");
    }

    @When("the user fetches booking details with an invalid ID")
    public void the_user_fetches_booking_details_with_an_invalid_id() {
        response = given().pathParam("id", 99999).when().get("https://restful-booker.herokuapp.com/booking/{id}");
    }

    @Then("the response should return a 404 status")
    public void the_response_should_return_a_404_status() {
        Assert.assertEquals(response.getStatusCode(), 404);
    }
}