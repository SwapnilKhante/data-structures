package io.github.swapnilkhante.linkedlist.medium;

/**
 * Created by SK on 7/6/2022
 **/
public class RemoveKthNodeFromEnd {

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }


  // time O(N) | space O(1)
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    LinkedList second = head;
    LinkedList first = head;
    int counter = 1;
    while (counter <= k) {
      second = second.next;
      counter++;
    }

    // if we already reach the end means head is the node to remove
    if (second == null) {
      head.value = head.next.value;
      head.next = head.next.next;
      return;
    }

    // 3 -> 4 -> 5
    while (second.next != null) {
      first = first.next;
      second = second.next;
    }
    first.next = first.next.next;
  }


}
