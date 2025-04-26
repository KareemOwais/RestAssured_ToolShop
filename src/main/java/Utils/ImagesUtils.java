package Utils;

import io.restassured.response.Response;

public class ImagesUtils {
    public static String Get_Random_Image_ID(){
        Response response = io.restassured.RestAssured.given().contentType(io.restassured.http.ContentType.JSON).get(Constants.BASEURL + Constants.Image_ENDPOINT).then().statusCode(200).extract().response();
        return response.jsonPath().getString("[2].id");
    }
}
