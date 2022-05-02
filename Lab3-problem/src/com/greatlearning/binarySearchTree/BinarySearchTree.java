package com.greatlearning.binarySearchTree;

import java.util.HashSet;

// Class Node.
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node node = null;
        node = binarySearchTree.insertKey(node, 40);
        node = binarySearchTree.insertKey(node, 20);
        node = binarySearchTree.insertKey(node, 70);
        node = binarySearchTree.insertKey(node, 10);
        node = binarySearchTree.insertKey(node, 30);
        node = binarySearchTree.insertKey(node, 50);
        node = binarySearchTree.insertKey(node, 60);

        int sum = 130;
        binarySearchTree.FindSumPair(sum, node);
    }

    Node insertKey(Node root, int key) {

        // Return a new node if the tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Traverse to the right place and insert the node
        if (key < root.key)
            root.left = insertKey(root.left, key);
        else if (key > root.key)
            root.right = insertKey(root.right, key);

        return root;
    }

    public void FindSumPair (int sum, Node root) {
        HashSet<Integer> pair=new HashSet<Integer>();
        if (!FindSumUtil(sum,root, pair)) {
            System.out.println("nodes are not found.");
        }
    }

    static boolean FindSumUtil(int sum, Node root, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (FindSumUtil(sum, root.left, set)) {
            return true;
        }
        if (set.contains(sum - root.key)) {
            System.out.println("pair is (" + root.key + " ," + (sum - root.key) + ")");
            return true;
        } else {
            set.add(root.key);
        }
        return FindSumUtil(sum, root.right, set);
    }
}
