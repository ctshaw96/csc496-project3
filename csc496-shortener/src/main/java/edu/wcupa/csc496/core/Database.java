package edu.wcupa.csc496.core;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final Logger LOG = LoggerFactory.getLogger(Database.class);
    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    public static Map<String, String> db = new HashMap();

    public static void testDB() {
        MongoClient mongoClient = new  MongoClient(HOST, PORT);
        DB database = mongoClient.getDB("url-shortener");

        //Print out DBs
        mongoClient.getDatabaseNames().forEach(System.out::println);

        //Create new table/collection
        database.createCollection("urls", null);

        //Print out tables
        database.getCollectionNames().forEach(System.out::println);
    }



}
