package io.github.swapnilkhante;

import java.util.List;

/**
 * Created by SK on 6/17/2022
 **/
public class Utils {

  public static boolean compare(List <String> arr1, String[] arr2) {
    if (arr1.size() != arr2.length) {
      return false;
    }
    for (int i = 0; i < arr1.size(); i++) {
      if (!arr1.get(i).equals(arr2[i])) {
        return false;
      }
    }
    return true;
  }
}
