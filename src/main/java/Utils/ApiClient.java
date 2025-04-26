package Utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiClient {
    protected static final Logger logger = LoggerFactory.getLogger(ApiClient.class);
    public  static Response sendGetRequest(String endpoint) {
        logger.info("GET request sent to endpoint: "+ endpoint);
        return RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .get(Constants.BASEURL + endpoint);
    }
    public static Response sendGetRequestWithToken(String endpoint, String token) {
        logger.info("GET request sent to endpoint: "+ endpoint);
        return RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get(Constants.BASEURL + endpoint);
    }
    public static Response sendPostRequest(Object body, String endpoint) {
        logger.info("POST request sent to endpoint: "+ endpoint);
        return RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(body)
                .post(Constants.BASEURL+ endpoint);
    }
    public static Response sendPostRequestWithToken(Object body, String endpoint, String token) {
        logger.info("POST request sent to endpoint: "+ endpoint);
        return RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(body)
                .post(Constants.BASEURL+ endpoint);
    }

    public static Response sendPutRequest(Object body, String endpoint) {
        logger.info("PUT request sent to endpoint: "+ endpoint);
        return RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(body)
                .put(Constants.BASEURL+ endpoint);
    }
    public static Response sendPutRequestWithToken(Object body, String endpoint, String token) {
        logger.info("PUT request sent to endpoint: "+ endpoint);
        return RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(body)
                .put(Constants.BASEURL+ endpoint);
    }

    public static Response sendPatchRequest(Object body, String endpoint) {
        logger.info("PATCH request sent to endpoint: "+ endpoint);
        return RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(body)
                .patch(Constants.BASEURL+ endpoint);
    }
    public static Response sendPatchRequestWithToken(Object body, String endpoint, String token) {
        logger.info("PATCH request sent to endpoint: "+ endpoint);
        return RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(body)
                .patch(Constants.BASEURL+ endpoint);
    }

    public static Response sendDeleteRequest(String endpoint , String token) {
        logger.info("DELETE request sent to endpoint: "+ endpoint);
        return RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .delete(Constants.BASEURL+ endpoint);
    }
    public static Response sendDeleteRequestWithoutToken(String endpoint) {
        logger.info("DELETE request sent to endpoint: "+ endpoint);
        return RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .delete(Constants.BASEURL+ endpoint);
    }
}
