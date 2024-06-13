package org.example.linkedlist;


public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public int insertAt(int index, int data) {
        if (index == 1) {
            prepend(data);
            return data;
        }
        Node temp = head;
        int counter = 1;
        while (temp.next != null) {
            counter++;
            if (counter == index) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next.prev = newNode;
                temp.next = newNode;
                newNode.prev = temp;
                break;

            }
            temp = temp.next;
        }

        if (temp.next == null) {
            append(data);
            return data;
        }
        return counter;
    }

    public Node convertToArray(int[] arr) {
        head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    int removeAt(int index) {
        if (index == 0) {
            head.next.prev = null;
            head = head.next;
            return index;

        }
        if (index == 1) {
            head.next.prev = null;
            head = head.next;
            return index;
        }

        Node current = head;
        Node prev = null;
        int counter = 0;
        while (current.next != null) {
            counter++;
            if (counter == index) {
                current.prev = null;
                prev.next = current.next;
                current.next = null;
                break;
            }
            prev = current;
            current = current.next;
        }

        return counter;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;

        }
    }

}


class Test {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        list.convertToArray(arr);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        System.out.println( list.removeAt(5));
//        System.out.println(list.insertAt(1, 4444));
        list.print();
    }
}