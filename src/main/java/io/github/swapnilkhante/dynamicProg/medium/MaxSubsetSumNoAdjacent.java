package io.github.swapnilkhante.dynamicProg.medium;

import io.github.swapnilkhante.Utils;

/**
 * Created by SK on 7/7/2022
 **/
public class MaxSubsetSumNoAdjacent {

  public static void main(String[] args) {
    int[] input = {75, 105, 120, 75, 90, 135};
    System.out.println(maxSubsetSumNoAdjacent(input) == 330);
  }

  // time : O(N) || space O(1)
  public static int maxSubsetSumNoAdjacent(int[] array) {

    if (array.length == 0) {
      return 0;
    } else if(array.length == 1) {
      return array[0];
    }
    int second = array[0]; //75
    int first = Math.max(array[0], array[1]); //105
    int currentSum = 0;
    for (int i = 2; i < array.length; i++) {
      currentSum = Math.max(first, second + array[i]);
      second = first;
      first = currentSum;
    }
    return first;
  }
}
