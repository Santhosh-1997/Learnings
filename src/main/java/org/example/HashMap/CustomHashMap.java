package org.example.HashMap;

import java.util.Arrays;

public class CustomHashMap<K, V> {
    static class Entry<K, V>{
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private int DEFAULT_CAPACITY = 12;

    private Entry<K, V>[] buckets;

    public CustomHashMap() {
        buckets = new Entry[DEFAULT_CAPACITY];
    }

    public int getBucketIndex(K key){
        return key.hashCode() % buckets.length;
    }
    public void put(K key, V value){
        int index = getBucketIndex(key);
        Entry<K, V> entry = buckets[index];
        Entry<K, V> current = entry;
        while(current != null){
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = entry;
        buckets[index] = newEntry;
    }

    public V get(K key){
        int index = getBucketIndex(key);
        Entry<K, V> entry = buckets[index];
        if(entry == null)
            return null;
        while(entry != null){
            if(entry.key.equals(key))
                return entry.value;
            entry = entry.next;
        }
        return null;
    }


    public static void main(String[] args) {
        CustomHashMap<String, String> map = new CustomHashMap();
        map.put("1", "santhosh");
        map.put("2", "Sandy");
        System.out.println(map.get("1"));
        System.out.println(map.get("3"));
    }

    @Override
    public String toString() {
        return "CustomHashMap{" +
                "buckets=" + Arrays.toString(buckets) +
                '}';
    }
}
