package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class GraphQL_Utils {

    private static final String GRAPHQL_URL = "https://hasura.io/learn/graphql";
    public static final String HASURA_ADMIN_SECRET = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik9FWTJSVGM1UlVOR05qSXhSRUV5TURJNFFUWXdNekZETWtReU1EQXdSVUV4UVVRM05EazFNQSJ9.eyJodHRwczovL2hhc3VyYS5pby9qd3QvY2xhaW1zIjp7IngtaGFzdXJhLWRlZmF1bHQtcm9sZSI6InVzZXIiLCJ4LWhhc3VyYS1hbGxvd2VkLXJvbGVzIjpbInVzZXIiXSwieC1oYXN1cmEtdXNlci1pZCI6ImF1dGgwfDY4MTdkMDY0YWYzMzhlZjAyMGE5ZWUzZSJ9LCJuaWNrbmFtZSI6ImthcmVlbW1vaGFtZWQ3MC5rbSIsIm5hbWUiOiJrYXJlZW1tb2hhbWVkNzAua21AZ21haWwuY29tIiwicGljdHVyZSI6Imh0dHBzOi8vcy5ncmF2YXRhci5jb20vYXZhdGFyL2ZlMmU5MjQwNWQ2Y2Y2NTZhOTk3MTAxYTkxYWQ1ZDU1P3M9NDgwJnI9cGcmZD1odHRwcyUzQSUyRiUyRmNkbi5hdXRoMC5jb20lMkZhdmF0YXJzJTJGa2EucG5nIiwidXBkYXRlZF9hdCI6IjIwMjUtMDUtMDVUMTc6MTQ6NDcuNTAxWiIsImlzcyI6Imh0dHBzOi8vZ3JhcGhxbC10dXRvcmlhbHMuYXV0aDAuY29tLyIsImF1ZCI6IlAzOHFuRm8xbEZBUUpyemt1bi0td0V6cWxqVk5HY1dXIiwic3ViIjoiYXV0aDB8NjgxN2QwNjRhZjMzOGVmMDIwYTllZTNlIiwiaWF0IjoxNzQ2NTQxNTU3LCJleHAiOjE3NDY1Nzc1NTcsInNpZCI6IjRORlZmakVaRVkzSElLb0h6cmVRQzYxSHhXN253VF85IiwiYXRfaGFzaCI6IlpLQmF3NlRNU2IwT1VocmFiZGlNTHciLCJub25jZSI6IllaMV9rN2xEeVZIM3ZVR3paRUZ0UGMwcmVxRG9-R0dNIn0.eMvNHujHEjMRB-k3yjlA25JSozKjmuLOiE0_21ZTsXOq3Rc0Ssaf08pHC8Ld0zWfc6pWtc43TCq7y3oFxMDqAbzDkp9_Wqd8ZlrIIUdufJaqkRTaDwcyWx6TPxi4nxiMZHGcG0V78VCDxWIE33OUkdUWzEtBpnxgAl9bQJqs7PQgsVuZTsHn5i9WIIxKBN_TGjC9rpodWP0KxNSMlSyIqNE3B0J_NnhVxKfHAAkPbMLUeR5KfJ729t4jWh0A9WlYAODndtiqLpk8L9fbOCrIA69iDBaoCWbqG780RfrLdHsMVrKRH78g0QLzXLhKURWNy57rDoI8wGcysTH83L-HAw";
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
                .baseUri(GRAPHQL_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + HASURA_ADMIN_SECRET)
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
                .baseUri(GRAPHQL_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + HASURA_ADMIN_SECRET)
                .body(payload.toString())
                .post();
    }
}
