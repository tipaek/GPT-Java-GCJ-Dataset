import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


    //Number of tests
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

    //For each test case
    for (int k = 1; k <= t; ++k) {
      String newString = "";
      int nesting = 0;

      int parToAdd;

      String s = in.next();
      char[] chars = s.toCharArray();

      for (int i = 0; i < chars.length; i++) {
        int p = Integer.parseInt(String.valueOf(chars[i]));

        while (nesting < p) {
          newString += '(';
          nesting++;
        }

        int diff = i+1 >= chars.length ? nesting : chars[i+1] - chars[i];

        if(diff < 0) {
          newString += p;
          for (int j = 0; j < Math.abs(diff); j++) {
            newString += ')';
            nesting--;
          }
        } else {
          newString += p;
        }
      }

      while (nesting > 0) {
        newString += ')';
        nesting--;
      }

      System.out.println("Case #" + k + ": " + newString);
    }
  }
}
