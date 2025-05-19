package POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
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


}
