package Utils;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import io.restassured.path.json.JsonPath;

import java.net.URI;
import java.util.concurrent.CountDownLatch;

import static Utils.GraphQL_Utils.HASURA_ADMIN_SECRET;

public class GraphQLWebSocketClient extends WebSocketClient {
    private CountDownLatch latch;
    private int todoId;
    private String receivedMessage;

    public GraphQLWebSocketClient(URI serverUri, CountDownLatch latch , int todoId) {
        super(serverUri);
        this.latch = latch;
        this.todoId = todoId;
    }

    public void sendConnectionInit() {
        String initMessage = String.format("""
        {
          "type": "connection_init",
          "payload": {
            "headers": {
              "Authorization": "Bearer %s"
            }
          }
        }
        """, HASURA_ADMIN_SECRET); // or use "x-hasura-admin-secret" if Hasura uses admin secret

        send(initMessage);
    }

    public void sendSubscriptionMessage() {
        String query = String.format("""
            subscription {
              todos_by_pk(id: %d) {
                title
              }
            }
            """, todoId);

        String message = String.format("""
            {
              "id": "1",
              "type": "start",
              "payload": {
                "query": "%s",
                "variables": {}
              }
            }
            """, query.replace("\"", "\\\"").replace("\n", ""));

        send(message);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("WebSocket opened");
    }





    @Override
    public void onMessage(String message) {
        receivedMessage = message;
        System.out.println("Received message: " + receivedMessage);

        // Ignore keep-alive messages
        if ("{\"type\":\"ka\"}".equals(receivedMessage)) {
            return;
        }

        JsonPath jsonPath = new JsonPath(receivedMessage);
        String type = jsonPath.getString("type");

        if ("data".equals(type)) {
            String updatedTitle = jsonPath.getString("payload.data.todos_by_pk.title");
            System.out.println("Received title: " + updatedTitle);
            if (updatedTitle.equals("Testing Title")) {
                    latch.countDown();
                    System.out.println("Expected title received: " + updatedTitle);
                    close();
                } else {
                    return;
                }
            }
    }




    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("WebSocket closed: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("WebSocket error: " + ex.getMessage());
    }

    public String getReceivedMessage() {
        return receivedMessage;
    }

}
