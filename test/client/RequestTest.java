package client;

import client.network.Request;
import com.beust.jcommander.JCommander;
import org.junit.Test;

public class RequestTest {

    @Test
    public void testCreateJson() {
        Args args = new Args();
        String[] consoleArgs = {"-t", "get", "-k", "key"};


        JCommander.newBuilder()
                .addObject(args)
                .build()
                .parse(consoleArgs);

        Request request = new Request(args.getType(), args.getKey(), args.getValue());
        System.out.println(request);

    }

}