package server.storage;

import server.model.Record;

public interface DataProvider {

    void save(Record record, int id);
    Record get(int id);
    void delete(int id);

}
