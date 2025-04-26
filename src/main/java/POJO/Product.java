package POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unknown properties
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

    private int in_stock;
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

    // Getter and setter methods for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getIsLocationOffer() {
        return isLocationOffer;
    }

    public void setIsLocationOffer(Boolean isLocationOffer) {
        this.isLocationOffer = isLocationOffer;
    }

    public Boolean getIsRental() {
        return isRental;
    }

    public void setIsRental(Boolean isRental) {
        this.isRental = isRental;
    }

    public Brand getToolBrand() {
        return ToolBrand;
    }

    public void setToolBrand(Brand ToolBrand) {
        this.ToolBrand = ToolBrand;
    }

    public Category getToolCategory() {
        return ToolCategory;
    }

    public void setToolCategory(Category ToolCategory) {
        this.ToolCategory = ToolCategory;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return category_id;
    }

    public void setCategoryId(String category_id) {
        this.category_id = category_id;
    }

    public String getBrandId() {
        return brand_id;
    }

    public void setBrandId(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getProductImageId() {
        return product_image_id;
    }

    public void setProductImageId(String product_image_id) {
        this.product_image_id = product_image_id;
    }
    public int getInStock() {
        return in_stock;
    }
    public void setInStock(int in_stock) {
        this.in_stock = in_stock;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
