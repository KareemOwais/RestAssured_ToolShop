package Utils;

import POJO.Payment;
import POJO.PaymentDetails;
import Steps.CategorySteps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Utils_APis {
    protected static final Logger logger = LoggerFactory.getLogger(Utils_APis.class);
    public static int flag = 0;

    public static String Get_Random_Image_ID(){
        Response response = io.restassured.RestAssured.given().contentType(io.restassured.http.ContentType.JSON).get(Constants.BASEURL + Constants.Image_ENDPOINT).then().statusCode(200).extract().response();
        return response.jsonPath().getString("[2].id");
    }


    public static String Get_Random_Product_ID() {
        // Send the GET request and get the response
        Response response = io.restassured.RestAssured
                .given()
                .contentType(io.restassured.http.ContentType.JSON)
                .get(Constants.BASEURL + Constants.PRODUCT_ENDPOINT)
                .then()
                .statusCode(200)
                .extract()
                .response();
        if(flag ==0){
            flag++;
            return response.jsonPath().getString("data[0].id");
        }
        else if(flag == 1){
            flag++;
            return response.jsonPath().getString("data[1].id");
        }
        else if (flag ==2) {
            return response.jsonPath().getString("data[3].id");
        }
        else {
            return null;
        }
    }

public static void CompletePaymentAndValidate(){
    PaymentDetails paymentDetails = new PaymentDetails("BanqueMisr","kasdf","51651");
    Payment payment = new Payment("bank-transfer", paymentDetails);
    Response response = RestAssured.given().contentType("application/json")
            .body(payment)
            .post(Constants.BASEURL + Constants.PAYMENT_ENDPOINT)
            .then()
            .statusCode(200)
            .extract().response();
    logger.info("Payment completed successfully");
}



}
