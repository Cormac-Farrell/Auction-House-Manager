package com.example.auctionhouse;

public class LinkedList <L>{
    public Node<L> head = null;


    public void addElement(L e) { //Add element to head of list
        Node<L> fn = new Node<>();
        fn.setContents(e);
        fn.next = head;
        head = fn;
    }

    class Node<N> {

        public Node<N> next = null;
        private N contents; //ADT reference!

        public N getContents() {
            return contents;
        }

        public void setContents(N c) {
            contents = c;
        }

        public void clear() {
            head=null;
        }

    }





}
