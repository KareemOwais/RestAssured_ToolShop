package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Brand {

    @JsonProperty("name")
    private String name;
    @JsonProperty("slug")
    private String slug;

    @JsonProperty("id")
    private String id;
    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message")
    private String message;
    public Brand() {}

    public Brand(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }


    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
