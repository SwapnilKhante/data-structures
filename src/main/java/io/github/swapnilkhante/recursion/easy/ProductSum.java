package io.github.swapnilkhante.recursion.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SK on 6/11/2022
 **/
public class ProductSum {

  public static void main(String[] args) {
    List <Object> array = new ArrayList <Object>(
            Arrays.asList(
                    5,
                    2,
                    new ArrayList <Object>(Arrays.asList(7, -1)),
                    3,
                    new ArrayList <Object>(
                            Arrays.asList(6, new ArrayList <Object>(Arrays.asList(-13, 8)), 4))));

    System.out.println(productSum(array));
  }


  // O(N) time and O(d) space where d is the depth of the array
  public static int productSum(List <Object> array) {

    return productSumHelper(array, 1);
  }

  public static int productSumHelper(List <Object> array, int multiplier) {

    int product = 0;
    for (Object al : array) {
      if (al instanceof ArrayList) {
        @SuppressWarnings("unchecked")
        ArrayList <Object> array1 = (ArrayList <Object>) al;
        product += productSumHelper(array1, multiplier + 1);
      } else {
        product += (int) al;
      }
    }
    return product * multiplier;
  }
}
