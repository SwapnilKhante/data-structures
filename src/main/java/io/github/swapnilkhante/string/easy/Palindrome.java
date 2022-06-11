package io.github.swapnilkhante.string.easy;

/**
 * Created by SK on 6/11/2022
 **/
public class Palindrome {

  public static void main(String[] args) {

    System.out.println(isPalindrome("ssabass"));

  }

  // time -> O(N) | Space -> O(N)
  public static boolean isPalindrome(String str) {

    StringBuilder sb = new StringBuilder();
    int length = str.length();
    for(int i = length - 1 ; i >=0 ; i--) {
     sb.append(str.charAt(i));
   }
    return str.equals(sb.toString());
  }

  // time O(N) | space - O(1)
  public static boolean isPalindromeOptimal(String str) {

    int leftIdx =0;
    int rightIdx = str.length() - 1;

    while (leftIdx < rightIdx) {
      if(str.charAt(leftIdx) != str.charAt(rightIdx)) {
        return false;
      }
      leftIdx++;
      rightIdx--;
    }
    return true;
  }
}
