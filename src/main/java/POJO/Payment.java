package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
}
