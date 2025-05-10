package Steps;

import POJO.Cart;
import POJO.CartItem;
import Utils.RestClient;
import Utils.Constants;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

public class CartSteps {
    protected static final Logger logger = LoggerFactory.getLogger(CartSteps.class);
    public static String CreateNewCartAndValidate(){
        Cart cart = new Cart();
        Response response = RestClient.sendPostRequest(cart , Constants.CART_ENDPOINT);
        cart = response.as(Cart.class);
        Assert.assertEquals(response.getStatusCode() , 201 , "Cart creation failed");
        Assert.assertNotNull(cart.getId());
        logger.info("Cart Created Succefully");
        return cart.getId();
    }
    public static void AddProductToCartAndValidate(String cartId , String productId , int statusCode){
        Cart cart = new Cart();
        cart.setProduct_id(productId);
        cart.setQuantity(1);
        Response response = RestClient.sendPostRequest( cart, Constants.CART_ENDPOINT + "/" + cartId);
        response.prettyPrint();
        if(statusCode == 200){
            response.prettyPrint();
            Assert.assertEquals(response.getStatusCode() , statusCode , "Product added to cart failed");
            cart = response.as(Cart.class);
            Assert.assertEquals(cart.getResult(), "item added or updated");
            logger.info("Product added to cart successfully");
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Product not found");
            logger.info("Product not found");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Method not allowed");
            logger.info("Method not allowed");
        }
    }
    public static void GetCartAndValidate(String cartId , int statusCode){
        Response response = RestClient.sendGetRequest(Constants.CART_ENDPOINT + "/" + cartId);
        if(statusCode == 200){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Get cart failed");
            response.prettyPrint();
            Cart cart = response.as(Cart.class);
            Assert.assertEquals(cart.getId() , cartId , "Cart ID mismatch");
            logger.info("Cart retrieved successfully");
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Cart not found");
            logger.info("Cart not found");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Method not allowed");
            logger.info("Method not allowed");
        }
    }
    public static void DeleteCartAndValidate(String cartId , int statusCode){

        Response response = RestClient.sendDeleteRequestWithToken(Constants.CART_ENDPOINT + "/" + cartId , null);
        if(statusCode == 204){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Delete cart failed");
            logger.info("Cart deleted successfully");
        }
        else if(statusCode == 401){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Unauthorized");
            logger.info("Unauthorized");
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Cart not found");
            logger.info("Cart not found");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Method not allowed");
            logger.info("Method not allowed");
        }
    }
    public static void UpdateProductQuantityAndValidate(String cartId , String productId , int quantity , int statusCode){
        Cart cart = new Cart();
        cart.setProduct_id(productId);
        cart.setQuantity(quantity);
        Response response = RestClient.sendPutRequest(cart , Constants.CART_ENDPOINT + "/" + cartId+"/product/quantity");
        if(statusCode == 200){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Update product quantity failed");
            cart = response.as(Cart.class);
            response.prettyPrint();
            Assert.assertEquals(cart.getResult(), "item added or updated");
            response = RestClient.sendGetRequest(Constants.CART_ENDPOINT + "/" + cartId);
            response.prettyPrint();
            cart = response.as(Cart.class);
            Assert.assertEquals(GetItemCount(cart.getCartItems(),productId) , quantity);
            logger.info("Product quantity updated successfully");

        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Product not found");
            logger.info("Product not found");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Method not allowed");
            logger.info("Method not allowed");
        }
    }
    public static void DeleteProductFromCartAndValidate(String cartId , String productId , int statusCode){
        Response response = RestClient.sendDeleteRequestWithToken(Constants.CART_ENDPOINT + "/" + cartId + "/product/" + productId , null);
        if(statusCode == 204){
            Assert.assertEquals(response.getStatusCode() , statusCode, "Delete product from cart failed");
            response = RestClient.sendGetRequest(Constants.CART_ENDPOINT + "/" + cartId);
            Cart cart = response.as(Cart.class);
            Boolean flag = GetItemId(cart.getCartItems() , productId);
            Assert.assertFalse(flag , "Product not deleted from cart");
            logger.info("Product deleted from cart successfully");

        }
        else if(statusCode == 401){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Unauthorized");
            logger.info("Unauthorized");
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Product not found");
            Cart cart = response.as(Cart.class);
            Assert.assertEquals(cart.getMessage() , "Cart doesnt exists");
            logger.info("Cart doesnt exists");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode() , statusCode , "Method not allowed");
            logger.info("Method not allowed");
        }
    }

    public static Boolean GetItemId(List<CartItem> cartItems, String id){
        CartItem cart_item;
        for(CartItem cartItem : cartItems){
            if(cartItem.getProductId().equals(id)){
               return true;
            }
        }
        return false;
    }
    public static int GetItemCount(List<CartItem> cartItems, String id){
        CartItem cart_item;
        for(CartItem cartItem : cartItems){
            if(cartItem.getProductId().equals(id)){
                return cartItem.getQuantity();
            }
        }
        return 0;
    }
}
