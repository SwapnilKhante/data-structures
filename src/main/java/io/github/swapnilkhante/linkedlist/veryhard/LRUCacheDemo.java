package io.github.swapnilkhante.linkedlist.veryhard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SK on 7/8/2022
 **/
public class LRUCacheDemo {

  static class LRUCache {

    Map <String, DoublyLinkedListNode> cache = new HashMap <>();
    int maxSize;
    int currentSize = 0;
    DoublyLinkedList listOfMostRecent = new DoublyLinkedList();

    public LRUCache(int maxSize) {
      this.maxSize = Math.max(maxSize, 1);
    }

    public void insertKeyValuePair(String key, int value) {
      if (!cache.containsKey(key)) {
        if (cache.size() == maxSize) {
          evictLeastRecent();
        } else {
          currentSize++;
        }
        cache.put(key, new DoublyLinkedListNode(key, value));
      } else {
        replaceKey(key, value);
      }
      updateMostRecent(cache.get(key));
    }

    private void updateMostRecent(DoublyLinkedListNode doublyLinkedListNode) {
      listOfMostRecent.setToHead(doublyLinkedListNode);
    }

    private void replaceKey(String key, int value) {
      if (!cache.containsKey(key)) {
        return; // throw exception that key does not exists
      }
      cache.get(key).value = value;
    }

    private void evictLeastRecent() {
      String keyToRemove = listOfMostRecent.tail.key;
      listOfMostRecent.removeTail();
      cache.remove(keyToRemove);
    }

    public LRUResult getValueFromKey(String key) {
      if(!cache.containsKey(key)) {
        return new LRUResult(false, -1);
      }
      // update most recently used as the key was just accessed
      updateMostRecent(cache.get(key));
      return new LRUResult(true, cache.get(key).value);
    }

    public String getMostRecentKey() {
      DoublyLinkedListNode head = listOfMostRecent.head;
      return head !=null ? head.key : "";
    }
  }

  static class DoublyLinkedList {
    DoublyLinkedListNode head = null;
    DoublyLinkedListNode tail = null;

    // head <-> node <-> tail
    public void setToHead(DoublyLinkedListNode node) {
      if (head == node) {
        return;
      } else if (head == null) {
        head = node;
        tail = node;
      } else if (head == tail) {
        tail.prev = node;
        head = node;
        head.next = tail;
      } else {
        // check node to be set is tail
        if (node == tail) {
          removeTail();
        }
        node.removeBindings();
        head.prev = node;
        node.next = head;
        head = node;
      }

    }

    public void removeTail() {
      if (tail == null) {
        return;
      } else if (head == tail) {
        head = null;
        tail = null;
        return;
      } else {
        tail = tail.prev;
        tail.next = null;
      }
    }
  }

  static class DoublyLinkedListNode {
    String key;
    int value;
    DoublyLinkedListNode next = null;
    DoublyLinkedListNode prev = null;

    public DoublyLinkedListNode(String key, int value) {
      this.key = key;
      this.value = value;
    }

    public void removeBindings() {
      if (prev != null) {
        prev.next = next;
      }
      if (next != null) {
        next.prev = prev;
      }
      prev = null;
      next = null;
    }

  }

  static class LRUResult {
    boolean found;
    int value;

    public LRUResult(boolean found, int value) {
      this.found = found;
      this.value = value;
    }
  }
}
