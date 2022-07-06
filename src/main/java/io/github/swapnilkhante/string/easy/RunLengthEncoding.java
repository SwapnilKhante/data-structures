package io.github.swapnilkhante.string.easy;

import io.github.swapnilkhante.Utils;

/**
 * Created by SK on 7/5/2022
 **/
public class RunLengthEncoding {
  public static void main(String[] args) {

    var input = "AAAAAAAAAAAAABBCCCCDD";
    var expected = "9A4A2B4C2D";
    var actual = runLengthEncoding(input);
    System.out.println(expected.equals(actual));

  }

  public static String runLengthEncoding(String string) {
      StringBuilder sb = new StringBuilder();
      char c = string.charAt(0);
      int counter = 1;
      int idx = 1;
      while (idx < string.length()) {
        if (c == (int) string.charAt(idx) && counter < 9) {
          counter++;
          idx++;
        } else {
          sb.append(counter);
          sb.append(c);
          c = string.charAt(idx);
          idx++;
          counter = 1;
        }
      }
      sb.append(counter);
      sb.append(c);
      System.out.println(sb.toString());
      return sb.toString();
  }
}
