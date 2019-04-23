package edu.wcupa.core;

import com.mongodb.*;
import com.mongodb.client.model.Filters;
import edu.wcupa.data.LinkToShorten;
import edu.wcupa.data.LinkToShortenIF;
import edu.wcupa.tools.RosettaMongoDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private static final Logger LOG = LoggerFactory.getLogger(Database.class);
    private static final String HOST = "mongodb";
    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "url-shortener";
    private static final String COLLECTION_NAME = "links";
    public static Map<String, String> db = new HashMap();
    private static DB database;

    public static void initDB() {
        // Instantiate generated repository
/*        ItemRepository items = new ItemRepository(
                RepositorySetup.forUri("mongodb://localhost/test"));*/

        MongoClient mongoClient = new  MongoClient(HOST, PORT);
        database = mongoClient.getDB(DATABASE_NAME);

    }

    public static void clearDB() {
        LOG.warn("Clearing collection {}...", COLLECTION_NAME);
        DBCollection collection = database.getCollection(COLLECTION_NAME);
        collection.drop();
        createIfCollectionDoesNotExist();
    }

    private static void createIfCollectionDoesNotExist() {
        //new BasicDBObject("url", 1), new BasicDBObject("unique", true));
        if (!database.collectionExists(COLLECTION_NAME)) {
            //Create new table/collection
            System.out.println(COLLECTION_NAME + " did not exist, creating now...");
            database.createCollection(COLLECTION_NAME, null);
            DBCollection collection = database.getCollection(COLLECTION_NAME);
            collection.createIndex(new BasicDBObject("keyword", 1), new BasicDBObject("unique", true));
        }
    }

    public static boolean insertShortenLink(LinkToShorten linkToShorten) {
        /*LOG.info("Connecting to MongoDB...");
        MongoClient mongoClient = new  MongoClient(HOST, PORT);
        LOG.info("Connecting to {}...", DATABASE_NAME);
        DB database = mongoClient.getDB(DATABASE_NAME); */
        LOG.debug("Connecting to {}...", COLLECTION_NAME);
        DBCollection collection = database.getCollection(COLLECTION_NAME);
        long beforeCount = collection.getCount();

        LOG.debug("Building document to insert...");
        BasicDBObject document = RosettaMongoDB.objectToDocument(linkToShorten);

        LOG.info("Inserting into {}...", COLLECTION_NAME);
        collection.insert(document);

        LOG.info("Successfully inserted...");
        return collection.getCount() > beforeCount;
    }

    public static LinkToShorten getLink(String keyword) {
        /*LOG.info("Attempting to fetch story [{}]...", storyHash);
        MongoClient mongoClient = new  MongoClient(HOST, PORT);
        LOG.info("Connecting to {}...", DATABASE_NAME);
        DB database = mongoClient.getDB(DATABASE_NAME);*/
        LOG.debug("Connecting to {}...", COLLECTION_NAME);
        DBCollection collection = database.getCollection(COLLECTION_NAME);
        LOG.info("Looking for {}", keyword);

        DBObject dbObject = collection.find(new BasicDBObject("keyword", keyword)).one();
        LOG.info("Fetched object: {}", dbObject);
        return (LinkToShorten) RosettaMongoDB.documentToObject(dbObject);
    }

    public static List<LinkToShorten> getAllLinks() {
        List<LinkToShorten> list = new ArrayList<>();
        DBCollection collection = database.getCollection(COLLECTION_NAME);

        collection.find().forEachRemaining( dbObject -> {
            list.add((LinkToShorten) RosettaMongoDB.documentToObject(dbObject));
        });
        return list;
    }

}
