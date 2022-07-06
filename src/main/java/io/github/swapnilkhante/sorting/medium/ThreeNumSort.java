package io.github.swapnilkhante.sorting.medium;

import java.util.Arrays;

/**
 * Created by SK on 6/15/2022
 **/
public class ThreeNumSort {
  public static void main(String[] args) {
    var array = new int[]{1, 0, 0, -1, -1, 0, 1, 1};
    var order = new int[]{0, 1, -1};
    System.out.println(Arrays.toString(threeNumberSort(array, order)));
  }

  private static int[] threeNumberSort(int[] array, int[] order) {
    int firstValue = order[0];
    int thirdValue = order[2];

    int firstIdx = 0;
    for (int i = 0; i < array.length; i++) {
          if(array[i] == firstValue) {
            swap(firstIdx , i, array);
            firstIdx +=1;
        }
    }

    int thirdIndex = array.length - 1;
//    for(int i = array.length - 1; i >=0; i--){
//      if(array[i] == thirdValue) {
//        swap(thirdIndex, i, array);
//        thirdIndex -=1;
//      }
//    }
    return array;


  }

  private static void swap(int x, int y, int[] array) { // 3 , 4

    int temp = array[y];
    array[y] = array[x];
    array[x] = temp;
  }
}

