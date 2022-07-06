package io.github.swapnilkhante.arrays.medium;

import java.util.Arrays;

/**
 * Created by SK on 6/20/2022
 **/
public class SmallestDifference {

    public static void main(String[] args) {
        smallestDifference(
                new int[] {-1, 5, 10, 20, 28, 3}, new int[] {26, 134, 135, 15, 17});
    }

    // time -> O(Nlog(N) + Mlog(M)) : as we are sorting the array first and iterating just once additional O(N) won't make the difference
    // space -> O(1)
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int smallestDiff = Integer.MAX_VALUE;
        int idx1 = 0;
        int idx2 = 0;
        int currentDiff = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];

        while(idx1 < arrayOne.length && idx2 < arrayTwo.length) {
            int firstNum = arrayOne[idx1];
            int secondNum = arrayTwo[idx2];
            if (firstNum > secondNum) {
                currentDiff = firstNum - secondNum;
                idx2++;
            } else if (firstNum < secondNum) {
                currentDiff = secondNum - firstNum;
                idx1++;
            } else {
                return new int[]{firstNum, secondNum};
            }
            if (currentDiff < smallestDiff) {
                smallestDiff = currentDiff;
                smallestPair = new int[]{firstNum, secondNum};
            }
        }
        return smallestPair;
    }
}
