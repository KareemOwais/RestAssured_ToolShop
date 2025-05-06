package Steps;

import POJO.Brand;
import Utils.RestClient;
import Utils.Constants;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class BrandSteps {
    protected static final Logger logger = LoggerFactory.getLogger(BrandSteps.class);
    public static String createBrandAndValidate( String name, String slug, int statusCode) {

        Brand brand = new Brand(name, slug);
        Response response = RestClient.sendPostRequest(brand , Constants.BRAND_ENDPOINT);
        if(statusCode == 201){
            Assert.assertEquals(response.getStatusCode(), statusCode, "Brand creation failed");
            response.prettyPrint();
            brand = response.as(Brand.class);
            Assert.assertEquals(brand.getName(), name, "Brand name does not match");
            Assert.assertEquals(brand.getSlug(), slug, "Brand slug does not match");
            logger.info("Brand created successfully with ID: " + brand.getId());
            return brand.getId();
        }
        else if (statusCode == 404){

            Assert.assertEquals(response.getStatusCode(), statusCode);
            brand = response.as(Brand.class);
            Assert.assertEquals(brand.getMessage(),"Requested item not found");
            logger.info("Brand not found with ID: ");
            return null;
        }
        else if (statusCode == 405){
            Assert.assertEquals(response.getStatusCode(), statusCode);
            brand = response.as(Brand.class);
            Assert.assertEquals(brand.getMessage(),"Method is not allowed for the requested route");
            logger.info("Method is not allowed for the requested route");
            return null;
        }
        else {
            Assert.fail("Unexpected status code: " + statusCode);
            logger.info("Unexpected status code: " + statusCode);
            return null;
        }

    }

    public static void updateBrandAndValidate(String Name, String Slug , String id ,int statusCode ) {
        Brand brand = new Brand(Name, Slug);
        Response response = RestClient.sendPutRequest(brand , Constants.BRAND_ENDPOINT+"/"+ id);
        if(statusCode == 200) {
            Assert.assertEquals(response.getStatusCode(), statusCode, "Brand update failed");
            brand = response.as(Brand.class);
            Assert.assertTrue(brand.getSuccess(), "Brand update failed");
            response = RestClient.sendGetRequest(Constants.BRAND_ENDPOINT + "/" + id);
            Assert.assertEquals(response.getStatusCode(), 200, "Brand not found after update");
            brand = response.as(Brand.class);
            Assert.assertEquals(brand.getName(), Name, "Brand name mismatch after update");
            Assert.assertEquals(brand.getSlug(), Slug, "Brand slug mismatch after update");
            logger.info("Brand updated successfully with ID: " + id);
        }
        else if (statusCode == 404){
            Assert.assertEquals(response.getStatusCode(), statusCode);
            brand = response.as(Brand.class);
            Assert.assertEquals(brand.getMessage(),"Requested item not found");
            logger.info("Brand not found with ID: ");
        }
        else if (statusCode == 405){
            Assert.assertEquals(response.getStatusCode(), statusCode);
            brand = response.as(Brand.class);
            Assert.assertEquals(brand.getMessage(),"Method is not allowed for the requested route");
            logger.info("Method is not allowed for the requested route");
        }
    }

    public static void deleteBrandAndValidate(String id, String token ,int  statusCode ) {
        Response response = RestClient.sendDeleteRequestWithToken(Constants.BRAND_ENDPOINT + "/" + id, token);
        if(statusCode == 204) {
            Assert.assertEquals(response.getStatusCode(), statusCode, "Brand deletion failed");
            response = RestClient.sendGetRequest(Constants.BRAND_ENDPOINT + "/" + id);
            Assert.assertEquals(response.getStatusCode(), 404, "Brand still exists after deletion");
            logger.info("Brand deleted successfully with ID: " + id);
        }
        else if (statusCode == 401){
            Assert.assertEquals(response.getStatusCode(), statusCode);
            Brand brand = response.as(Brand.class);
            Assert.assertEquals(brand.getMessage(),"Unauthorized");
        }
        else if (statusCode == 404){
            Assert.assertEquals(response.getStatusCode(), statusCode);
            Brand brand = response.as(Brand.class);
            Assert.assertEquals(brand.getMessage(),"Requested item not found");
            logger.info("Brand not found with ID: ");
        }
        else if (statusCode == 405){
            Assert.assertEquals(response.getStatusCode(), statusCode);
            Brand brand = response.as(Brand.class);
            Assert.assertEquals(brand.getMessage(),"Method is not allowed for the requested route");
            logger.info("Method is not allowed for the requested route");
        }
    }
}
