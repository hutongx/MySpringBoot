package com.myspringboot.test.TTypeGeneric;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// =================== 5. 测试类 ===================
class TestClass extends HashMap<String, Integer> {
    private List<String> names = Arrays.asList("Alice", "Bob");
    private Map<String, Integer> scores = new HashMap<>();

    public TestClass() {
        scores.put("Alice", 95);
        scores.put("Bob", 87);
    }
}
