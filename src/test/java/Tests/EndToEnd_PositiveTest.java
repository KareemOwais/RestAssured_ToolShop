package Tests;

import POJO.Users;
import Steps.*;
import Utils.*;
import org.testng.annotations.Test;

import java.util.UUID;

public class EndToEnd_PositiveTest {

    @Test
    public void END_TO_END_Admin(){
        String ParentCategoryID,BrandID,SubCategoryID,ProductID,ImageID;
        Users user = UsersSteps.login(Constants.ADMIN_USERNAME, Constants.ADMIN_PASSWORD,200);
        Constants.setToken(user.getAccess_token());

        BrandID= BrandSteps.createBrandAndValidate(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 201);

        BrandSteps.updateBrandAndValidate(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BrandID, 200);

        ParentCategoryID= CategorySteps.createCategoryAndValidate(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 201);

        SubCategoryID= CategorySteps.createCategoryAndValidate(UUID.randomUUID().toString(), UUID.randomUUID().toString(), 201, ParentCategoryID);

        CategorySteps.updateCategoryAndValidate(SubCategoryID, UUID.randomUUID().toString(),UUID.randomUUID().toString(), 200);

        CategorySteps.deleteCategoryAndValidate(ParentCategoryID,Constants.getToken(),409 );

        ImageID = Utils_APis.Get_Random_Image_ID();

        ProductID = ProductSteps.CreateProductAndValidate(UUID.randomUUID().toString(), SubCategoryID, BrandID, ImageID, 201);

        ProductSteps.UpdateProductAndValidate(ProductID, UUID.randomUUID().toString(), 150, 200);

        ProductSteps.DeleteProductAndValidate(ProductID, Constants.getToken(), 204);

        CategorySteps.deleteCategoryAndValidate(SubCategoryID, Constants.getToken(), 204);

        CategorySteps.deleteCategoryAndValidate(ParentCategoryID, Constants.getToken(), 204);

        BrandSteps.deleteBrandAndValidate(BrandID, Constants.getToken(), 204);
        UsersSteps.logout(Constants.getToken());
}

    @Test
    public void END_To_END_User(){
        String productID1 , productID2;
        UsersSteps.Register(Constants.USERNAME_User1,Constants.PASSWORD);
        Users user = UsersSteps.login(Constants.ADMIN_USERNAME, Constants.ADMIN_PASSWORD,200);
        Constants.setToken(user.getAccess_token());
        productID1 = Utils_APis.Get_Random_Product_ID();
        productID2 = Utils_APis.Get_Random_Product_ID();

        String cartID = CartSteps.CreateNewCartAndValidate();
        CartSteps.AddProductToCartAndValidate(cartID, productID1, 200);
        CartSteps.AddProductToCartAndValidate(cartID, productID2, 200);
        CartSteps.UpdateProductQuantityAndValidate(cartID , productID1 , 20 , 200);
        CartSteps.DeleteProductFromCartAndValidate(cartID, productID2, 204);
        Utils_APis.CompletePaymentAndValidate();

        user = UsersSteps.login(Constants.ADMIN_USERNAME, Constants.ADMIN_PASSWORD,200);
        Constants.setToken(user.getAccess_token());

        String InvoiceID = InvoicesSteps.CreateInvoiceAndValidate(cartID);

    }
}
