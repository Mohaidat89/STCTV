package Core.Helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadWriteHelper {

    public static Object getJsonInfo(String jsonFile) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(jsonFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static Map<String, Object> saveJsonInMap(JSONObject object) {
        Map<String, Object> map = new HashMap();

        Iterator keys = object.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object value = object.get(key);
            if (value instanceof JSONObject) {
                value = saveJsonInMap((JSONObject) value);
            }
            if (value instanceof JSONArray) {
                value = saveJsonInList((JSONArray) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> saveJsonInList(JSONArray object) {
        List<Object> list = new ArrayList<Object>();

        for (int i = 0; i < object.size(); i++) {
            Object value = object.get(i);
            if (value instanceof JSONObject) {
                value = saveJsonInMap((JSONObject) value);
            }
            if (value instanceof JSONArray) {
                value = saveJsonInList((JSONArray) value);
            }
            list.add(value);
        }

        return list;
    }

    public static Map<String, Object> getDataFromJson(String filePath) {
        JSONParser parser = new JSONParser();
        Map<String, Object> map = new HashMap();
        try {
            JSONObject obj = (JSONObject) parser.parse(new FileReader(filePath));

            Iterator keys = obj.keySet().iterator();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object value = obj.get(key);

                if (value instanceof JSONObject) {
                    value = saveJsonInMap((JSONObject) value);
                }
                if (value instanceof JSONArray) {
                    value = saveJsonInList((JSONArray) value);
                }
                map.put(key, value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}