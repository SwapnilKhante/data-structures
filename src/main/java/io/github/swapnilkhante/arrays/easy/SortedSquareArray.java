package io.github.swapnilkhante.arrays.easy;

/**
 * Created by SK on 6/6/2022
 **/
public class SortedSquareArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2,3, 5, 6, 8, 9};
        System.out.println(sortedSquaredArray(array));
    }

    // O(n) time and O(n) space
    public static int[] sortedSquaredArray(int[] array) {
        // Write your code here.

        int[] sortedSquareArray = new int[array.length];
        int smallerValueIdx = 0;
        int largeValueIdx = array.length - 1;

        for(int i = array.length - 1; i >= 0; i--) {
            int smallerValue = array[smallerValueIdx];
            int largeValue = array[largeValueIdx];

            if(Math.abs(smallerValue) > Math.abs(largeValue)) {
                sortedSquareArray[i] = smallerValue * smallerValue;
                smallerValueIdx ++;
            } else {
                sortedSquareArray[i] = largeValue * largeValue;
                largeValueIdx --;
            }
        }
        return sortedSquareArray;
    }
}
