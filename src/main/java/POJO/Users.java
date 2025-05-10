package POJO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
public class Users {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("access_token")
    private String access_token;
    @JsonProperty("message")
    private String message;
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("dob")
    private String dob;
    @JsonIgnore
    @JsonProperty("token_type")
    private String token_type;
    @JsonIgnore
    @JsonProperty("expires_in")
    private String expires_in;
    public Users() {


    }
    public  Users(String email, String password) {
        this.email = email;
        this.password = password;
        first_name = "Kareem";
        last_name = "Mohamed";
        address = new Address("Street 1", "City", "State", "Country", "1234AA");
        phone = "0987654321";
        dob ="1970-01-01";

    }

}