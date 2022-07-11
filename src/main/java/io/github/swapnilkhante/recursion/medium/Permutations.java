package io.github.swapnilkhante.recursion.medium;

import io.github.swapnilkhante.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SK on 7/6/2022
 * @implSpec All possible permutations of given array
 **/
public class Permutations {

  public static void main(String[] args) {
    List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
    List<List<Integer>> perms = getPermutations(input);
    System.out.println(perms.size() == 6);
  }

  public static List <List <Integer>> getPermutations(List <Integer> array) {
    // Write your code here.
    return new ArrayList <List <Integer>>();
  }
}
