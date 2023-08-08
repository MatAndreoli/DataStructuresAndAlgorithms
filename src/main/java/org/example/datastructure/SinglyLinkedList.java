package org.example.datastructure;

import java.util.Objects;

public class SinglyLinkedList {
    private ListNode head;

    public static class ListNode {
        private int data;
        private ListNode nextNode;

        public ListNode(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    private boolean isHeadNull() {
        return Objects.isNull(head);
    }

    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.nextNode;
        }
        System.out.println("null");
    }

    public int length() {
        if (isHeadNull()) return 0;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.nextNode;
        }
        return count;
    }

    public void unshift(int data) {
        ListNode newNode = new ListNode(data);
        newNode.nextNode = head;
        head = newNode;
    }

    public void add(int data) {
        ListNode newNode = new ListNode(data);
        if (isHeadNull()) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.nextNode != null) {
            current = current.nextNode;
        }
        current.nextNode = newNode;
    }

    public void addValueAt(int data, int position) {
        ListNode newNode = new ListNode(data);
        if (position == 1) {
            newNode.nextNode = head;
            head = newNode;
        } else {
            ListNode previousNode = head;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.nextNode;
                count++;
            }
            newNode.nextNode = previousNode.nextNode;
            previousNode.nextNode = newNode;
        }
    }

    public void shift() {
        if (head != null) {
            ListNode temp = head;
            head = head.nextNode;
            temp.nextNode = null;
        }
    }

    public void pop() {
        if (isHeadNull() || head.nextNode == null) return;
        ListNode current = head;
        while (current.nextNode.nextNode != null) {
            current = current.nextNode;
        }
        current.nextNode = null;
    }

    public void deleteAt(int position) {
        if (position == 1) {
            this.shift();
            return;
        }
        ListNode current = head;
        int count = 1;
        while (count < position - 1) {
            current = current.nextNode;
            count++;
        }
        ListNode temp = current.nextNode;
        current.nextNode = temp.nextNode;
    }

    public static void main(String[] args) {
        System.out.println("SinglyLinkedList");
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        ListNode fifth = new ListNode(4);

        singlyLinkedList.head.nextNode = second;    //! 10 --> 1
        second.nextNode = third;                    //! 10 --> 1 --> 8
        third.nextNode = fourth;                    //! 10 --> 1 --> 8 --> 11
        fourth.nextNode = fifth;                    //! 10 --> 1 --> 8 --> 11 --> 4

        System.out.println("========================= singlyLinkedList =========================");
        singlyLinkedList.display();
        System.out.println("singlyLinkedList.length() = " + singlyLinkedList.length());
        singlyLinkedList.unshift(2);
        singlyLinkedList.display();
        singlyLinkedList.addValueAt(99, 2);
        singlyLinkedList.display();
        singlyLinkedList.pop();
        singlyLinkedList.display();
        singlyLinkedList.shift();
        singlyLinkedList.display();
        singlyLinkedList.add(77);
        singlyLinkedList.add(23);
        singlyLinkedList.display();
        singlyLinkedList.deleteAt(3);
        singlyLinkedList.display();
        System.out.println("singlyLinkedList.length() = " + singlyLinkedList.length());
    }
}
