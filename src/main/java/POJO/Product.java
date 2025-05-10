package POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unknown properties@Data
@Data
@Builder
@AllArgsConstructor
public class Product {
    private String id;
    @JsonProperty("name")
    private String name;
    private String description;
    @JsonProperty("category_id")
    private String category_id;

    @JsonProperty("brand_id")
    private String brand_id;

    @JsonProperty("product_image_id")
    private String product_image_id;

    private int price;

    @JsonProperty("is_location_offer")
    private Boolean isLocationOffer; // Change type to Boolean

    @JsonProperty("is_rental")
    private Boolean isRental;

    private Boolean in_stock;
    @JsonProperty("brand")
    private Brand ToolBrand;

    @JsonProperty("category")
    private Category ToolCategory;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;

    public Product() {}

    public Product(String name, String description, int price, String category_id, String brand_id,
                   String product_image_id, Boolean isLocationOffer, Boolean isRental) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
        this.brand_id = brand_id;
        this.product_image_id = product_image_id;
        this.isLocationOffer = isLocationOffer;
        this.isRental = isRental;
    }

}
