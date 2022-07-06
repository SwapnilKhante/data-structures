package io.github.swapnilkhante.sorting.hard;

import java.util.Arrays;

/**
 * Created by SK on 6/16/2022
 **/
public class QuickSort {

  public static void main(String[] args) {
    int[] input = {8, 5, 2, 9, 5, 6, 3};
    System.out.println(Arrays.toString(quickSort(input)));
  }

  public static int[] quickSort(int[] array) {
    // Write your code here.
    quickSortHelper(array, 0, array.length - 1);
    return array;
  }

  private static void quickSortHelper(int[] array, int startIdx, int endIdx) {
    if (startIdx >= endIdx) {
      return;
    }
    int pivotIdx = startIdx;
    int leftIdx = startIdx + 1;
    int rightIdx = endIdx;

    while (rightIdx >= leftIdx) {
      if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
        swap(leftIdx, rightIdx, array);
      }
      if (array[leftIdx] <= array[pivotIdx]) {
        leftIdx++;
      }
      if(array[rightIdx] >= array[pivotIdx]) {
        rightIdx--;
      }
    }
    swap(pivotIdx, rightIdx, array);
    boolean isLeftSortArraySmaller = rightIdx - startIdx - 1 < endIdx - (rightIdx + 1);
    if (isLeftSortArraySmaller) {
      quickSortHelper(array, startIdx, rightIdx -1);
      quickSortHelper(array, rightIdx+1, endIdx);
    } else {
      quickSortHelper(array, rightIdx+1, endIdx);
      quickSortHelper(array, startIdx, rightIdx -1);
    }
  }

  private static void swap(int x, int y, int[] array) { // 3 , 4

    int temp = array[y];
    array[y] = array[x];
    array[x] = temp;
  }

}
