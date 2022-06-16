package io.github.swapnilkhante.sorting.easy;

import java.util.Arrays;

/**
 * Created by SK on 6/15/2022
 **/
public class InsertionSort {

  public static void main(String[] args) {
    int[] input = {8, 5, 2, 9, 5, 6, 3};
    System.out.println(Arrays.toString(insertionSort(input)));
  }

  // Insertion sort algorithm sorts the dataset by transferring one element at a time to the partially sorted array.
  // Thus, this sorting algorithm has a low overhead.
  // time worse case and average case - O(n^2) | best case - O(N) (if array is already sorted) ; space O(1)
  public static int[] insertionSort(int[] array) {

    for(int i=0; i < array.length; i++) {
      int j = i;
      while(j > 0 && array[j] < array[j -1 ]) {
        swap(j, j-1, array);
        j--;
      }
    }
    // Write your code here.
    return array;
  }

  private static void swap(int x, int y, int[] array) {
    array[y] = array[y] + array[x];
    array[x] = array[y] - array[x];
    array[y] = array[y] - array[x];
  }

  // x = 5, y  = 3
  // y = x + y = 8
  // x = y - x = 3
  // y = y - x = 5
}
