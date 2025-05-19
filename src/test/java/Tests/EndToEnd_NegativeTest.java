package Tests;

import POJO.Users;
import Steps.*;

import Utils.Constants;
import Utils.EnvManager;
import Utils.Utils_APis;
import org.testng.annotations.Test;

import java.util.UUID;

public class EndToEnd_NegativeTest {

    @Test
    public static void EndToEnd_NegativeAdmin1(){
        String ParentCategoryID,BrandID,SubCategoryID,ProductID,ImageID;
        Users user = UsersSteps.login(EnvManager.getEnvVar("ADMIN_USERNAME"), EnvManager.getEnvVar("ADMIN_PASSWORD"), 200);
        Constants.setToken(user.getAccess_token());

        BrandID= BrandSteps.createBrandAndValidate(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 201);

        BrandSteps.updateBrandAndValidate(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BrandID, 200);

        ParentCategoryID= CategorySteps.createCategoryAndValidate(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 201);

        SubCategoryID= CategorySteps.createCategoryAndValidate(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 201, ParentCategoryID);

        CategorySteps.updateCategoryAndValidate(SubCategoryID, UUID.randomUUID().toString(),UUID.randomUUID().toString(), 200);

        CategorySteps.deleteCategoryAndValidate(ParentCategoryID,Constants.getToken(),409 );

    }
    @Test
    public static void EndToEnd_NegativeUser(){
        String productID1 , productID2 , productID3;
        UsersSteps.Register(EnvManager.getEnvVar("USER_USERNAME"), EnvManager.getEnvVar("USER_PASSWORD"));
        Users user = UsersSteps.login(EnvManager.getEnvVar("USER_USERNAME"), EnvManager.getEnvVar("USER_PASSWORD"),200);
        Constants.setToken(user.getAccess_token());
        productID1 = Utils_APis.Get_Random_Product_ID();
        productID2 = Utils_APis.Get_Random_Product_ID();
        productID3 = Utils_APis.Get_Random_Product_ID();

        String cartID = CartSteps.CreateNewCartAndValidate();
        CartSteps.AddProductToCartAndValidate(cartID, productID1, 200);
        CartSteps.AddProductToCartAndValidate(cartID, productID2, 200);
        CartSteps.GetCartAndValidate(cartID, 200);
        CartSteps.DeleteProductFromCartAndValidate(cartID+"Invalid", productID3, 404);
        CartSteps.GetCartAndValidate(cartID, 200);
        Utils_APis.CompletePaymentAndValidate();
    }
}
