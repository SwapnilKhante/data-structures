package io.github.swapnilkhante.linkedlist.easy;


public class RemoveDuplicates {

  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

    LinkedList currentNode = linkedList;
    while (currentNode != null) {

      LinkedList nextDistinctNode = linkedList.next;
      if(nextDistinctNode!=null && currentNode.value == nextDistinctNode.value) {
        currentNode = nextDistinctNode;
        currentNode.next = nextDistinctNode.next;
      }

    }
    return linkedList;
  }
}
