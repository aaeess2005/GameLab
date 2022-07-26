package io.github.aaeess2005.gamelab.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {
    public static JsonElement getDataInPath(String str, String path) {
        String[] obj = path.split("\\.");
        JsonObject tmp = JsonParser.parseString(str).getAsJsonObject();
        for (int i = 0; i < obj.length - 1; i++) {
            tmp = tmp.getAsJsonObject(obj[i]);
        }
        return tmp.get(obj[obj.length - 1]);
    }

    public static JsonElement getDataInPath(JsonObject json, String path) {
        String[] obj = path.split("\\.");
        JsonObject tmp = json;
        for (int i = 0; i < obj.length - 1; i++) {
            tmp = tmp.getAsJsonObject(obj[i]);
        }
        return tmp.get(obj[obj.length - 1]);
    }
}
