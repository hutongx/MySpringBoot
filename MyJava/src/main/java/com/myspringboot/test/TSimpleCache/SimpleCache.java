package com.myspringboot.test.TSimpleCache;

import java.util.HashMap;
import java.util.Map;

public class SimpleCache<K, V> {
    private Map<K, V> cache = new HashMap<>();
    private Map<K, Long> timestamps = new HashMap<>();
    private long ttl; // 生存时间（毫秒）

    public SimpleCache(long ttlMillis) {
        this.ttl = ttlMillis;
    }

    public void put(K key, V value) {
        cache.put(key, value);
        timestamps.put(key, System.currentTimeMillis());
    }

    public V get(K key) {
        Long timestamp = timestamps.get(key);
        if (timestamp == null) {
            return null;
        }

        // 检查是否过期
        if (System.currentTimeMillis() - timestamp > ttl) {
            cache.remove(key);
            timestamps.remove(key);
            return null;
        }

        return cache.get(key);
    }

    public boolean containsKey(K key) {
        return get(key) != null; // 利用get方法的过期检查
    }
}
