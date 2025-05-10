package Steps;

import POJO.Category;
import Utils.RestClient;
import Utils.Constants;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class CategorySteps {
    protected static final Logger logger = LoggerFactory.getLogger(CategorySteps.class);
    public static String createCategoryAndValidate(String name, String slug , int statusCode) {

        Category category = new Category(name, slug);
        Response response = RestClient.sendPostRequest(category,Constants.Category_ENDPOINT);
        if(statusCode == 201){
        Assert.assertEquals(response.getStatusCode(), statusCode, "Category creation failed\n");
        category = response.as(Category.class);
        Assert.assertEquals(category.getName(), name, "Category name does not match\n");
        Assert.assertEquals(category.getSlug(), slug, "Category slug does not match\n");
        Assert.assertNull(category.getParent_id(), "Category parent ID should be null\n");
        logger.info("Category created successfully with ID: " + category.getId());
        return category.getId();
        } else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode(), statusCode, "Category creation failed\n");
            category = response.as(Category.class);
            Assert.assertEquals(category.getMessage(),"Requested item not found");
            logger.info("Endpoint not found");
            return null;
        } else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode(), statusCode, "Category creation failed\n");
            category = response.as(Category.class);
            Assert.assertEquals(category.getMessage(),"Method is not allowed for the requested route");
            logger.info("Method is not allowed for the requested route");
            return null;
        }
        else {
            Assert.fail("Unexpected status code: " + statusCode);
            return null;
        }
    }
    public static String createCategoryAndValidate(String name, String slug,int statusCode , String parentId ) {
        Category category = new Category(name, slug , parentId);
        Response response = RestClient.sendPostRequest(category, Constants.Category_ENDPOINT);
        if(statusCode == 201) {
            Assert.assertEquals(response.getStatusCode(), statusCode, "Category creation failed\n");
            category = response.as(Category.class);
            Assert.assertEquals(category.getName(), name, "Category name does not match\n");
            Assert.assertEquals(category.getSlug(), slug, "Category slug does not match\n");
            Assert.assertEquals(category.getParent_id(), parentId, "Category parent ID does not match\n");
            logger.info("Category created successfully with ID: " + category.getId());
            return category.getId();
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode(), statusCode, "Category creation failed\n");
            category = response.as(Category.class);
            Assert.assertEquals(category.getMessage(),"Requested item not found");
            logger.info("Endpoint not found");
            return null;
        } else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode(), statusCode, "Category creation failed\n");
            category = response.as(Category.class);
            Assert.assertEquals(category.getMessage(),"Method is not allowed for the requested route");
            logger.info("Method is not allowed for the requested route");
            return null;
        }
        else {
            Assert.fail("Unexpected status code: " + statusCode);
            return null;
        }
    }

    public static void updateCategoryAndValidate(String id,String name, String slug , int statusCode) {
        Category category = new Category(name, slug);
        Response response =  RestClient.sendPutRequest(category, Constants.Category_ENDPOINT + "/" + id);
        response.prettyPrint();
        if(statusCode == 200) {

            Assert.assertEquals(response.getStatusCode(), statusCode, "Category update failed\n");

            category = response.as(Category.class);
            Assert.assertTrue(category.getSuccess(), "Category update failed\n");

            response = RestClient.sendGetRequest(Constants.Category_ENDPOINT + "/tree/" + id);
            Assert.assertEquals(response.getStatusCode(), statusCode, "Category doesn't exist after update\n");
            category = response.as(Category.class);

            Assert.assertEquals(category.getName(), name, "Category name mismatch after update\n");
            Assert.assertEquals(category.getSlug(), slug, "Category slug mismatch after update\n");
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode(), statusCode, "Category update failed\n");
            category = response.as(Category.class);
            Assert.assertEquals(category.getMessage(),"Requested item not found");
            logger.info("Category not found with ID: ");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode(), statusCode, "Category update failed\n");
            category = response.as(Category.class);
            Assert.assertEquals(category.getMessage(),"Method is not allowed for the requested route");
            logger.info("Method is not allowed for the requested route");
        }
        else {
            Assert.fail("Unexpected status code: " + statusCode);
        }
    }

    public static void deleteCategoryAndValidate(String id, String token , int statusCode) {

        Response response = RestClient.sendDeleteRequestWithToken(Constants.Category_ENDPOINT+"/"+ id , token);
        if(statusCode == 204){
            Assert.assertEquals(response.getStatusCode(), statusCode, "Category deletion failed\n");
            response = RestClient.sendGetRequest(Constants.Category_ENDPOINT + "/tree/" + id);
            Assert.assertEquals(response.getStatusCode(), 404, "Category still exists after deletion\n");
            logger.info("Category deleted successfully with ID: " + id);
        }else if(statusCode == 409){
            Assert.assertEquals(response.getStatusCode(), statusCode, "Category deletion failed\n");
            Category category = response.as(Category.class);
            Assert.assertFalse(category.getSuccess(), "Category deletion failed\n");
            Assert.assertEquals(category.getMessage(),"Seems like this category is used elsewhere.");
            logger.info("Category deletion failed: " + category.getMessage());
        }

    }

}
