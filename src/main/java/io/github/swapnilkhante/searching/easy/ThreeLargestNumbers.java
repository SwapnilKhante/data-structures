package io.github.swapnilkhante.searching.easy;

/**
 * Created by SK on 6/14/2022
 **/
public class ThreeLargestNumbers {

    public static void main(String[] args) {
//        int[] threeLargest = indThreeLargestNumbers(new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7});
        int[] threeLargest = indThreeLargestNumbers(new int[] {-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7});
        for (int i : threeLargest) {
            System.out.println(i);
        }
    }

    // time O(N) ; Space O(1)
    private static int[] indThreeLargestNumbers(int[] array) {
        int firstLargest, secondLargest, thirdLargest = 0;
        firstLargest = secondLargest = thirdLargest = Integer.MIN_VALUE;
        for ( int num : array ){
           if (num > firstLargest) {
               thirdLargest = secondLargest; // 18
               secondLargest = firstLargest; // 141
               firstLargest = num; //541
            } else if(num > secondLargest) {
               thirdLargest = secondLargest; //17
               secondLargest =num; //18
           } else if (num > thirdLargest) {
               thirdLargest = num; // 0
           }
        }
        return new int[]{thirdLargest, secondLargest, firstLargest};
    }
}
