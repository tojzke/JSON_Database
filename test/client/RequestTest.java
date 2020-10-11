package client;

import client.nerwork.Request;
import com.beust.jcommander.JCommander;
import org.junit.Test;

public class RequestTest {

    @Test
    public void testCreateJson() {
        String[] args = {"-t", "get", "-k", "key"};

        Args request = new Args();
        JCommander.newBuilder()
                .addObject(request)
                .build()
                .parse(args);

        System.out.println(request);
    }

    @Test
    public void testRequestFromFile() {
        String[] args = {"-in", "test.txt"};

        var commander = new JCommander();
        commander.parse(args);
    }

}