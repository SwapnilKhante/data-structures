package io.github.swapnilkhante.greedyAlgo.easy;

import io.github.swapnilkhante.Utils;

import java.util.Arrays;

/**
 * Created by SK on 7/5/2022
 **/
public class TandemBicycle {

  public static void main(String[] args) {

    int[] redShirtSpeeds = new int[]{5, 5, 3, 9, 2};
    int[] blueShirtSpeeds = new int[]{3, 6, 7, 2, 1};
    boolean fastest = true;
    int expected = 32;
    var actual = tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
    System.out.println(expected == actual);
  }


  // time - O(nlogn)*2 sorting + O(n)traversing ~ O(nlogn)
  // space = O(1)
  public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
    Arrays.sort(redShirtSpeeds);
    Arrays.sort(blueShirtSpeeds);
    int totalSpeed = 0;
    int left = 0;
    int right = fastest ? redShirtSpeeds.length - 1 : 0;
    while (left < redShirtSpeeds.length ) {
      totalSpeed += Math.max(redShirtSpeeds[left], blueShirtSpeeds[Math.abs(right)]);
      left++;
      right--;
    }
    return totalSpeed;
  }
}
