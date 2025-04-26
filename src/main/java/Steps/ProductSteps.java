package Steps;

import POJO.Product;
import Utils.ApiClient;
import Utils.Constants;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ProductSteps {
    protected static final Logger logger = LoggerFactory.getLogger(ProductSteps.class);
    public static String CreateProductAndValidate(String name, String categoryId, String brandId , String ImageId , int statusCode) {

        // Create a new product
        Response response= ApiClient.sendPostRequest(
                new Product(name, "THIS is a test product", 100, categoryId, brandId, ImageId,
                        false, false) , Constants.PRODUCT_ENDPOINT);
        // Validate the response
        if(statusCode == 201){
            Assert.assertEquals(response.getStatusCode(), 201, "Product creation failed");
            response.prettyPrint();
            Product product = response.as(Product.class);
            Assert.assertEquals(product.getName(), name, "Product name does not match");
            Assert.assertEquals(product.getToolBrand().getId() , brandId, "Product brand ID does not match");
            Assert.assertEquals(product.getToolCategory().getId() , categoryId, "Product category ID does not match");
            logger.info("Product created successfully with ID: " + product.getId());
            return product.getId();
        }
        else if (statusCode == 404){
            Assert.assertEquals(response.getStatusCode(), 404, "Product creation failed");
            Product product = response.as(Product.class);
            Assert.assertEquals(product.getMessage(),"Requested item not found");
            logger.info("Endpoint not found");
            return null;
        }
        else if (statusCode == 405){
            Assert.assertEquals(response.getStatusCode(), 405, "Product creation failed");
            Product product = response.as(Product.class);
            Assert.assertEquals(product.getMessage(),"Method is not allowed for the requested route");
            logger.info("Method is not allowed for the requested route");
            return null;
        }
        else {
            Assert.fail("Unexpected status code: " + statusCode);
            return null;
        }
    }
    public static void UpdateProductAndValidate(String id, String name, int price , int statusCode) {
        // Update the product
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        Response response = ApiClient.sendPatchRequest(product, Constants.PRODUCT_ENDPOINT + "/" + id);
        if(statusCode == 200) {
            Assert.assertEquals(response.getStatusCode(), 200, "Product update failed");
            product = response.as(Product.class);
            Assert.assertTrue(product.getSuccess(), "Product update failed");
            response = ApiClient.sendGetRequest(Constants.PRODUCT_ENDPOINT + "/" + id);
            Assert.assertEquals(response.getStatusCode(), 200, "Product not found after update");
            product = response.as(Product.class);
            Assert.assertEquals(product.getName(), name, "Product name mismatch after update");
            Assert.assertEquals(product.getPrice(), price, "Product price mismatch after update");
            logger.info("Product updated successfully with ID: " + product.getId());
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode(), 404, "Product update failed");
            Product product1 = response.as(Product.class);
            Assert.assertEquals(product1.getMessage(),"Requested item not found");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode(), 405, "Product update failed");
            Product product1 = response.as(Product.class);
            Assert.assertEquals(product1.getMessage(),"Method is not allowed for the requested route");
        }
        else {
            Assert.fail("Unexpected status code: " + statusCode);
        }
    }
    public static void DeleteProductAndValidate(String id , String token , int statusCode) {
        // Delete the product
        Response response = ApiClient.sendDeleteRequest(Constants.PRODUCT_ENDPOINT + "/" + id , token);
        if(statusCode == 204) {
            Assert.assertEquals(response.getStatusCode(), 204, "Product deletion failed");
            response = ApiClient.sendGetRequest(Constants.PRODUCT_ENDPOINT + "/" + id);
            Assert.assertEquals(response.getStatusCode(), 404, "Product still exists after deletion");
            logger.info("Product deleted successfully with ID: " + id);
        }
        else if(statusCode == 401){
            Assert.assertEquals(response.getStatusCode(), 401, "Product deletion failed");
            Product product = response.as(Product.class);
            Assert.assertEquals(product.getMessage(),"Unauthorized");
            logger.info("Unauthorized");
        }
        else if(statusCode == 403){
            Assert.assertEquals(response.getStatusCode(), 403, "Product deletion failed");
            Product product = response.as(Product.class);
            Assert.assertEquals(product.getMessage(),"Forbidden");
            logger.info("Forbidden");
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode(), 404, "Product deletion failed");
            Product product = response.as(Product.class);
            Assert.assertEquals(product.getMessage(),"Requested item not found");
            logger.info("Product not found with ID: " + id);
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode(), 405, "Product deletion failed");
            Product product = response.as(Product.class);
            Assert.assertEquals(product.getMessage(),"Method is not allowed for the requested route");
            logger.info("Method is not allowed for the requested route");
        }
        else {
            Assert.fail("Unexpected status code: " + statusCode);
        }
    }

}
