package io.github.swapnilkhante.recursion.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SK on 6/10/2022
 **/
public class NthFibonacci {


  public static void main(String[] args) {
    System.out.println(getNthFib(5));
  }

  //time - O(2^n) | space - O(N)
  public static int getNthFib(int n) {
    // Write your code here.

    if (n == 1) {
      return 0;
    } else if (n == 2) {
      return 1;
    } else {
      return getNthFib(n - 1) + getNthFib(n - 2);
    }
  }


  //time - O(n) | space - O(N)
  public static int getNthFibUsingMap(int n) {

    Map <Integer, Integer> fibMap = new HashMap <>();
    fibMap.put(1, 0);
    fibMap.put(2, 1);
    return getNthFib(n, fibMap);
  }

  private static int getNthFib(int n, Map <Integer, Integer> fibMap) {
    if (fibMap.containsKey(n)) {
      return fibMap.get(n);
    } else {
      fibMap.put(n, getNthFib(n - 1, fibMap) + getNthFib(n - 2, fibMap));
      return fibMap.get(n);
    }
  }

  // using an iterative approach
  //time - O(n) | space - O(N)
  public static int getNthFibIterative(int n) {

    int[] fibArray = new int[]{0, 1};
    int counter = 3;
    while (counter <= n) {
      int nextFeb = fibArray[0] + fibArray[1];
      fibArray[0] = fibArray[1];
      fibArray[1] = nextFeb;
      counter++;
    }
    return n > 1 ? fibArray[1] : fibArray[0];
  }
}



























