import POJO.Brand;
import POJO.Category;
import POJO.Login;
import Steps.BrandSteps;
import Steps.CategorySteps;
import Steps.ProductSteps;
import Utils.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.UUID;

public class EndToEndTest {
    @BeforeClass
    public void setup() {


        Login user = LoginUtils.login(Constants.ADMIN_USERNAME, Constants.ADMIN_PASSWORD);
        Constants.setToken(user.getToken());

    }

    @Test
    public void END_TO_END(){
        String ParentCategoryID,BrandID,SubCategoryID,ProductID,ImageID;

        BrandID= BrandSteps.createBrandAndValidate("Brand_Name_Test", "Brand_Slang_Test", 201);

        BrandSteps.updateBrandAndValidate("Titan-Forge", "Titan-Forge", BrandID, 200);

        ParentCategoryID= CategorySteps.createCategoryAndValidate("Power-Tools-Test", "Power-Tools-Test", 201);

        SubCategoryID= CategorySteps.createCategoryAndValidate("SubCategory1", "SubCategory1", 201, ParentCategoryID);

        CategorySteps.updateCategoryAndValidate(SubCategoryID, "Cordless-Drills","Cordless-Drills", 200);

        CategorySteps.deleteCategoryAndValidate(ParentCategoryID,Constants.getToken(),409 );

        ImageID = ImagesUtils.Get_Random_Image_ID();

        ProductID = ProductSteps.CreateProductAndValidate("TestProduct", SubCategoryID, BrandID, ImageID, 201);

        ProductSteps.UpdateProductAndValidate(ProductID, "TitanForge-X-Drive-20V-Cordless-Drill", 150, 200);

        ProductSteps.DeleteProductAndValidate(ProductID, Constants.getToken(), 204);

        CategorySteps.deleteCategoryAndValidate(SubCategoryID, Constants.getToken(), 204);

        CategorySteps.deleteCategoryAndValidate(ParentCategoryID, Constants.getToken(), 204);

        BrandSteps.deleteBrandAndValidate(BrandID, Constants.getToken(), 204);
        LoginUtils.logout(Constants.getToken());




}
}
