package io.github.swapnilkhante.string.easy;

import io.github.swapnilkhante.Utils;

import java.util.HashMap;

/**
 * Created by SK on 7/6/2022
 **/
public class NonRepeatingAlphabets {

  public static void main(String[] args) {
    String input = "abcdcaf";
    int expected = 1;
    var actual = firstNonRepeatingCharacter(input);
    System.out.println(expected == actual);
  }

  public static int firstNonRepeatingCharacter(String string) {

    HashMap <Character, Integer> characterCount = new HashMap <>();

    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);
      characterCount.merge(c, 1, Integer::sum);
    }

    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);
      if (characterCount.get(c) == 1) {
        return i;
      }
    }
    return -1;
  }
}
