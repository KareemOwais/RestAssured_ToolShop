package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Invoice {

    @JsonProperty("billing_street")
    private String billingStreet;
    @JsonProperty("billing_city")
    private String billingCity;
    @JsonProperty("billing_state")
    private String billingState;
    @JsonProperty("billing_country")
    private String billingCountry;
    @JsonProperty("billing_postal_code")
    private String billingPostalCode;
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("cart_id")
    private String cartId;
    @JsonProperty("payment_details")
    private PaymentDetails paymentDetails;



    public Invoice() {
    }
    public Invoice(String billingStreet, String billingCity, String billingState, String billingCountry, String billingPostalCode, String paymentMethod, String cartId, PaymentDetails paymentDetails) {
        this.billingStreet = billingStreet;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingCountry = billingCountry;
        this.billingPostalCode = billingPostalCode;
        this.paymentMethod = paymentMethod;
        this.cartId = cartId;
        this.paymentDetails = paymentDetails;
    }
}
