package StepDefinitions;

import POJO.Product;
import POJO.Users;
import Steps.BrandSteps;
import Steps.CategorySteps;
import Steps.ProductSteps;
import Steps.UsersSteps;
import Utils.Constants;
import Utils.Utils_APis;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.util.UUID;


public class RestStepDefinitions {
    private static String ProductId,BrandId,CatergoryId , ImageId , Product_name_Expected , ProductName_Actual
            , Updated_Product_Name ;
    private static int Updated_Price;

    @Given("A brand is Created")
    public void a_brand_is_created() {
        BrandId=BrandSteps.createBrandAndValidate(UUID.randomUUID().toString() , UUID.randomUUID().toString() , 201);
    }
    @Given("Category is Created")
    public void Category_is_created() {
        CatergoryId = CategorySteps.createCategoryAndValidate(UUID.randomUUID().toString() , UUID.randomUUID().toString(),201);
        ImageId = Utils_APis.Get_Random_Image_ID();
    }
    @Given("Product is Created with name {string}")
    public void product_is_created(String Name) {
        Product_name_Expected = Name;
        ProductId = ProductSteps.CreateProductAndValidate(Product_name_Expected ,CatergoryId,BrandId,ImageId,201);
    }
    @When("the product is retrieved")
    public void the_product_is_retrieved() {
        ProductName_Actual = ProductSteps.RetrieveProductName(ProductId);
    }
    @Then("the product name should be correct")
    public void the_product_name_should_be() {
        Assert.assertEquals(ProductName_Actual,Product_name_Expected);
    }

    @Given("Product exists in database")
    public void productExistsInDatabase() {
        ProductSteps.RetrieveProductName(ProductId);
    }

    @Given("Logged in as Admin")
    public void loggedInAsAdmin() {
        Users user =UsersSteps.login(Constants.ADMIN_USERNAME , Constants.ADMIN_PASSWORD , 200);
        Constants.setToken(user.getAccess_token());
    }
    @When("Product is Deleted")
    public void productIsDeleted() {
        ProductSteps.DeleteProductAndValidate(ProductId, Constants.getToken() , 204);
    }

    @Then("Product ID Shouldn't exist")
    public void productIDShouldnTExist() {
        Assert.assertFalse(ProductSteps.Boolean_RetrieveProduct(ProductId,404));
    }

    @When("Product Name is updated to {string} and Price is updated to {int}")
    public void productNameIsUpdatedToAndPriceIsUpdatedTo(String Name, int price) {
        Updated_Product_Name = Name;
        Updated_Price = price;
        ProductSteps.UpdateProductAndValidate(ProductId,Name,price,200);
    }

    @Then("Product Name and Price should be updated")
    public void productNameAndPriceShouldBeUpdated() {
        Product product = ProductSteps.Retrieve_Product(ProductId,200);
        Assert.assertEquals(product.getPrice() , Updated_Price);
        Assert.assertEquals(product.getName(),Updated_Product_Name);
    }
}
