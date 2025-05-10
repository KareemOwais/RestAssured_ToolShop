package POJO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
public class Category {

    @JsonProperty("name")
    private String name;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("parent_id")
    private String parent_id;
    @JsonProperty("id")
    private String id;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;

    @JsonProperty("sub_categories")
    private Category[] sub_categories;

    public Category() {}

    public Category(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public Category(String name, String slug, String parent_id) {
        this.name = name;
        this.slug = slug;
        this.parent_id = parent_id;
    }

}
