package POJO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }
    public String getParentId() {
        return parent_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setParentId(String parent_id) {
        this.parent_id = parent_id;
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
