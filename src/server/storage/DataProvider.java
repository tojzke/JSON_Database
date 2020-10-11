package server.storage;

import server.model.Record;

public interface DataProvider {

    void save(Record record, int id) throws Exception;
    Record get(int id) throws Exception;
    void delete(int id) throws Exception;

}
