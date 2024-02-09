package org.example.datastructure;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    public static class ListNode {
        private final int data;
        private ListNode nextNode;
        private ListNode previousNode;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) head = newNode;
        else tail.nextNode = newNode;
        newNode.previousNode = tail;
        tail = newNode;
        length++;
    }

    public void displayForward() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.nextNode;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        ListNode current = tail;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.previousNode;
        }
        System.out.println("null");
    }

    public void unshift(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) tail = newNode;
        else head.previousNode = newNode;
        newNode.nextNode = head;
        head = newNode;
        length++;
    }

    public ListNode shift() {
        if (isEmpty()) throw new NoSuchElementException();
        ListNode temp = head;
        if (head == tail) tail = null;
        else head.nextNode.previousNode = null;
        head = head.nextNode;
        temp.nextNode = null;
        length--;
        return temp;
    }

    public ListNode pop() {
        if (isEmpty()) throw new NoSuchElementException();
        ListNode temp = tail;
        if (head == tail) head = null;
        else tail.previousNode.nextNode = null;
        tail = tail.previousNode;
        temp.previousNode = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertLast(1);
        doublyLinkedList.insertLast(2);
        doublyLinkedList.insertLast(3);
        doublyLinkedList.insertLast(6);
        doublyLinkedList.insertLast(8);
        doublyLinkedList.insertLast(9);
        doublyLinkedList.displayForward();
        doublyLinkedList.displayBackward();
        doublyLinkedList.unshift(88);
        doublyLinkedList.displayForward();
        System.out.println("doublyLinkedList.length = " + doublyLinkedList.length);
        System.out.println("doublyLinkedList.shift() = " + doublyLinkedList.shift().data);
        doublyLinkedList.displayForward();
        doublyLinkedList.unshift(4);
        System.out.println("doublyLinkedList.pop() = " + doublyLinkedList.pop().data);
        System.out.println("doublyLinkedList.pop() = " + doublyLinkedList.pop().data);
        doublyLinkedList.displayForward();
        doublyLinkedList.displayBackward();
    }
}
