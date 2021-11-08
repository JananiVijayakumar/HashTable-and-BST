package com.bridgelabz;

import java.util.*;

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
        this(1000);
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

    public String getKeyValue(Integer key){
        int arrayIndex = getArrayIndex(key);
        HNode head = Array[arrayIndex];
        while (head != null){
            if (head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    //To find the frequency of words in a large paragraph phrase
    public void frequencyOfWordsInPara(String str){
        Map<String, Integer> map = new TreeMap<>();
        String arr[] = str.split(" ");
        for (int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+ "->"+entry.getValue());
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        System.out.println("...................................................................");
        //Checking the values of the key
        System.out.println("Finding Given key value : "+hashTable.getKeyValue(1000));
        String paraString = "paranoids are not paranoids because they are paranoid but they keep putting themselves deliberately into paranoid avoidable situation";
        System.out.println("Given Paragraph is : " + paraString);
        hashTable.frequencyOfWordsInPara(paraString);
    }
}
