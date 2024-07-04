import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numberOfCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();

    for(int k = 1; k <= numberOfCases; k++) {
      String s = in.nextLine();
      int prev = -1;
      HashSet<Integer> hs = new HashSet<>();
      String answer = "";
      boolean open = false;
      char[] c = s.toCharArray();

      for(int i = 0; i < c.length; i++) {
        if(c[i] - '0' == 1) {
          if(!open) {
            answer += "(1";
            open = true;
          } else {
            answer += "1";
          }
        }

        if(c[i] - '0' == 0) {
          if(open) {
            answer += ")0";
            open = false;
          } else {
            answer += "0";
          }
        }
      }

      if(open) {
        answer += ")";
      }
      System.out.println("Case #" + k + ": " + answer);


    }


  // public static int[][] sanitizeInput(int num, Scanner in) {
  //   int[][] matrix = new int[num][3];
  //   for(int i = 0; i < num; i++) {
  //     String[] tokens = in.nextLine().split(" ");
  //     timeTable[i][0] = Integer.parseInt(tokens[0]);
  //     timeTable[i][1] = Integer.parseInt(tokens[1]);
  //     timeTable[i][2] = i;
  //   }
  //   return timeTable;
  // }
}
}