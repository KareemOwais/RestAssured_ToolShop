package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItem {
    @JsonProperty("id")
    private String id;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("discount_percentage")
    private int discountPercentage;

    @JsonProperty("cart_id")
    private String cartId;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("product")
    private Product product;

}
