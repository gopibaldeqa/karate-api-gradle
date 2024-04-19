package dev.be.karate_demo_project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private final String NOT_EXIST = "not exist key";

    private Map<String, String> map = new HashMap<>() {{
        put("good", "gid");
        put("hello", "world");
    }};

    public boolean addNewValue(String key, String value) {
        if (map.containsKey(key)) {
            return false;
        }
        map.put(key, value);
        return true;
    }

    public String getValue(String key) {
        return map.getOrDefault(key, NOT_EXIST);
    }
}
