package server.storage;

import server.model.Record;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMapDataProvider implements DataProvider {

    private Map<String, Record> records;

    public InMemoryMapDataProvider(int capacity) {
        this.records = new HashMap<>(capacity);
    }

    @Override
    public void save(String key, Record record) throws Exception {
        records.put(key, record);
    }

    @Override
    public Record get(String key) throws Exception {
        return records.getOrDefault(key, null);
    }

    @Override
    public Record delete(String key) throws Exception {
        return records.remove(key);
    }
}
