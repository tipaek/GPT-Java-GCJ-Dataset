import java.io.*;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int num = Integer.parseInt(input.nextLine());
    StringBuilder sb;
    for (int i=0; i<num; i++) { //size
      String ans = helper(input.nextLine());
      sb = new StringBuilder();
      sb.append("Case #").append(i+1).append(": ").append(ans);
      System.out.println(sb.toString());
    }
  }

  public static String helper(String line) {
    int numOParan = 0;
    int numCParan = 0;
    StringBuilder sb = new StringBuilder();
    int prev = -1;
    for (int i=0; i<line.length(); i++) {
      int curr = line.charAt(i) - '0';
      if (i == 0 || prev == 0) {
        helpappend('(', curr, sb);
        sb.append(curr);
        numOParan+=curr;
      }
      else {
        if (prev > curr) {
          helpappend(')', prev-curr, sb);
          sb.append(curr);
          numCParan += prev - curr;
        }
        else if (prev < curr) {
          helpappend('(', curr-prev, sb);
          sb.append(curr);
          numOParan += curr-prev;
        }
        else {
          sb.append(curr);
        }
      }
      prev = curr;
    }
    helpappend(')', numOParan - numCParan, sb);
    return sb.toString();
  }

  public static void helpappend(char toAppend, int times, StringBuilder sb) {
    for (int i=0; i<times; i++) {
      sb.append(toAppend);
    }
  }
}