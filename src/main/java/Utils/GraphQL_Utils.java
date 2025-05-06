package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class GraphQL_Utils {



    public static int insertTodo() {
        String query = """
                mutation {
                  insert_todos_one(object: { is_public: true, title: "Initial Title" }) {
                    id
                  }
                }
                """;

        JSONObject payload = new JSONObject();
        payload.put("query", query);

        Response response = RestAssured.given()
                .baseUri(Constants.GRAPHQL_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + Constants.getHasuraAdminSecret())
                .body(payload.toString())
                .post();

        return response.jsonPath().getInt("data.insert_todos_one.id");
    }

    public static void updateTodoTitle(int id, String newTitle) {
        String query = String.format("""
                mutation {
                  update_todos_by_pk(pk_columns: { id: %d }, _set: { title: "%s" }) {
                    title
                  }
                }
                """, id, newTitle);

        JSONObject payload = new JSONObject();
        payload.put("query", query);

        RestAssured.given()
                .baseUri(Constants.GRAPHQL_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + Constants.getHasuraAdminSecret())
                .body(payload.toString())
                .post();
    }

}
