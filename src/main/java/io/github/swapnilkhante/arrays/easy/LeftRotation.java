package io.github.swapnilkhante.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SK on 6/20/2022
 **/
public class LeftRotation {

  public static void main(String[] args) {

    ArrayList <Integer> integers = new ArrayList <>(Arrays.asList(1, 2, 3, 4, 5)); // 5 1 2 3 4
    System.out.println(rotLeft(integers, 4));

  }
  public static List <Integer> rotLeft(List<Integer> array, int d) {

    int startIdx = 0;
    int endIdx = array.size() - 1;

    for(int i= 0; i<4; i++) {
      int shiftIndex = getShiftIndex(array, i);
      System.out.println(shiftIndex);
      Integer temp = array.get(shiftIndex);
      array.set(shiftIndex, array.get(i));
      array.set(i, temp);
    }
    return array;
  }

  private static int getShiftIndex(List <Integer> array, int index) { // 3
//    System.out.println(array.size());
    if(index - 1 >= 0) {
      return index -1;
    } else {
//      (index - 1 + array.size()) % ar
    }
    return Math.abs(index - 1) % array.size();
  }

}
