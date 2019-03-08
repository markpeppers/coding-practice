package com.markpeppers;

class Main {

    public static void main(String[] args) {
        int[] inputList;
        if (args.length == 0) {
            inputList = new int[] {10, 5, 1, 7, 40, 50};
        } else {
            inputList = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                inputList[i] = Integer.parseInt(args[i]);
            }
        }

        Node root = constructBST(inputList);
        printInOrder(root);
        System.out.format("%n");
        printNodes(root);
    }

    private static Node constructBST(int[] input) {
        Node root = null;
        for (int data : input) {
            if (root == null) {
                root = new Node(data);
            } else {
                constructBSTStep(root, data);
            }
        }
        return root;
    }

    private static void constructBSTStep(Node node, int data) {
        if (data < node.data) {
            if (node.left == null) {
                node.left = new Node(data);
                return;
            }
            constructBSTStep(node.left, data);
        } else if (data > node.data) {
            if (node.right == null) {
                node.right = new Node(data);
                return;
            }
            constructBSTStep(node.right, data);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.format("%d ", node.data);
        printInOrder(node.right);
    }

    private static void printNodes(Node node) {
        if (node == null) {
            return;
        }
        printNodes(node.left);
        System.out.format("%d", node.data);
        if (node.left != null) {
            System.out.format(" L %d", node.left.data);
        }
        if (node.right != null) {
            System.out.format(" R %d", node.right.data);
        }
        System.out.format("%n");
        printNodes(node.right);
    }
}
