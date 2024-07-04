import java.util.*;
import java.io.*;

public class Solution {


  public static boolean isValidMatch(String s1, String s2){
    int n = s1.length()-1;
    int m = s2.length()-1;

    // scan from right -> left
    while (n > -1 && m > -1) {
      if (s1.charAt(n) == '*' || s2.charAt(m) == '*') {
        break;
      }
      if (s1.charAt(n) != s2.charAt(m)) {
        return false;
      }
      n--;
      m--;
    }

    // scan from left -> right
    n = 0;
    m = 0;
    while (n < s1.length() && m < s2.length()) {
      if (s1.charAt(n) == '*' || s2.charAt(m) == '*') {
        break;
      }
      if (s1.charAt(n) != s2.charAt(m)) {
        return false;
      }
      n++;
      m++;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) { // number of test cases
      int n = in.nextInt();
      String longest = in.next();
      boolean isValid = true;
      for (int k = 1; k < n; k++) { // number of patterns in testcase
        String curr = in.next();
        if (isValid == false) { continue; }
        if (!isValidMatch(longest, curr)) {
          System.out.println(String.format("Case %d: *", i));
          isValid = false;
        }

        if (curr.length() > longest.length()) {
          longest = curr;
        }
      }

      // output for valid match
      if (isValid) {
        int starIndex = longest.indexOf('*');
        String result = longest.substring(0,starIndex) + longest.substring(starIndex+1);
        System.out.println(String.format("Case %d: %s", i, result));
      }
    }
  }
}

/**
 * Test Case 1: The asteriks are only at the start
 * Start from the leftmost character of every input example; 
 * psuedo make all the characters the same length; when we've reached the end of the last word; then
 * we know that all the words are the save
 */