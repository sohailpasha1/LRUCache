package cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // HashMap to store node references
    private Map<Integer, Node> map;
    private int count, capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        // Initialize the HashMap
        map = new HashMap<>();

        // Create dummy head and tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        // Connect head and tail
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node node) {
        // Remove node from the list
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        // Add node right after the head
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1; // Key not found
        }
        // Move the retrieved node to the head
        deleteNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            // Update the value of the existing node and move it to the head
            node.value = value;
            deleteNode(node);
        } else {
            // Create a new node
            node = new Node(key, value);
            if (count >= capacity) {
                // Remove the least recently used node (from the tail)
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                count--;
            }
            map.put(key, node);
            count++;
        }
        // Add the new or updated node to the head
        addToHead(node);
    }
}
