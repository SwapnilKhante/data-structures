package io.github.swapnilkhante.arrays.easy;

import java.util.Arrays;

/**
 * Created by SK on 6/7/2022
 **/
public class NonConstructibleChange {

  public static void main(String[] args) {

    int[] coins = new int[]{5, 7, 1, 1, 2, 3, 22};

    System.out.println(nonConstructibleChange(coins));
  }

  // time -> O(nlogn) + n : since n is less than nlogn final time complexity is O(nlogn)
  // space -> O(1) : Input array sorted in place, if not space would O(n) as we need to sorted array
  public static int nonConstructibleChange(int[] coins) {

    int currentChangeCreated = 0;
    Arrays.sort(coins); //

    for (int coin : coins) {
      if (coin > currentChangeCreated + 1) {

        return currentChangeCreated + 1;
      }
      currentChangeCreated += coin;
    }
    return currentChangeCreated + 1;
  }
}
