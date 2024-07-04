import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      // read in the strings
      String [] strings = new String[n];
      for (int j = 0; j < n; j ++)
        strings[j] = in.next();
      // now parse the string into beginning, middle, and end
      // beginning is before first *
      // end is after last *
      // middle is anything in between multiple * (possibly empty set)
      String [] begin = new String[n];
      String [] middle = new String[n];
      String [] end = new String[n];
      for (int j = 0; j < n; j ++) {
        String str = strings[j];
        int firstIndex = str.indexOf('*');
        int lastIndex = str.lastIndexOf('*');
        begin[j] = str.substring(0,firstIndex);
        end[j] = str.substring(lastIndex+1);
        if (lastIndex > firstIndex)
          middle[j] = str.substring(firstIndex+1, lastIndex).replace("*","");
        else
          middle[j] = "";
      }
      // find the longest beginning string and make sure everything else is a substring
      int longestBeginning = 0;
      int longestEnding = 0;
      String beginning = "";
      String ending = "";
      for (int j = 0; j < n; j ++) {
        if (begin[j].length() > longestBeginning) {
          beginning = begin[j];
          longestBeginning = begin[j].length();
        }
        if (end[j].length() > longestEnding) {
          ending = end[j];
          longestEnding = end[j].length();
        }
      }
      // now make sure all begin and end strings are substrings of beginning and ending
      boolean failed = false;
      for (int j = 0; j < n; j ++) {
        failed = failed || (beginning.indexOf(begin[j]) != 0) 
          || (ending.lastIndexOf(end[j]) != ending.length() - end[j].length());
      }
      System.out.print("Case #" + i + ": ");
      if (failed)
        System.out.print("*");
      else {
        System.out.print(beginning);
        for (int j = 0; j < n; j ++)
          System.out.print(middle[j]);
        System.out.print(ending);
      }
      System.out.println();
    }
  }
}

