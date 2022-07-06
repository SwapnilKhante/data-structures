package io.github.swapnilkhante.graph.medium;

import io.github.swapnilkhante.graph.Node;

import java.util.ArrayList;
import java.util.List;

import static io.github.swapnilkhante.Utils.compare;

/**
 * Created by SK on 6/17/2022
 **/
public class BreadthFirstSearch {

  public static void main(String[] args) {
    Node graph = new Node("A");
    graph.addChild("B").addChild("C").addChild("D");
    graph.children.get(0).addChild("E").addChild("F");
    graph.children.get(2).addChild("G").addChild("H");
    graph.children.get(0).children.get(1).addChild("I").addChild("J");
    graph.children.get(2).children.get(0).addChild("K");
    String[] expected = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
    List <String> inputArray = new ArrayList <>();
    System.out.println((compare(graph.breadthFirstSearch(inputArray), expected)));
  }

}
