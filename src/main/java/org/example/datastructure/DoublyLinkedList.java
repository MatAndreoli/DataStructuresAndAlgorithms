package org.example.datastructure;

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

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertLast(1);
        doublyLinkedList.insertLast(2);
        doublyLinkedList.insertLast(3);
        doublyLinkedList.displayForward();
        doublyLinkedList.displayBackward();
    }
}
