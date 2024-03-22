package org.example.datastructure;

import java.util.Arrays;
import java.util.List;

public class BinaryTree<T> {
    private TreeNode<T> root;

    private static class TreeNode<T> {
        private TreeNode<T> left;
        private TreeNode<T> right;
        private final T data;

        public TreeNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    '}';
        }
    }

    public void generateTree(List<T> data) {
        Queue<TreeNode<T>> queue = new Queue<>();
        root = new TreeNode<>(data.get(0));
        queue.enqueue(root);
        int i = 1;
        while (i < data.size()) {
            TreeNode<T> temp = queue.dequeue();
            temp.left = new TreeNode<>(data.get(i));
            queue.enqueue(temp.left);
            if (i + 1 < data.size()) {
                temp.right = new TreeNode<>(data.get(i + 1));
                queue.enqueue(temp.right);
            }
            i += 2;
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<T> current) {
        if (current == null) {
            return;
        }
        System.out.println("current.data = " + current.data);
        System.out.println("current.left = " + current.left);
        System.out.println("current.right = " + current.right);
        System.out.println();
        preOrder(current.left);
        preOrder(current.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode<T> current) {
        if (current == null) {
            return;
        }
        inOrder(current.left);
        System.out.println("current.data = " + current.data);
        System.out.println("current.left = " + current.left);
        System.out.println("current.right = " + current.right);
        System.out.println();
        inOrder(current.right);
    }

    public int findMax() {
        return findMax(root);
    }

    private int findMax(TreeNode<T> current) {
        if (current == null) return Integer.MIN_VALUE;
        int result = (Integer) current.data;
        int left = findMax(current.left);
        int right = findMax(current.right);
        if (left > result) result = left;
        if (right > result) result = right;
        return result;
    }

    public void insert(int value) {
        root = (TreeNode<T>) insertInt(root, value);
    }

    public TreeNode<Integer> insertInt(TreeNode<T> root, int value) {
        if (root == null) {
            return new TreeNode<>(value);
        }

        try {
            if (value < (Integer) root.data) {
                root.left = (TreeNode<T>) insertInt(root.left, value);
            } else {
                root.right = (TreeNode<T>) insertInt(root.right, value);
            }

            return (TreeNode<Integer>) root;
        } catch (Exception e) {
            System.out.println("Given TreeNode is invalid type, expected Integer.");
            return new TreeNode<>(0);
        }
    }

    public TreeNode<Integer> findNumber(int value) {
        return findNumber((TreeNode<Integer>) root, value);
    }

    public TreeNode<Integer> findNumber(TreeNode<Integer> root, int value) {
        if (root == null || root.data == value) return root;
        if (value < root.data) return findNumber(root.left, value);
        else return findNumber(root.right, value);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        BinaryTree<String> tree = new BinaryTree<>();
        tree.generateTree(Arrays.asList("Nvz5x4PDhmL", "nc9CrOWBdlZ", "JdPHgACYL", "Ezh9TbYF", "KXioXUnI3B", "JhKbTEht5TZ", "PID9aDbyRr", "OybnNmRUWMJ", "JzWZq7ChJw", "icksrkfCg", "X2hvQSIB", "xjMhiqeQSj", "9EwbUZiIR7", "7ocA4tA", "fb0AQX1", "0xv4y6oAJ", "p5BGAgHn", "9laMK40G11", "sNnB2TbH", "z1hxtbDF"));
        binaryTree.generateTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 343, 65, 75, 9, 12, 3456, 56));
        binaryTree.preOrder();
        binaryTree.inOrder();
        tree.preOrder();
        System.out.println("binaryTree.findMax() = " + binaryTree.findMax());

        BinaryTree<Integer> binaryTreeInsert = new BinaryTree<>();
        binaryTreeInsert.insert(10);
        binaryTreeInsert.insert(5);
        binaryTreeInsert.insert(6);
        binaryTreeInsert.insert(20);

        System.out.println("binaryTreeInsert.findNumber(5) = " + binaryTreeInsert.findNumber(6));
    }
}
