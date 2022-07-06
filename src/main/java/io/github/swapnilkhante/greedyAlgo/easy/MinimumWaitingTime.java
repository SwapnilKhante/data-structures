package io.github.swapnilkhante.greedyAlgo.easy;

import io.github.swapnilkhante.Utils;

import java.util.Arrays;

/**
 * Created by SK on 7/5/2022
 **/
public class MinimumWaitingTime {

    public static void main(String[] args) {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int expected = 17;
        var actual = minimumWaitingTime(queries);
        System.out.println(actual);
        System.out.println(actual == expected);
    }

    // time - O(nlogn) sorting + O(n)traversing ~ O(nlogn)
    // space = O(1)
    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries); //{1, 2, 2, 3, 6} //1  // 3  // 5 // 8
        int totalWaitingTime = 0;
        for(int i = 1; i< queries.length ; i++) {
            int currentTime = queries[i - 1];

            // every query has to wait for all its previous queries
            // in first iteration query wait time is 1
            // then all the next queries has to wait the same time hence multiplu by remaining queries
            int totalLeftQueries = queries.length - i;
            totalWaitingTime += currentTime * totalLeftQueries;
        }
        return totalWaitingTime;
    }
}
