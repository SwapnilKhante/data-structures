package io.github.swapnilkhante.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by SK on 6/17/2022
 **/
public class Node {

  public String name;
  public List <Node> children = new ArrayList <>();

  public Node(String name) {
    this.name = name;
  }

  public Node addChild(String name) {
    Node node = new Node(name);
    children.add(node);
    return this;
  }


  // Depth first search is recursively called for each and every child
  // since at given point of time we will travers v - vertexes (nodes) + e edges time complexity O(v+e)
  // space complexity O(v) as v have to store V vertexes in the array we are returning
  // Also if we have one gigantic branch, we will use that much space in the call stack
  public List<String> depthFirstSearch(List<String> array) {
    array.add(name);
    for(int i = 0; i< children.size(); i++) {
       children.get(i).depthFirstSearch(array);
    }
    return array;
  }


  // since at given point of time we will travers v - vertexes (nodes) + e edges time complexity O(v+e)
  // space complexity O(v) as v have to store V vertexes in the array we are returning
  // We are also maintaining a queue which does not hold many elements at a given point of time except for the worst case where all the vertexes have the same parent
  // in this case we will be string n-1 elements queue so O(V) will cover it
  public List<String> breadthFirstSearch(List<String> array) {
    Queue<Node> queue = new LinkedList <>();
    queue.add(this);
    while(!queue.isEmpty()) {
      Node current = queue.poll();
      array.add(current.name);
      queue.addAll(current.children);
    }
    return array;
  }
}
