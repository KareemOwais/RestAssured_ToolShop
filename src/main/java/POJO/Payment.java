package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("payment_details")
    private PaymentDetails paymentDetails;

    public Payment() {}

    public Payment(String paymentMethod, PaymentDetails paymentDetails) {
        this.paymentMethod = paymentMethod;
        this.paymentDetails = paymentDetails;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
}
}
