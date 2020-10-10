package server.input;

import server.ApplicationContext;

public class DeleteCommand implements Command {

    private int id;

    public DeleteCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(ApplicationContext context) {
        var dataProvider = context.getDataProvider();
        dataProvider.delete(id);
        System.out.println("OK");
    }

    @Override
    public String toString() {
        return "DeleteCommand{" +
                "id=" + id +
                '}';
    }
}
