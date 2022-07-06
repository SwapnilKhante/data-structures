package io.github.swapnilkhante.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SK on 7/6/2022
 **/
public class MoveElementToEnd {

  public static void main(String[] args) {
    List <Integer> array = new ArrayList <Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
    int toMove = 2;
    List <Integer> expectedStart = new ArrayList <Integer>(Arrays.asList(1, 3, 4));
    List <Integer> expectedEnd = new ArrayList <Integer>(Arrays.asList(2, 2, 2, 2, 2));
    List <Integer> output = moveElementToEnd(array, toMove);
  }

  // time O(N) || space O(1)
  public static List <Integer> moveElementToEnd(List <Integer> array, int toMove) {
    int right = array.size() - 1;
    int left = 0;
    while (left < right) {
      if (array.get(right) == toMove) {
        right--;
      } else if (array.get(left) == toMove) {
        int element = array.get(right);
        array.set(left, element);
        array.set(right, toMove);
        left++;
        right--;
      } else {
        left++;
      }
    }
    return array;
  }
}
