package server;

import com.google.gson.Gson;
import org.junit.Test;
import server.input.StatusType;
import server.network.Response;

import static org.junit.Assert.*;

public class ResponseTest {


    @Test
    public void createResponse() {
        var getResponse = new Response(StatusType.OK, "Nice");
        var expectedGetMessage = "{\"response\":\"OK\",\"value\":\"Nice\"}";
        var actualGetMessage = new Gson().toJson(getResponse);
        assertEquals(expectedGetMessage, actualGetMessage);

        var setResponse = new Response(StatusType.OK);
        var expectedSetResponse = "{\"response\":\"OK\"}";
        var acutalSetResponse = new Gson().toJson(setResponse);
        assertEquals(expectedSetResponse, acutalSetResponse);

    }

}