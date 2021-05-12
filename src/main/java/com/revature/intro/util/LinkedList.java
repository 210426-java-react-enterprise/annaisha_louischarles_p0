package com.revature.intro.util;
//sim to a queue like addition(on top) and removal(off end)

import com.revature.intro.util.List;

public class LinkedList<T> implements List<T>, Queue<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;
    private int index;
    /**
     * This does not accept null.
     * @param data
     * @throws IllegalArgumentException
     */


    @Override
    public void add(T data) throws IllegalArgumentException {

        if (data == null) {

            throw new IllegalArgumentException("This linked list does not accept null values");
        }

        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.prevNode = tail;
        }
        tail = newNode; //also can write head = tail = newNode; sets both to new node.

        size++;
    } //if tail = null when list empty, if one thing in the list the head = tail are the same object, &if more than one thing

    @Override
    public T remove(T data) {
        return null;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("The provided index is out of bounds!");
        }

        Node<T> nodeRun = head;
        for (int i = 0; i <= size; i++) {
            if (i == index) {
                return nodeRun.data;
            }

            nodeRun = nodeRun.nextNode;
        }
        return null;
    }
    //in the list then head = !null node and tail != null node but tail.nextnode == null (always null).

    /**
     * returns the head node's data or else returns null
     * @return
     */

    @Override
    public T poll() { //proper name for a List removal, pop would be for a Queue

        if(head == null) {
            return null;
        }

        T soughtOutData = head.data;
        head = head.nextNode;

        if (head != null) {
            head.prevNode = null;
        } //if it was cyclical we would have tail point to head, instead of implicitly null.

        size--;

        return soughtOutData;

    }

    public T peek(){
        return null;
    };

    @Override
    public boolean contains(T data) {
        return false;
    }

    @Override
    public int size(){
        return size;
    }


    private static class Node<T> { //doubly LinkedList only visible to LinkedList. Any other class will do operations through LinkedList.
        T data;
        Node<T> nextNode;
        Node<T> prevNode;

        public Node(T data) { //might be first node we use.
            this.data = data;
        }

        public Node(T data, Node<T> nextNode, Node<T> prevNode) {
            this.data = data;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }
    }
}

