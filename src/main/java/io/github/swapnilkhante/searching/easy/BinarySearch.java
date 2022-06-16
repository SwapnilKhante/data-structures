package io.github.swapnilkhante.searching.easy;

/**
 * Created by SK on 6/14/2022
 **/
public class BinarySearch {

  public static void main(String[] args) {

    int output = binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33);
    System.out.println(output);
  }

  // time O(log(N); space = O(1) -> as size of the input doubles, time complexity increases by 1
  private static int binarySearch(int[] array, int target) {

    int leftPointer = 0;
    int rightPointer = array.length - 1;

    while (leftPointer <= rightPointer ) {
      int mid = Math.abs((rightPointer + leftPointer) / 2);
      int potentialMatch = array[mid];
      if(target == potentialMatch){
        return mid;
      } else if (target < potentialMatch) {
        rightPointer = mid - 1;
      } else {
        leftPointer = mid + 1;
      }
    }
    return -1;
  }
}
