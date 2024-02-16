package org.example.datastructure;

import java.time.Duration;
import java.time.Instant;
import java.util.EmptyStackException;

public class Stack {
    private ListNode top;
    private int length;

    public Stack() {
        this.top = null;
        this.length = 0;
    }

    public static class ListNode {
        private final int data;
        private ListNode nextNode;

        public ListNode(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.nextNode = top;
        top = temp;
        length++;
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        int result = top.data;
        top = top.nextNode;
        length--;
        return result;
    }

    public void display() {
        ListNode temp = top;
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return;
        }
        while (temp != null) {
            System.out.printf("| %s |%n", temp.data);
            temp = temp.nextNode;
        }
        System.out.println("'''''");
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(4);
        stack.push(6);
        stack.push(8);
        stack.push(9);
        stack.display();
        System.out.println("stack.pop() = " + stack.pop());
        stack.display();
    }
}
