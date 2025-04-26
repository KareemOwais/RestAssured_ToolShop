package Steps;

import POJO.Cart;
import POJO.CartItem;
import Utils.ApiClient;
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
        Response response = ApiClient.sendPostRequest(cart , Constants.CART_ENDPOINT);
        cart = response.as(Cart.class);
        Assert.assertEquals(response.getStatusCode() , 201 , "Cart creation failed");
        Assert.assertNotNull(cart.getId());
        logger.info("Cart Created Succefully");
        return cart.getId();
    }
    public static void AddProductToCartAndValidate(String cartId , String productId , int statusCode){
        Cart cart = new Cart();
        cart.setProductId(productId);
        cart.setQuantity(1);
        Response response = ApiClient.sendPostRequest( cart, Constants.CART_ENDPOINT + "/" + cartId);
        response.prettyPrint();
        if(statusCode == 200){
            response.prettyPrint();
            Assert.assertEquals(response.getStatusCode() , 200 , "Product added to cart failed");
            cart = response.as(Cart.class);
            Assert.assertEquals(cart.getResult(), "item added or updated");
            logger.info("Product added to cart successfully");
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode() , 404 , "Product not found");
            logger.info("Product not found");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode() , 405 , "Method not allowed");
            logger.info("Method not allowed");
        }
    }
    public static void GetCartAndValidate(String cartId , int statusCode){
        Response response = ApiClient.sendGetRequest(Constants.CART_ENDPOINT + "/" + cartId);
        if(statusCode == 200){
            Assert.assertEquals(response.getStatusCode() , 200 , "Get cart failed");
            response.prettyPrint();
            Cart cart = response.as(Cart.class);
            Assert.assertEquals(cart.getId() , cartId , "Cart ID mismatch");
            logger.info("Cart retrieved successfully");
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode() , 404 , "Cart not found");
            logger.info("Cart not found");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode() , 405 , "Method not allowed");
            logger.info("Method not allowed");
        }
    }
    public static void DeleteCartAndValidate(String cartId , int statusCode){

        Response response = ApiClient.sendDeleteRequest(Constants.CART_ENDPOINT + "/" + cartId , null);
        if(statusCode == 204){
            Assert.assertEquals(response.getStatusCode() , 204 , "Delete cart failed");
            logger.info("Cart deleted successfully");
        }
        else if(statusCode == 401){
            Assert.assertEquals(response.getStatusCode() , 401 , "Unauthorized");
            logger.info("Unauthorized");
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode() , 404 , "Cart not found");
            logger.info("Cart not found");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode() , 405 , "Method not allowed");
            logger.info("Method not allowed");
        }
    }
    public static void UpdateProductQuantityAndValidate(String cartId , String productId , int quantity , int statusCode){
        Cart cart = new Cart();
        cart.setProductId(productId);
        cart.setQuantity(quantity);
        Response response = ApiClient.sendPutRequest(cart , Constants.CART_ENDPOINT + "/" + cartId+"/product/quantity");
        if(statusCode == 200){
            Assert.assertEquals(response.getStatusCode() , 200 , "Update product quantity failed");
            cart = response.as(Cart.class);
            response.prettyPrint();
            Assert.assertEquals(cart.getResult(), "item added or updated");
            response = ApiClient.sendGetRequest(Constants.CART_ENDPOINT + "/" + cartId);
            response.prettyPrint();
            cart = response.as(Cart.class);
            Assert.assertEquals(GetItemCount(cart.getCartItems(),productId) , quantity);
            logger.info("Product quantity updated successfully");

        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode() , 404 , "Product not found");
            logger.info("Product not found");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode() , 405 , "Method not allowed");
            logger.info("Method not allowed");
        }
    }
    public static void DeleteProductFromCartAndValidate(String cartId , String productId , int statusCode){
        Response response = ApiClient.sendDeleteRequest(Constants.CART_ENDPOINT + "/" + cartId + "/product/" + productId , null);
        if(statusCode == 204){
            Assert.assertEquals(response.getStatusCode() , 204, "Delete product from cart failed");
            response = ApiClient.sendGetRequest(Constants.CART_ENDPOINT + "/" + cartId);
            Cart cart = response.as(Cart.class);
            Boolean flag = GetItemId(cart.getCartItems() , productId);
            Assert.assertFalse(flag , "Product not deleted from cart");
            logger.info("Product deleted from cart successfully");

        }
        else if(statusCode == 401){
            Assert.assertEquals(response.getStatusCode() , 401 , "Unauthorized");
            logger.info("Unauthorized");
        }
        else if(statusCode == 404){
            Assert.assertEquals(response.getStatusCode() , 404 , "Product not found");
            logger.info("Product not found");
        }
        else if(statusCode == 405){
            Assert.assertEquals(response.getStatusCode() , 405 , "Method not allowed");
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
