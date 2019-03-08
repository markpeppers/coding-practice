package com.markpeppers;

public class Main {

    public static void main(String[] args) {
        Node root = new Node(5);
        Node node3 = new Node(3);
        Node node7 = new Node(7);
        root.left = node3;
        root.right = node7;

        Node node1 = new Node(1);
        Node node4 = new Node(4);
        node3.left = node1;
        node3.right = node4;

        Node node6 = new Node(6);
        Node node9 = new Node(9);
        node7.left = node6;
        node7.right = node9;

        System.out.println("Min value is: " + minValue(root));
        System.out.println("Max value is: " + maxValue(root));
        System.out.println("Min value under 7 is " + minValue(node7));
        System.out.println("Max value under 7 is " + maxValue(node7));
        System.out.println("Min value under 1 is " + minValue(node1));
        System.out.println("Max value under 1 is " + maxValue(node1));

        if (isBST(root)) {
            System.out.println("The tree is a BST");
        } else {
            System.out.println("The tree is NOT a BST");
        }

    }

    protected static boolean isBST(Node node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.left != null && maxValue(node.left) > node.data) {
            return false;
        }
        if (node.right != null && node.data > minValue(node.right)) {
            return false;
        }
        if (node.left == null) {
            return isBST(node.right);
        }
        if (node.right == null) {
            return isBST(node.left);
        }
        return isBST(node.left) && isBST(node.right);
    }

    protected static int minValue(Node node) {
        int min = node.data;
        return minValueStep(node, min);
    }

    protected static int minValueStep(Node node, int currentMin) {
        if (node.left == null && node.right == null) {
            if (node.data < currentMin) {
                return node.data;
            } else {
                return currentMin;
            }
        }
        if (node.left == null) {
            return minValue(node.right);
        }
        if (node.right == null) {
            return minValue(node.left);
        }
        int minLeft = minValue(node.left);
        int minRight = minValue(node.right);
        int minChildren = Math.min(minLeft, minRight);
        if (minChildren < currentMin) {
            return minChildren;
        } else {
            return currentMin;
        }
    }

    protected static int maxValue(Node node) {
        int max = node.data;
        return maxValueStep(node, max);
    }

    protected static int maxValueStep(Node node, int currentMin) {
        if (node.left == null && node.right == null) {
            if (node.data > currentMin) {
                return node.data;
            } else {
                return currentMin;
            }
        }
        if (node.left == null) {
            return maxValue(node.right);
        }
        if (node.right == null) {
            return maxValue(node.left);
        }
        int maxLeft = maxValue(node.left);
        int maxRight = maxValue(node.right);
        int maxChildren = Math.max(maxLeft, maxRight);
        if (maxChildren > currentMin) {
            return maxChildren;
        } else {
            return currentMin;
        }
    }
}
