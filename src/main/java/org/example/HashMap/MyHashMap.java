package org.example.HashMap;

public class MyHashMap<K, V> {
    private static int DEFAULT_CAPACITY = 16;
    private Entry<K, V>[] table;
    private int capacity;
    private int size;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }
    public MyHashMap(){
        this(DEFAULT_CAPACITY);
    }

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

    public void put(K key, V value){
        if(key == null) return;

        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);
        Entry<K, V> current = table[hash];
        if(current != null){
            Entry<K, V> previous = null;
            while(current != null){
                if(current.key.equals(key)){
                    current.value = value;
                    return;
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }else{
            table[hash] = newEntry;
        }
        size++;
    }

    public V get(K key){
        int hash = hash(key);
        Entry<K, V> current = table[hash];
        while(current != null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public int size(){
        return size;
    }

    private int hash(K key){
        return key.hashCode() % capacity;
    }
}
