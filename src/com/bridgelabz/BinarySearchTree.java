package com.bridgelabz;

/*
Author : janani Vijayakumar
Date : 06-11-2021
Desc : To create a Binary Search Tree
 */

public class BinarySearchTree {
    INode root;
    BinarySearchTree() {
        root = null;
    }
    static class INode {
        int item;
        INode left, right;
        public INode(int key) {
            item = key;
            left = right = null;
        }
    }

    public void insert(INode node, int value) {
        if (value < node.item) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.item);
                node.left = new INode(value);
            }
        } else if (value > node.item) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + node.item);
                node.right = new INode(value);
            }
        }
    }
    public void traverseInOrder(INode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.item);
            traverseInOrder(node.right);
        }
    }

    public static void main(String[] args) {
            //create object of tree
            BinarySearchTree tree = new BinarySearchTree();
            //create nodes of the tree
        System.out.println("Binary tree :");
        System.out.println("....................................");
        INode root = new INode(56);
        tree.insert(root, 30);
        tree.insert(root, 70);
        tree.insert(root, 22);
        tree.insert(root, 40);
        tree.insert(root, 11);
        tree.insert(root, 3);
        tree.insert(root, 16);
        tree.insert(root, 70);
        tree.insert(root, 60);
        tree.insert(root, 95);
        tree.insert(root, 65);
        tree.insert(root, 63);
        tree.insert(root, 67);
        System.out.println("Traversing tree in order");
        tree.traverseInOrder(tree.root);
        }
    }