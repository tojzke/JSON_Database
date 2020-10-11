package client;

import com.beust.jcommander.Parameter;

public class Request {

    @Parameter(names = "-t",
            description = "Type of request")
    private String type;

    @Parameter(names = "-i", description = "Index of data in database")
    private Integer index;

    @Parameter(names = "-m", description = "Content of 'set' request")
    private String content;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        if (!"exit".equals(type)) {
            sb.append(" ");
            sb.append(index);
            if (content != null) {
                sb.append(" ");
                sb.append(content);
            }
        }
        return sb.toString();
    }
}
