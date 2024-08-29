package cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> map;

    public LRUCache2(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        this.capacity = capacity;
        // Create a LinkedHashMap with accessOrder set to true
        this.map = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCache2.this.capacity;
            }
        };
    }

    // Get value from the cache
    public V get(K key) {
        return map.get(key);
    }

    // Put value into the cache
    public void put(K key, V value) {
        map.put(key, value);
    }
}

