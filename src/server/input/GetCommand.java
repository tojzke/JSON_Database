package server.input;

import server.ApplicationContext;

public class GetCommand implements Command {

    private int id;

    public GetCommand(int id) {
        this.id = id;
    }

    @Override
    public Status execute(ApplicationContext context) {
        var dataProvider = context.getDataProvider();
        try {
            var record = dataProvider.get(id);
            return new Status(StatusType.OK, record.getContent());
        } catch (Exception e) {
            return new Status(StatusType.ERROR);
        }
    }

    @Override
    public String toString() {
        return "GetCommand{" +
                "id=" + id +
                '}';
    }
}
