package server.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import server.model.Record;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JsonFileDataProvider implements DataProvider {

    private static final String DEFAULT_DB_FILEPATH = "./src/server/data/db.json";

    private final ReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock readLock = rwl.readLock();
    private final Lock writeLock = rwl.writeLock();
    private final Gson gson = new Gson();
    Type recordMapType = new TypeToken<Map<String, Record>>() {}.getType();

    public JsonFileDataProvider() throws IOException {
        File file = new File(DEFAULT_DB_FILEPATH);
        file.getParentFile().mkdirs();
        file.createNewFile();
    }

    @Override
    public void save(String key, Record record) throws Exception {
        writeRecordToJsonFileDatabase(key, record);
    }

    @Override
    public Record get(String key) throws Exception {
        Map<String, Record> records = readJsonFileDatabase();
        return records.getOrDefault(key, null);
    }

    @Override
    public Record delete(String key) throws Exception {
        return deleteFromJsonFileDatabase(key);
    }

    private Record deleteFromJsonFileDatabase(String key) throws IOException {
        Map<String, Record> records = readJsonFileDatabase();
        Record record = records.remove(key);
        writeToJsonFileDatabase(records);
        return record;
    }

    private Map<String, Record> readJsonFileDatabase() throws FileNotFoundException {
        readLock.lock();
        FileReader reader = new FileReader(DEFAULT_DB_FILEPATH);
        var jsonReader = new JsonReader(reader);
        Map<String, Record> records = gson.fromJson(jsonReader, recordMapType);
        if (records == null) {
            records = new HashMap<>();
        }
        readLock.unlock();
        return records;
    }

    private void writeRecordToJsonFileDatabase(String key, Record record) throws IOException {
        Map<String, Record> records = readJsonFileDatabase();
        records.put(key, record);
        writeToJsonFileDatabase(records);
    }

    private void writeToJsonFileDatabase(Map<String, Record> records) throws IOException {
        try (Writer writer = new FileWriter(DEFAULT_DB_FILEPATH)) {
            writeLock.lock();
            new Gson().toJson(records, writer);
            writer.flush();
            writeLock.unlock();
        }
    }
}
