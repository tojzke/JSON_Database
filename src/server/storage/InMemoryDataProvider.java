package server.storage;

import server.model.Record;

public class InMemoryDataProvider implements DataProvider {

    private Record[] records;
    private int capacity;

    /**
     * Constructs in-memory data holder with max capacity, starting from 1 to {@code capcity}
     * @param capacity max records number
     */
    public InMemoryDataProvider(int capacity) {
        this.capacity = capacity;
        this.records = new Record[capacity];
    }

    @Override
    public void save(Record record, int id) {
        id -= 1;
        if (id < 0 || id > capacity) {
            throw new IllegalStateException("Can't save record with id: " + id);
        }
        records[id] = record;
    }

    @Override
    public Record get(int id) {
        id -= 1;
        if (id < 0 || id > capacity || records[id] == null) {
           throw new IllegalStateException("Not found record with id: " + id);
        }
        return records[id];
    }

    @Override
    public void delete(int id) {
        id -= 1;
        if (id < 0 || id > capacity) {
            throw new IllegalStateException("Not found record with id: " + id);
        }
        records[id] = null;
    }
}
