package io.github.swapnilkhante.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SK on 6/20/2022
 **/
public class ThreeNumSum {

  public static void main(String[] args) {
    List<Integer[]> expected = new ArrayList<Integer[]>();
    expected.add(new Integer[] {-8, 2, 6});
    expected.add(new Integer[] {-8, 3, 5});
    expected.add(new Integer[] {-6, 1, 5});
    List<Integer[]> output = threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
    output.forEach(array -> System.out.println(array.toString()));
    System.out.println(output);
  }


  // time O(N^2) -> iterating input array twice from
  // space O(n) -> creating array of n size
  public static List <Integer[]> threeNumberSum(int[] array, int targetSum) {


    Arrays.sort(array);
    ArrayList <Integer[]> threeSums = new ArrayList <>();

    for (int idx = 0; idx < array.length - 2; idx++) {
      int left = idx+1;
      int right = array.length - 1;
      while (left < right) {
        int currentSum = array[idx] + array[left] + array[right];
        if (currentSum == targetSum) {
          threeSums.add(new Integer[]{array[idx], array[left], array[right]});
          left++;
          right--;
        } else if (targetSum > currentSum) {
          left++;
        } else{
          right--;
        }
      }
    }
    return threeSums;
  }
}
