package io.github.swapnilkhante.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SK on 6/6/2022
 **/
public class ValidateSubsequence {


  public static void main(String[] args) {
    List <Integer> array = new ArrayList <>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
    List <Integer> sequence = new ArrayList <>(Arrays.asList(1, 6, -1, 10));
    System.out.println(isValidSubsequence(array, sequence));
  }

  /**
   * Sample input = [5, 1, 22, 25, 6, -1, 8 ,10]
   * sequence = [1, 6, -1, 10]
   */
  public static boolean isValidSubsequence(List <Integer> array, List <Integer> sequence) {

    int i, j = 0;
    int seqSize = sequence.size();
    int arraySize = array.size();
    int arrayLastFoundIndex = 0;
    int count = 0;
    if (seqSize > arraySize) return false;

    for (i = 0; i < arraySize; i++) {
      Integer current = array.get(i);
      if(sequence.contains(current) && sequence.indexOf(current) >= arrayLastFoundIndex) {
        arrayLastFoundIndex = sequence.indexOf(current);
        count++;
      }
      if(count==seqSize) return true;
    }
    return false;
  }

  public static boolean isValidSubsequenceUsingWhile(List <Integer> array, List <Integer> sequence) {

    int i = 0, j = 0;
    int seqSize = sequence.size();
    int arraySize = array.size();
    if (seqSize > arraySize) return false;

    while (i < seqSize && j < arraySize){
      if (sequence.get(i).equals(array.get(j))) {
        i++;
      }
      j++;
    }
    return i == seqSize;
  }
}
