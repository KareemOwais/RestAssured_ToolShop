package POJO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Login {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("access_token")
    private String access_token;
    @JsonProperty("message")
    private String message;

    @JsonIgnore
    @JsonProperty("token_type")
    private String token_type;
    @JsonIgnore
    @JsonProperty("expires_in")
    private String expires_in;

    public Login() {
    }

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return access_token;
    }

    public void setToken(String token) {
        this.access_token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
