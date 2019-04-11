package com.tryorganized.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final Logger LOG = LoggerFactory.getLogger(Database.class);
    public static Map<String, String> db = new HashMap();
}
