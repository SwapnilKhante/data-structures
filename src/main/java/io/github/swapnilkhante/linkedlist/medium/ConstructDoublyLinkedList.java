package io.github.swapnilkhante.linkedlist.medium;

/**
 * Created by SK on 6/10/2022
 **/
public class ConstructDoublyLinkedList {

  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {

      if(this.head == null){
        this.head = node;
        this.tail = node;
        return;
      }
      insertBefore(this.head, node);
    }

    public void setTail(Node node) {
      if(this.tail == null ){
        this.head = node;
        this.tail = node;
        return;
      }
      insertAfter(this.tail, node);
    }

    // time O(1) | space O(1)
    public void insertBefore(Node node, Node nodeToInsert) {
      if (nodeToInsert == this.head && nodeToInsert == this.tail){
        return;
      }
      remove(nodeToInsert);
      nodeToInsert.prev = node.prev;
      nodeToInsert.next = node;

      if(node.prev == null) {
        this.head = nodeToInsert;
      } else {
        node.prev.next = nodeToInsert;
      }
      node.prev = nodeToInsert;
    }

    // time O(1) | space O(1)
    public void insertAfter(Node node, Node nodeToInsert) {
      if(nodeToInsert == this.head && nodeToInsert ==this.tail ){
        return;
      }
      remove(nodeToInsert);
      nodeToInsert.prev = node;
      nodeToInsert.next = node.next;
      if(node.next == null) {
        this.tail = nodeToInsert;
      } else {
        node.next.prev = nodeToInsert;
      }
      node.next = nodeToInsert;

    }

    // time O(N) | space O(1)
    public void insertAtPosition(int position, Node nodeToInsert) {
      if (position == 1) {
        setHead(nodeToInsert);
        return;
        }

      Node node = this.head;
      int currentPosition = 1;
      while (node.next != null && position != currentPosition ) {
        node = node.next;
        currentPosition++;
      }
      if(node.next != null ){
        insertBefore(node, nodeToInsert);
      } else{
        setTail(node);
      }
    }

    // time O(N) | space O(1)
    public void removeNodesWithValue(int value) {
      Node node = this.head;
      while (node != null) {
          Node nodeToRemove = node;
          node = node.next;
          if( nodeToRemove.value == value){
            remove(nodeToRemove);
          }
      }
    }

    // time O(1) | space O(1)
    public void remove(Node node) {
      if (node == this.tail) this.tail = this.tail.prev;
      if (node == this.head) this.head = this.head.next;
      removeNodeBindings(node);
    }

    // time O(N) | space O(1) => Even if we maintain two pointer one from head and another tail we will travers n/2 nodes ~= n
    public boolean containsNodeWithValue(int value) {
      // Write your code here.
      Node node = this.head;

      while (node != null && node.value == value) {
        node = node.next;
      }
      return node != null;
    }

    public static void removeNodeBindings(Node node) {
      if (node.prev != null) node.prev.next = node.next;
      if (node.next != null) node.next.prev = node.prev;
      node.next = null;
      node.prev = null;
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
