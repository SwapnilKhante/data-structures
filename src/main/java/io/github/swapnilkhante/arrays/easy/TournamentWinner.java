package io.github.swapnilkhante.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by SK on 6/7/2022
 **/
public class TournamentWinner {

  public static void main(String[] args) {


    ArrayList <ArrayList <String>> competitions = new ArrayList <>();

    ArrayList <String> innerList1 = new ArrayList <>(Arrays.asList("Html", "CSS"));
    ArrayList <String> innerList2 = new ArrayList <>(Arrays.asList("C#", "Python"));
    ArrayList <String> innerList3 = new ArrayList <>(Arrays.asList("Python", "Html"));

    competitions.add(innerList1);
    competitions.add(innerList2);
    competitions.add(innerList3);

    ArrayList <Integer> results = new ArrayList <>(Arrays.asList(0, 0, 1));

    System.out.println(tournamentWinner(competitions, results));

  }
 // O(n) for arraylist interation * O(1) for hashmap insertion - time |  O(k) space of hashmap creation
  public static String tournamentWinner(ArrayList <ArrayList <String>> competitions, ArrayList <Integer> results) {

    HashMap <String, Integer> winners = new HashMap <>();

    String currentBestTeam = "";
    winners.merge(currentBestTeam, 0, Integer::sum);
    for (int i = 0; i < competitions.size(); i++) {
      ArrayList <String> teams = competitions.get(i);
      int result = results.get(i);

      String winningTeam = result == 1 ? teams.get(0) : teams.get(1);

      winners.merge(winningTeam, 1, Integer::sum);

      if (winners.get(currentBestTeam) < winners.get(winningTeam)) {
        currentBestTeam = winningTeam;
      }
    }

    return currentBestTeam;
  }

}
