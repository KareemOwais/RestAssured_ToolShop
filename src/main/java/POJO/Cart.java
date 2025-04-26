package POJO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cart {

    public Cart() {
    }

    @JsonProperty("id")
    private String id;
    @JsonProperty("message")
    private String message;
    @JsonProperty("product_id")
    private String product_id;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("result")
    private String result;
    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("additional_discount_percentage")
    private Double additionalDiscountPercentage;

    @JsonProperty("lat")
    private Double lat;

    @JsonProperty("lng")
    private Double lng;

    @JsonProperty("cart_items")
    private List<CartItem> cartItems;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setProductId(String product_id) {
        this.product_id = product_id;
    }
    public String getProductId() {
        return product_id;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getResult() {
        return result;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public Boolean getSuccess() {
        return success;
    }
    public Double getAdditionalDiscountPercentage() { return additionalDiscountPercentage; }
    public void setAdditionalDiscountPercentage(Double additionalDiscountPercentage) { this.additionalDiscountPercentage = additionalDiscountPercentage; }

    public Double getLat() { return lat; }
    public void setLat(Double lat) { this.lat = lat; }

    public Double getLng() { return lng; }
    public void setLng(Double lng) { this.lng = lng; }
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }


}