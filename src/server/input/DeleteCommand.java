package server.input;

import server.ApplicationContext;

public class DeleteCommand implements Command {

    private int id;

    public DeleteCommand(int id) {
        this.id = id;
    }

    @Override
    public Status execute(ApplicationContext context) {
        var dataProvider = context.getDataProvider();
        try {
            dataProvider.delete(id);
            return new Status(StatusType.OK);
        } catch (Exception e) {
            return new Status(StatusType.ERROR);
        }
    }

    @Override
    public String toString() {
        return "DeleteCommand{" +
                "id=" + id +
                '}';
    }
}
