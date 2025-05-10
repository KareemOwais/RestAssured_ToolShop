package POJO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
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

}