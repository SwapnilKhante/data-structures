package io.github.swapnilkhante.string.easy;

/**
 * Created by SK on 7/5/2022
 **/
public class CaesarCipherEncryptor {

  public static void main(String[] args) {
    System.out.println(caesarCypherEncryptor("xyz", 2).equals("zab"));
  }
  // time -> O(N) | Space -> O(N)
  public static String caesarCypherEncryptor(String str, int key) {

    char[] newLetters = new char[str.length()];
    int finalKey = key % 26;
    for (int i = 0; i < str.length(); i++) {
      int letter = str.charAt(i) + finalKey;
      int newLetter = letter > 122 ? (96 + (letter%122) ) : letter;
      newLetters[i] = (char) newLetter;
    }
    return new String(newLetters);
  }

}
