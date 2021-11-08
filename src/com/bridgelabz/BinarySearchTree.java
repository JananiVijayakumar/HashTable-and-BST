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

        public void addNodeInBST(INode node) {
            if (node == null)
                return;
            // traverse the root node
            System.out.print(node.item + "->");
            // traverse the left child node
            addNodeInBST(node.left);
            // traverse the right child node
            addNodeInBST(node.right);
        }

        public static void main(String[] args) {
            //create object of tree
            BinarySearchTree tree = new BinarySearchTree();
            //create nodes of the tree
            tree.root = new INode(56);
            tree.root.left = new INode(30);
            tree.root.right = new INode(70);
            // Binary search tree traversal
            System.out.println("Binary Search tree : ");
            tree.addNodeInBST(tree.root);
        }
    }