package io.github.swapnilkhante.arrays.easy;

import java.util.Arrays;

/**
 * Created by SK on 3/21/2022
 **/
public class TwoSums {

  public static void main(String[] args) {
    int target = 11;
    int[] inputArray = new int[]{1, 3, 7, 9, 2};
    System.out.println(Arrays.toString(twoSum(inputArray, target)));
  }


  public static int[] twoSum1(int[] inputArray, int target) {

    for (int i = 0; i < inputArray.length; i++) {
      int num2 = target - inputArray[i];
      for (int j = i + 1; j < inputArray.length; j++) {
        if (inputArray[j] == num2) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

  public static int[] twoSum(int[] inputArray, int target) {

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = i + 1; j < inputArray.length; j++) {
        if (inputArray[i] + inputArray[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

  public static int[] twoSumOptimal(int[] array, int targetSum) {
    Arrays.sort(array);
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      int currentSum = array[left] + array[right];
      if (targetSum == currentSum) {
        return new int[]{array[left], array[right]};
      } else if (currentSum < targetSum) {
        left++;
      } else {
        right--;
      }
    }
    return new int[1];
  }
}

