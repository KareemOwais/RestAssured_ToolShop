package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    @JsonProperty("street")
    private String street;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;
    @JsonProperty("postal_code")
    private String postal_code;

    public Address() {
    }

    public Address(String street, String city, String state, String country, String postal_code) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postal_code = postal_code;
    }
}
