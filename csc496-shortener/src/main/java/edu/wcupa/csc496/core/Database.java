package edu.wcupa.csc496.core;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final Logger LOG = LoggerFactory.getLogger(Database.class);
    private static final String HOST = "mongodb";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final int PORT = 27017;
    public static Map<String, String> db = new HashMap();

    public static void testDB() {
        MongoCredential credential = MongoCredential.createCredential(USERNAME, "urls", PASSWORD.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress(HOST, PORT),
                Arrays.asList(credential));
        DB database = mongoClient.getDB("url-shortener");


        //Print out DBs
        mongoClient.getDatabaseNames().forEach(System.out::println);

        //Create new table/collection
        database.createCollection("urls", null);

        //Print out tables
        database.getCollectionNames().forEach(System.out::println);
    }



}
