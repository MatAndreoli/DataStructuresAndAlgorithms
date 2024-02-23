package org.example.datastructure;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Queue<T> {
    private ListNode front;
    private ListNode rear;
    private int length;

    public class ListNode {
        private final T data;
        private ListNode nextNode;

        public ListNode(T data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(T data) {
        ListNode temp = new ListNode(data);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.nextNode = temp;
        }
        rear = temp;
        length++;
    }

    public T dequeue() {
        if (isEmpty()) throw new EmptyStackException();
        T data = front.data;
        front = front.nextNode;
        if (front == null) {
            rear = null;
        }
        length--;
        return data;
    }

    public void print() {
        if (isEmpty()) return;

        ListNode current = front;
        while (current != null) {
            System.out.printf(" %s ==>", current.data);
            current = current.nextNode;
        }

        System.out.println(" null");
    }

    public static String[] generateBinaryNumbers(int n) {
        String[] result = new String[n];
        Queue<String> q = new Queue<>();
        q.enqueue("1");
        int i = 0;
        while (i < n) {
            result[i] = q.dequeue();
            q.enqueue(result[i] + "0");
            q.enqueue(result[i] + "1");
            i++;
        }

        return result;
    }

    public static String[] generateHexNumbers(int n) {
        String[] result = new String[n];
        Queue<String> q = new Queue<>();
        int i = 0;
        while (i < n) {
            String temp;
            if (i >= 1) {
                temp = q.dequeue();
                result[i] = temp;
                q.enqueue(temp + "0");
            } else {
                temp = "0";
                result[i] = temp;
                temp = "";
            }
            for (char c = '1'; c <= '9'; c++) {
                q.enqueue(temp + c);
            }
            for (char c = 'A'; c <= 'F'; c++) {
                q.enqueue(temp + c);
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(5);
        queue.enqueue(58);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.print();
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.dequeue() = " + queue.dequeue());
        queue.print();

        System.out.println("Queue.generateBinaryNumbers(6) = " + Arrays.toString(Queue.generateBinaryNumbers(1000)));
        System.out.println("Queue.generateHexNumbers(100) = " + Arrays.toString(Queue.generateHexNumbers(56)));
    }
}
