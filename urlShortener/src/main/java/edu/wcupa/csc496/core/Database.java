package edu.wcupa.csc496.core;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final Logger LOG = LoggerFactory.getLogger(Database.class);
    private static final String HOST = "mongodb";
    private static final int PORT = 27017;
    private static final String COLLECTION_NAME = "urls";
    public static Map<String, String> db = new HashMap();

    public static void initDB() {
        MongoClient mongoClient = new  MongoClient(HOST, PORT);
        DB database = mongoClient.getDB("url-shortener");

        if (!database.collectionExists(COLLECTION_NAME)) {
            //Create new table/collection
            database.createCollection(COLLECTION_NAME, null);
        }
    }

    public static boolean insert(String url, String keyword) {
        MongoClient mongoClient = new  MongoClient(HOST, PORT);
        DB database = mongoClient.getDB("url-shortener");
        DBCollection collection = database.getCollection(COLLECTION_NAME);
        long beforeCount = collection.getCount();
        database.command("{\n" +
                "      insert: \""+ COLLECTION_NAME +"\",\n" +
                "      documents: [ { keyword:" + keyword +", url:"+ url +"} ]\n" +
                "   }");
        return collection.getCount() > beforeCount;
    }





}
