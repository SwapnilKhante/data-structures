package io.github.swapnilkhante.arrays.easy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by SK on 6/20/2022
 **/
public class HourGlass {

  public static int hourglassSum(List <List <Integer>> array) {
    int columnSize = array.size();
    int rowSize = array.get(0).size();
//
//    if (rowSize < 2 || columnSize < 2) {
//      System.out.println("Not possible to calculate hourglass sum");
//      System.exit(0);
//    }

    // [ [1,2],  [3, 4] [] [] [] ]
    int maxSum = 0;
    int sum = 0;
    int startIdx = 0;
    for (int i = startIdx; i < array.size(); i++) {
      List <Integer> rows = array.get(i);
      for (int j = i; j < i + 3; j++) {
         if(i%2 == 1) {
           sum+= rows.get(j+1);
         } else{
           sum+= rows.get(j);
         }
      }
      startIdx++;
      System.out.println(sum);
    }
    return 0;

  }

  public static void main(String[] args) throws IOException {


    List dArrayList = create2DArrayList();
//    System.out.println(dArrayList);

    int result = hourglassSum(dArrayList);
    System.out.println(result);

  }

  static List create2DArrayList() {

    // Creating a 2D ArrayList of Integer type
    ArrayList <ArrayList <Integer>> x = new ArrayList <ArrayList <Integer>>();

    x.add(new ArrayList <>(Arrays.asList(1,1,1,0,0,0)));
    x.add(new ArrayList <>(Arrays.asList(0,1,0,0,0,0)));
    x.add(new ArrayList <>(Arrays.asList(1,1,1,0,0,0)));
    x.add(new ArrayList <>(Arrays.asList(0,0,2,4,4,0)));
    x.add(new ArrayList <>(Arrays.asList(0,0,0,2,0,0)));
    x.add(new ArrayList <>(Arrays.asList(0,0,1,2,4,0)));
    return x;
  }
}


