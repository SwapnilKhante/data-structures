package io.github.swapnilkhante.greedyAlgo.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by SK on 7/5/2022
 **/
public class ClassPhotos {

  public static void main(String[] args) {
    ArrayList <Integer> redShirtHeights = new ArrayList <Integer>(Arrays.asList(5, 8, 1, 3, 4));
    ArrayList <Integer> blueShirtHeights = new ArrayList <Integer>(Arrays.asList(6, 9, 2, 4, 5));
    boolean expected = true;
    boolean actual = classPhotos(redShirtHeights, blueShirtHeights);
    System.out.println(actual);
    System.out.println(expected == actual);
  }


  // time - O(nlogn)*2 sorting + O(n)traversing ~ O(nlogn)
  // space = O(1)
  public static boolean classPhotos(ArrayList <Integer> redShirtHeights, ArrayList <Integer> blueShirtHeights) {
    Collections.sort(redShirtHeights);
    Collections.sort(blueShirtHeights);
    boolean firstRowColor = redShirtHeights.get(0) > blueShirtHeights.get(0);
    for (int i = 0; i < redShirtHeights.size(); i++) {
      if (firstRowColor) {
        if (redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
          return false;
        }
      } else if (redShirtHeights.get(i) >= blueShirtHeights.get(i)) {
        return false;
      }
    }
    return true;
  }
}
