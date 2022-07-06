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

  // O(N) time | O(1) Space
  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

    LinkedList currentNode = linkedList;
    while (currentNode != null) {
      // 1 -> 3 -> 5 -> 5 -> 7
      LinkedList nextDistinctNode = currentNode.next;
      while (nextDistinctNode!=null && currentNode.value == nextDistinctNode.value) {
        nextDistinctNode = nextDistinctNode.next;
      }
      // this will point the current node to the next distinct
      // node which we have already updated if condition is true in inner while loop
      currentNode.next = nextDistinctNode;

      // now set next distinct node as current node to proceed with rest of the nodes
      currentNode = nextDistinctNode;
    }
    return linkedList;
  }
}
