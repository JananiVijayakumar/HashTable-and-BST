package com.bridgelabz;

public class HashTable {
    private HNode Array[];
    private int noOfArrays;
    private int size;
    //Create HashTable custom array Constructor
    public HashTable(int data) {
        this.noOfArrays = data;
        this.Array = new HNode[noOfArrays];
        this.size = 0;
    }
    public HashTable() {
        this(10);
    }

    //Create HashNode like Linked list one link and two data types
    public class HNode {
        private Integer key;
        private String value;
        private HNode next;
        //Create HashNode like Linked list Constructor
        public HNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    //Fix the index depending on the key value for reducing the no of searching iterations
    public int getArrayIndex(Integer key) {
        int index = key % noOfArrays;
        return index;
    }

    //Put data in Hash Table using linked Node
    public void putData(Integer key, String value) {
        if (key == null || value == null) {
            System.out.println("key or value are null");
        }
        int arrayIndex = getArrayIndex(key);
        HNode head = Array[arrayIndex];
        // check existing node in hash table
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = Array[arrayIndex];
        HNode node = new HNode(key, value);
        node.next = head;
        Array[arrayIndex] = node;

    }

    //Checking given string no.of times in Hash Table
    public int frequencyWordChecker(String value) {
        HNode node = Array[0];
        int wordCount = 0;
        while (node != null) {
            if (node.value.equals(value)) {
                wordCount++;
            }
            node = node.next;
        }
        return wordCount;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.putData(10, "To");
        hashTable.putData(20, "be");
        hashTable.putData(30, "or");
        hashTable.putData(40, "not");
        hashTable.putData(50, "to");
        hashTable.putData(60, "be");
        System.out.println("The size of hash table is : " + hashTable.size);
        System.out.println("...................................................................");
        System.out.println("Frequency of Words :");
        System.out.println("Frequency of 'To' : "+hashTable.frequencyWordChecker("To"));
        System.out.println("Frequency of 'be' : "+hashTable.frequencyWordChecker("be"));
        System.out.println("Frequency of 'or' : "+hashTable.frequencyWordChecker("or"));
        System.out.println("Frequency of 'not' : "+hashTable.frequencyWordChecker("not"));
    }
}
