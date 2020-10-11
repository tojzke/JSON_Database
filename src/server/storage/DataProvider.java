package server.storage;

import server.model.Record;

public interface DataProvider {

    void save(String key, Record record) throws Exception;
    Record get(String key) throws Exception;
    Record delete(String key) throws Exception;

}
