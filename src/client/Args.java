package client;

import com.beust.jcommander.Parameter;

public class Args {

    @Parameter(names = "-in",
            description = "Filename")
    private String filename;

    @Parameter(names = "-fileroot",
            description = "Root of searching files")
    private String fileroot = "src/client/data";

    @Parameter(names = "-t",
            description = "Type of request")
    private String type;

    @Parameter(names = "-k", description = "Key for storing in database")
    private String key;

    @Parameter(names = "-v", description = "Value for storing in database")
    private String value;

    public String getFileroot() {
        return fileroot;
    }

    public String getFilename() {
        return filename;
    }

    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
