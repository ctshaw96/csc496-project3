package edu.wcupa.tools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import edu.wcupa.data.LinkToShorten;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.el.PropertyNotFoundException;
import java.io.IOException;
import java.util.*;

public class RosettaMongoDB {
    private static final Logger LOG = LoggerFactory.getLogger(RosettaMongoDB.class);


    private final static String QUERY_ARGS_REGEX = "\\:";
    private static final TypeReference LINK_TYPE = new TypeReference<LinkToShorten>(){};


    public static BasicDBObject objectToDocument(Object object) {
        Map<String, Object> objectAsMap = new ObjectMapper().convertValue(object, Map.class);
        List<String> propertyNames = new ArrayList<>(objectAsMap.keySet());

        BasicDBObject document = new BasicDBObject();

        for (String property: propertyNames) {
            document.append(property, objectAsMap.get(property));
        }

        return document;
    }

    public static Object documentToObject(DBObject document) {
        Map<String, Object> objectMap = new HashMap<>();
        for (String property : document.keySet()) {
            if (property.equalsIgnoreCase("_id")) {
                continue;
            }
            objectMap.put(property, document.get(property));
        }
        LOG.debug("Object map: {}", objectMap);
        try {
            return convertToJavaObjectList(objectMap, LINK_TYPE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    public static <T> T convertToFlatJavaObjectList(Map<String, Object> mapIterator, TypeReference type) throws IOException {
        String json = iteratableMapToFlatJson(mapIterator);
        LOG.debug("Json: {}", json);
        return new ObjectMapper().readValue(json,  type);
    }

    public static <T> T convertToJavaObjectList(Map<String, Object> objectMap, TypeReference type) throws IOException {

        Optional optionalPrimitive = isPrimativeObject(type);
        if (optionalPrimitive.isPresent()) {
/*            List list = new ArrayList<>();
                objectMap.values().forEach(value -> {
                    list.add((T) value);
                });

            return list;*/
        }

        String json = iteratableMapToJson(objectMap);
        LOG.info("Json: {}", json);
        return new ObjectMapper().readValue(json,  type);
    }

    private static String iteratableMapToJson(Map<String, Object> objectMap) {
        StringBuilder sb = new StringBuilder();
            sb.append("{");
            objectMap.keySet().forEach(key -> {
                sb.append("\"").append(key).append("\":").append(addQuotesIfNotComplexObject(objectMap.get(key).toString()))
                        .append(sanitizeJsonIfInside(objectMap.get(key))).append(addQuotesIfNotComplexObject(objectMap.get(key).toString())).append(",");
            });
            if (sb.charAt(sb.length()-1) == ',') {
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append("},");
        if (sb.charAt(sb.length()-1) == ',') {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }


    private static String iteratableMapToFlatJson(Map<String, Object> objectMap) {
        StringBuilder sb = new StringBuilder();
        objectMap.keySet().forEach(key -> {
            sb.append(objectMap.get(key));
        });
        sb.append(",");

        if (sb.charAt(sb.length()-1) == ',') {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    private static Optional<Class> isPrimativeObject(TypeReference typeReference) {
        if (typeReference.getType().getTypeName().contains("String")) {
            return Optional.of(String.class);
        }

        return Optional.empty();
    }

    private static String addQuotesIfNotComplexObject(String s) {
        if (s.length() > 1 && s.trim().charAt(0) == '{') { //This is a complex object, don't add quotes
            return "";
        }
        return "\"";
    }

    private static Object sanitizeJsonIfInside(Object object) {
        if (object instanceof String) {
            return String.valueOf(object).replaceAll("\"", "\\\\\"");
        }
        return object;
    }

    private static Object getValueFromObject(Map<String, Object> objectAsMap, String variable) {
        if (!objectAsMap.containsKey(variable)) {
            LOG.warn("Failed to find property {}", variable);
            throw new PropertyNotFoundException("Could not find the property " + variable + " in the given object!");
        }
        Object object = objectAsMap.get(variable);
        if (isNumeric(object)) {
            return object;
        }
        StringBuilder sb = new StringBuilder("'");
        sb.append(object).append("'");
        return sb.toString();
    }

    private static boolean isNumeric(Object object) {
        return object instanceof Long ||
                object instanceof Integer ||
                object instanceof Double;
    }
}
