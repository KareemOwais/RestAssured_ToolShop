package Utils;

import POJO.Login;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginUtils {
    //eve.holt@reqres.in
    //cityslicka
    public static String GetToken(Response response) {
       return response.jsonPath().getString("access_token");
    }

    public static Login login(String username, String password) {
        Login User = new Login(username, password);
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(User)
                .post(Constants.BASEURL + Constants.LOGIN_ENDPOINT)
                .then().extract().response().as(Login.class);
    }
    public static Login logout(String token) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(Constants.BASEURL + Constants.LOGOUT_ENDPOINT)
                .then().extract().response().as(Login.class);
    }

}
