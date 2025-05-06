package Tests;

import Utils.GraphQLWebSocketClient;
import Utils.GraphQL_Utils;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GraphQLTests {

    @Test
    public void testGraphQLMutationAndSubscriptionFlow() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        int todoId = GraphQL_Utils.insertTodo();
        System.out.println("Inserted todo ID: " + todoId);
        URI uri = new URI("wss://hasura.io/learn/graphql");
        GraphQLWebSocketClient client = new GraphQLWebSocketClient(uri,latch,  todoId);
        client.connectBlocking(); // wait until connection is open
        client.sendConnectionInit();
        client.sendSubscriptionMessage();
        GraphQL_Utils.updateTodoTitle(todoId, "Testing Title");
        latch.await(1, TimeUnit.SECONDS);
        String message = client.getReceivedMessage();
        Assert.assertTrue(message.contains("Testing Title"), "WebSocket should receive updated title");
        client.close();
    }

}
