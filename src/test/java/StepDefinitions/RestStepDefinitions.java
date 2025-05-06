package StepDefinitions;

import Steps.BrandSteps;
import Steps.CategorySteps;
import Steps.ProductSteps;
import Utils.Utils_APis;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.naming.Name;
import java.util.UUID;


public class RestStepDefinitions {
    private static String ProductId,BrandId,CatergoryId , ImageId , Product_name;

    @Given("A brand is Created")
    public void a_brand_is_created() {
        BrandId=BrandSteps.createBrandAndValidate(UUID.randomUUID().toString() , UUID.randomUUID().toString() , 201);

    }
    @Given("Catergory is Created")
    public void catergory_is_created() {
        CatergoryId = CategorySteps.createCategoryAndValidate(UUID.randomUUID().toString() , UUID.randomUUID().toString(),201);
        ImageId = Utils_APis.Get_Random_Image_ID();
    }
    @Given("Product is Created")
    public void product_is_created() {
        ProductId = ProductSteps.CreateProductAndValidate("Product525" ,CatergoryId,BrandId,ImageId,201);
    }
    @When("the product is retrieved")
    public void the_product_is_retrieved() {
        Product_name = ProductSteps.RetrieveProductName(ProductId);
    }
    @Then("the product name should be {string}")
    public void the_product_name_should_be(String Product_Name) {
        Assert.assertEquals(Product_Name , Product_Name);
    }
}
