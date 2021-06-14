package TestCase;
import Data.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUser{


    private final static String URL="https://restful-booker.herokuapp.com";
    public static Token tok=new Token();
    @Given("Create User")
    public void getToken(){
        System.out.println("Create User");
        RestAssured.baseURI=URL;
        Object obj;
        UserData data=new UserData();
        obj=data.getData();
        Response res = RestAssured.given()
                .header("Content-Type", "application/json")
                .when()
                .body(obj)
                .post("/auth");
        tok.setToken(res.jsonPath().get("token"));//lay token ra
        System.out.println(tok.getToken());
    }


    @When("Get Booking ID")
    public void GetBookingId()
    {
        System.out.println("Get Booking ID");
        RestAssured.baseURI=URL;
        Object obj;
        GetBookingIDData getBookingIdData =new GetBookingIDData();
        obj=getBookingIdData.getData();
        Response res = RestAssured.given()
                .header("Authorization", "Bearer " + tok.getToken())
                .contentType(ContentType.JSON)
                .when()
                .body(obj)
                .get("/booking");
        res.prettyPrint();

    }

    @Then("Create Booking")
    public  void CreateBooking()
    {
        System.out.println("Create Booking");
        RestAssured.baseURI=URL;
        Object s;
        CreateBookingData createBookingData =new CreateBookingData();
        s=createBookingData.getData();

        Response res = RestAssured.given()
                .header("Authorization", "Bearer " + tok.getToken())
                .contentType(ContentType.JSON)
                .when()
                .body(s)
                .post("/booking");
        res.prettyPrint();
    }

    @When("Get Booking")
    public void GetBooking()
    {
        int id=8;
        System.out.println("Get Booking");
        RestAssured.baseURI=URL;
        Response res = RestAssured.given()

                .header("Authorization", "Bearer " +tok.getToken())
                .contentType(ContentType.JSON)
                .when()
                .body("")
                .get("booking/"+id);
        res.prettyPrint();
    }

    @Then("Update First Name")
   public void Path(){
        int id=16;
        System.out.println("Update First Name");
        RestAssured.baseURI=URL;
        Object s;
        PathData createBookingData =new PathData();
        s=createBookingData.getData();
        Response res = RestAssured.given()

                .header("Cookie", "token=" + tok.getToken())
                .contentType(ContentType.JSON)
                .when()
                .body(s)
                .patch("booking/"+ id);
        res.prettyPrint();
        System.out.println(tok.getToken());
    }
}
