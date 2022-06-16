package io.github.swapnilkhante.sorting.easy;

import java.util.Arrays;

/**
 * Created by SK on 6/15/2022
 **/
public class BubbleSort {

  public static void main(String[] args) {
    int[] input = {8, 5, 2, 9, 5, 6, 3};
    System.out.println(Arrays.toString(bubbleSort(input)));

  }
   // Bubble sort is the simplest sorting algorithm.
   // The algorithm sorts the elements by comparing the adjacent pairs at a time and swapping them if they are in incorrect order
  // time worse case and average case - O(n^2) | best case - O(N) (if array is already sorted) ; space O(1)
  public static int[] bubbleSort(int[] array) {
    // Write your code here.
    if (array.length == 0) return new int[]{};
    boolean isSorted = false;
    // using counter because of each iteration final no of array is always sorted, this will make sure we do not iterate to the already sorted element
    int counter = 0;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < array.length - 1 - counter; i++) {
        if (array[i] > array[i + 1]) {
          int temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          isSorted = false;
        }
      }
      counter++;
    }
    return array;
  }
}
