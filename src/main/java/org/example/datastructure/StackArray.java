package org.example.datastructure;

public class StackArray {
    private int top;
    private int[] arr;

    public StackArray(int capacity) {
        this.top = -1;
        this.arr = new int[capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return arr.length == size();
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(int data) {
        if (isFull()) throw new ArrayIndexOutOfBoundsException("Stack is full");
        top++;
        arr[top] = data;
    }

    public int pop() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Stack is empty");
        int result = arr[top];
        top--;
        return result;
    }

    public void display() {
        int i = top;
        while (i > -1) {
            System.out.printf("| %s |%n", arr[i]);
            i--;
        }
        System.out.println("'''''");
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(4);
        stack.push(6);
        stack.push(8);
        stack.push(9);
        stack.push(5);
        stack.display();
        System.out.println("stack.pop() = " + stack.pop());
        stack.display();
    }
}
