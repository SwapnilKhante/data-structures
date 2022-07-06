package io.github.swapnilkhante.string.easy;

import io.github.swapnilkhante.Utils;

import java.util.HashMap;

/**
 * Created by SK on 7/6/2022
 **/
public class GenerateDocument {

  public static void main(String[] args) {
    String characters = "Bste!hetsi ogEAxpelrt x ";
    String document = "AlgoExpert is the Best!";
    boolean expected = true;
    var actual = generateDocument(characters, document);
    System.out.println(expected == actual);
  }

 // time O(n+m) => n is no of chars and m is size of document
 // space O(c) => c is the no of unique characters
  public static boolean generateDocument(String characters, String document) {

    HashMap <Character, Integer> characterCountMap = new HashMap<>();

    for (int i = 0; i< characters.length(); i++) {
      char c = characters.charAt(i);
      characterCountMap.merge(c, 1, Integer::sum);
    }

    for (int i = 0; i < document.length(); i++) {
      char c = document.charAt(i);
      if(!characterCountMap.containsKey(c) || characterCountMap.get(c) == 0 ){
        return false;
      }
      characterCountMap.merge(c, -1, Integer::sum);
    }
    return true;
  }
}
