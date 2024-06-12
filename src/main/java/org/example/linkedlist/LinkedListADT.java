package org.example.linkedlist;

interface ADT {
    boolean isEmpty();

    int countNode();

    void insert(int data);

    void display();

    void remove(int data);

    void addFirst(int data);

    void addLast(int data);

    int removeFirst();

    int removeLast();

    int min();

    int max();

    Node convertArrayToLinkedList(int arr[]);

}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedListADT implements ADT {

    Node head;

    LinkedListADT() {
        head = null;


    }


    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int countNode() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    @Override
    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;


    }

    @Override
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
    }

    @Override
    public void remove(int data) {
        // If List is Empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        // if head contains the required data move it to next node
        if (head.data == data) {   // [ 1 , 2 , 3, 4, 5]
            head = head.next;
        }

        Node current = head; // 4
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }

    }

    @Override
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }


    @Override
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null)
            head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }


    }

    @Override
    public int removeFirst() {
        if (head == null)
            return 0;
        head = head.next;
        return 0;
    }

    @Override
    public int removeLast() {
        Node temp = head;
        if (head == null)
            return 0;
        if (head.next == null) {
            return 0;
        } else {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        return 0;

    }

    @Override
    public int min() {
        Node current = head;
        int min = Integer.MAX_VALUE;
        while (current.next != null) {
            if (current.data < min) {
                min = current.data;
            }

            current = current.next;
        }
        return min;
    }

    @Override
    public int max() {
        Node current = head;
        int max = Integer.MIN_VALUE;
        while (current.next != null) {
            if (current.data > max) {
                max = current.data;
            }

            current = current.next;
        }
        return max;
    }

    @Override
    public Node convertArrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

}

class Main {
    public static void main(String[] args) throws NullPointerException {
        LinkedListADT list = new LinkedListADT();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.removeLast();
        list.display();
    }
}