package org.example.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node{
        public int key, value;
        public Node next, prev;
        Node(){
            key = value = -1;
            next = prev = null;
        }
        Node(int k, int v){
            key = k;
            value = v;
            next = prev = null;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node node){
        if(node.prev != null)
            node.prev.next = node.next;
        if(node.next != null)
            node.next.prev = node.prev;
    }

    private void insertAfterHead(Node node){
        Node nextNode = head.next;
        nextNode.prev = node;
        node.next = nextNode;
        node.prev = head;
        head.next = node;
    }

    public int get(int key){
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            node.value = value;
            insertAfterHead(node);
            return;
        }

        if(map.size() == capacity){
            Node node = tail.prev;
            deleteNode(node);
            map.remove(node.key);
        }
        Node newNode = new Node(key, value);
        insertAfterHead(newNode);
        map.put(key, newNode);
    }



}
