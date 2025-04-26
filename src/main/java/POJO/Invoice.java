package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    public String getBillingStreet() {
        return billingStreet;
    }
    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }
    public String getBillingCity() {
        return billingCity;
    }
    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }
    public String getBillingState() {
        return billingState;
    }
    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }
    public String getBillingCountry() {
        return billingCountry;
    }
    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }
    public String getBillingPostalCode() {
        return billingPostalCode;
    }
    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getCartId() {
        return cartId;
    }
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }
    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

}
