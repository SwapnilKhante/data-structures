package io.github.swapnilkhante.searching.easy;

/**
 * Created by SK on 6/14/2022
 **/
public class BinarySearchRecursive {
  public static void main(String[] args) {

    int output = binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33);
    System.out.println(output);
  }

  // time O(log(N); space = O(log(N)
  private static int binarySearch(int[] array, int target) {

    int leftPointer = 0;
    int rightPointer = array.length - 1;

    return binarySearchRec(array, target, leftPointer, rightPointer);


  }

  private static int binarySearchRec(int[] array, int target, int leftPointer, int rightPointer) {
    if (leftPointer > rightPointer) {
      return -1;
    }
    int mid = (rightPointer + leftPointer) / 2;
    int potentialMatch = array[mid];
    if (target == potentialMatch) {
      return mid;
    } else if (target < potentialMatch) {
      return binarySearchRec(array, target, leftPointer, mid - 1);
    } else {
      return binarySearchRec(array, target, mid + 1, rightPointer);
    }
  }

}
