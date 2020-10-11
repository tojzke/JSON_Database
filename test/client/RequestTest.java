package client;

import client.nerwork.Request;
import com.beust.jcommander.JCommander;
import org.junit.Test;

public class RequestTest {

    @Test
    public void testCreateJson() {
        String[] args = {"-t", "get", "-k", "key"};

        Request request = new Request();
        JCommander.newBuilder()
                .addObject(request)
                .build()
                .parse(args);

        System.out.println(request);

    }

}