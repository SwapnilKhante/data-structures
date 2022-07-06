package io.github.swapnilkhante.linkedlist.medium;

/**
 * Created by SK on 7/6/2022
 **/
public class SumOfLinkedList {

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    // Time => O(max(m, n)) => max of two linked list which is the size of the loop
    // Space => O(max(m, n) + 1) ~ O(max(m, n)) ; max of both linked list plus 1 if there is a cary forward
    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList head = new LinkedList(0);
        LinkedList current = head;
        int sum = 0;
        int carry = 0;
        LinkedList firstNode = linkedListOne;
        LinkedList secondNode = linkedListTwo;

        // carry != 0 is required as it is possible we reach end of both linked list and still has carry forward value
        while(firstNode !=null || secondNode !=null || carry != 0) {
            int firstValue = firstNode != null ? firstNode.value : 0;
            int secondValue = secondNode != null ? secondNode.value : 0;
            int newValue = carry + firstValue + secondValue;
            sum = newValue % 10;
            carry = newValue / 10;
            LinkedList newNode = new LinkedList(sum);
            current.next = newNode;
            current = current.next;

            firstNode = firstNode != null ? firstNode.next: null;
            secondNode = secondNode != null ? secondNode.next : null;
        }
        return head.next;
    }
}
