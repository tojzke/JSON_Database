package server.input;

import server.ApplicationContext;
import server.model.Record;

public class SetCommand implements Command {

    // Args
    private Record record;
    private int id;

    public SetCommand(Record record, int id) {
        this.record = record;
        this.id = id;
    }

    @Override
    public void execute(ApplicationContext context) {
        var dataProvider = context.getDataProvider();
        dataProvider.save(record, id);
        System.out.println("OK");
    }

    @Override
    public String toString() {
        return "SetCommand{" +
                "record=" + record +
                ", id=" + id +
                '}';
    }
}
