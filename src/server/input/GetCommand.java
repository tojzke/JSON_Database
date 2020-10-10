package server.input;

import server.ApplicationContext;

public class GetCommand implements Command {

    private int id;

    public GetCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(ApplicationContext context) {
        var dataProvider = context.getDataProvider();
        var record = dataProvider.get(id);
        System.out.println(record.getContent());
    }

    @Override
    public String toString() {
        return "GetCommand{" +
                "id=" + id +
                '}';
    }
}
