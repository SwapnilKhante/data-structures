package io.github.swapnilkhante.sorting.easy;

import java.util.Arrays;

/**
 * Created by SK on 6/15/2022
 **/
public class SelectionSort {
  public static void main(String[] args) {
    int[] input = {8, 5, 2, 9, 5, 6, 3};
    System.out.println(Arrays.toString(selectionSort(input)));
  }

  /**
   * This sorting algorithm is an in-place comparison-based algorithm in which the list is divided into two parts,
   * the sorted part at the left end and the unsorted part at the right end. Initially, the sorted part is empty and the unsorted part is the entire list.
   */
  // find the smallest element in each iteration and append it to the beginning of the list (which is a sorted sublist)
  public static int[] selectionSort(int[] array) {
    int startIdx = 0;
    while (startIdx < array.length - 1) {
      int smallestIdx = startIdx;
      for (int i = startIdx + 1; i < array.length; i++) {
        if (array[smallestIdx] > array[i] ) {
          smallestIdx = i;
        }
      }
      swap(startIdx, smallestIdx, array);
      startIdx++;

    }
    return array;
  }

  private static void swap(int x, int y, int[] array) { // 3 , 4

    int temp = array[y];
    array[y] = array[x];
    array[x] = temp;
  }

}
