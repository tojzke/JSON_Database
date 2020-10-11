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
    public Status execute(ApplicationContext context) {
        var dataProvider = context.getDataProvider();
        try {
            dataProvider.save(record, id);
            return new Status(StatusType.OK);
        } catch (Exception e) {
            return new Status(StatusType.ERROR);
        }

    }

    @Override
    public String toString() {
        return "SetCommand{" +
                "record=" + record +
                ", id=" + id +
                '}';
    }
}
