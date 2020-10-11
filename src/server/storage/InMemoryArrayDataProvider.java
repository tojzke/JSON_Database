package server.storage;

import server.model.Record;

public class InMemoryArrayDataProvider implements DataProvider {

    private Record[] records;
    private int capacity;

    /**
     * Constructs in-memory data holder with max capacity, starting from 1 to {@code capcity}
     * @param capacity max records number
     */
    public InMemoryArrayDataProvider(int capacity) {
        this.capacity = capacity;
        this.records = new Record[capacity];
    }

    @Override
    public void save(String keyAsStr, Record record) {
        int key = Integer.parseInt(keyAsStr);
        key -= 1;
        if (key < 0 || key > capacity) {
            throw new IllegalStateException("Can't save record with id: " + key);
        }
        records[key] = record;
    }

    @Override
    public Record get(String keyAsStr) {
        int key = Integer.parseInt(keyAsStr);
        key -= 1;
        if (key < 0 || key > capacity || records[key] == null) {
           throw new IllegalStateException("Not found record with id: " + key);
        }
        return records[key];
    }

    @Override
    public Record delete(String keyAsStr) {
        int key = Integer.parseInt(keyAsStr);
        key -= 1;
        if (key < 0 || key > capacity) {
            throw new IllegalStateException("Not found record with id: " + key);
        }
        var record = records[key];
        records[key] = null;
        return record;
    }
}
