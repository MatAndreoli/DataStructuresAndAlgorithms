package org.example.datastructure;

import java.util.Objects;

public class SinglyLinkedList {
    private ListNode head;

    public static class ListNode {
        private final int data;
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

    public boolean find(int value) {
        if (head == null) {
            return false;
        }
        ListNode current = head;
        while (current != null) {
            if (current.data == value) return true;
            current = current.nextNode;
        }
        return false;
    }

    public void reverse() {
        if (isHeadNull()) return;
        ListNode current = head;
        ListNode previous = null;
        ListNode next;
        while (current != null) {
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public ListNode findMiddleNode() {
        if (isHeadNull()) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (isCurrentNodeAndNextNotNull(fast)) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }
        return slow;
    }

    public ListNode getNthNodeFromEnd(int n) throws IllegalAccessException {
        if (isHeadNull()) return null;
        if (n <= 0) throw new IllegalAccessException("Invalid value. Must be a positive number");
        ListNode main = head;
        ListNode reference = head;
        int count = 0;
        while (count < n) {
            if (reference == null)
                throw new IllegalAccessException("Given value is greater then SinglyLinkedList length");
            reference = reference.nextNode;
            count++;
        }
        while (reference != null) {
            reference = reference.nextNode;
            main = main.nextNode;
        }
        return main;
    }

    public void removeDuplicates() {
        ListNode current = head;
        while (isCurrentNodeAndNextNotNull(current)) {
            if (current.data == current.nextNode.data) {
                current.nextNode = current.nextNode.nextNode;
            } else current = current.nextNode;
        }
    }

    public void removeKey(int key) {
        if (isHeadNull()) return;
        ListNode current = head;
        ListNode temp = head;
        if (current.data == key) {
            head = current.nextNode;
            return;
        }
        while (current != null && current.data != key) {
            temp = current;
            current = current.nextNode;
        }
        if (current == null) return;
        temp.nextNode = current.nextNode;
    }

    public boolean containsLoop() {
        if (isHeadNull()) return false;

        ListNode fast = head;
        ListNode slow = head;

        while (isCurrentNodeAndNextNotNull(fast)) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
            if (fast == slow) return true;
        }
        return false;
    }

    public ListNode startNodeInALoop() {
        if (isHeadNull()) return null;

        ListNode fast = head;
        ListNode slow = head;

        while (isCurrentNodeAndNextNotNull(fast)) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
            if (fast == slow) return getStartingNode(slow);
        }
        return null;
    }

    private ListNode getStartingNode(ListNode slow) {
        ListNode temp = head;
        while (temp != slow) {
            temp = temp.nextNode;
            slow = slow.nextNode;
        }
        return temp;
    }

    private void removeLoop() {
        if (isHeadNull()) return;

        ListNode fast = head;
        ListNode slow = head;

        while (isCurrentNodeAndNextNotNull(fast)) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
            if (fast == slow) {
                ListNode temp = head;
                while (temp.nextNode != slow.nextNode) {
                    temp = temp.nextNode;
                    slow = slow.nextNode;
                }
                slow.nextNode = null;
                return;
            }
        }
    }

    public static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.data >= b.data) {
                tail.nextNode = b;
                b = b.nextNode;
            } else {
                tail.nextNode = a;
                a = a.nextNode;
            }
            tail = tail.nextNode;
        }
        if (a == null) tail.nextNode = b;
        else tail.nextNode = a;
        return dummy.nextNode;
    }

    public static ListNode sumTwo(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (a != null || b != null) {
            int x = a != null ? a.data : 0;
            int y = b != null ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.nextNode = new ListNode(sum % 10);
            tail = tail.nextNode;
            if (a != null) a = a.nextNode;
            if (b != null) b = b.nextNode;
        }
        if (carry > 0) {
            tail.nextNode = new ListNode(carry);
        }
        return dummy.nextNode;
    }

    private boolean isCurrentNodeAndNextNotNull(ListNode node) {
        return node != null && node.nextNode != null;
    }

    public static void main(String[] args) throws IllegalAccessException {
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
        singlyLinkedList.add(43);
        singlyLinkedList.addValueAt(87, 5);
        singlyLinkedList.display();
        int value = 99;
        System.out.printf("Found %s in singlyLinkedList? %s%n", value, singlyLinkedList.find(value));
        singlyLinkedList.reverse();
        singlyLinkedList.unshift(43);
        singlyLinkedList.addValueAt(23, 3);
        singlyLinkedList.add(10);
        singlyLinkedList.display();
        singlyLinkedList.removeDuplicates();
        singlyLinkedList.display();
        singlyLinkedList.removeKey(43);
        singlyLinkedList.removeKey(87);
        singlyLinkedList.display();
        System.out.println("singlyLinkedList.getNthNodeFromEnd(n) = " + singlyLinkedList.getNthNodeFromEnd(6).data);
        System.out.println("singlyLinkedList.findMiddleNode() = " + singlyLinkedList.findMiddleNode().data);
        System.out.println("singlyLinkedList.length() = " + singlyLinkedList.length());

        System.out.println("========================= Loop SinglyLinkedList =========================");
        SinglyLinkedList loop = new SinglyLinkedList();
        loop.head = new ListNode(1);
        ListNode value2 = new ListNode(2);
        ListNode value3 = new ListNode(3);
        ListNode value4 = new ListNode(4);
        ListNode value5 = new ListNode(5);
        ListNode value6 = new ListNode(6);
        loop.head.nextNode = value2;
        value2.nextNode = value3;
        value3.nextNode = value4;
        value4.nextNode = value5;
        value5.nextNode = value6;
        value6.nextNode = value2;
        /*
        Visual of loop:
        1 --> 2 --> 3
              |     |
              5 <-- 4
         */
        System.out.printf("Found a loop in singlyLinkedList? %s%n", loop.containsLoop());
        System.out.println("loop.startNodeInALoop() = " + loop.startNodeInALoop().data);
        loop.removeLoop();
        loop.display();
        SinglyLinkedList listNode = new SinglyLinkedList();
        loop.reverse();
        listNode.head = SinglyLinkedList.sumTwo(loop.head, loop.head);
        listNode.reverse();
        listNode.display();
        System.out.printf("Found a loop in singlyLinkedList? %s%n", loop.containsLoop());

        SinglyLinkedList merged = new SinglyLinkedList();

        merged.head = SinglyLinkedList.merge(singlyLinkedList.head, loop.head);
        merged.display();
    }
}
