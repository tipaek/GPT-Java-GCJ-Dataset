import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    String temp = in.nextLine();
    for (int i = 1; i <= t; ++i) {
      int open = 0;
      String out = "Case #" + i + ": ";
      String input = in.nextLine();
      for (char c: input.toCharArray()) {
        if(!Character.isDigit(c))
          break;
        int ci = c - '0';
        if (ci > open) {
          for(int j = 0; j < ci - open; j++)
            out += '(';
        }
        else {
          for(int j = 0; j < open - ci; j++)
            out += ')';
        }
        out += c;
        open = ci;
      }
      for(int j = 0; j < open; j++)
        out += ')';
      System.out.println(out);
    }
  }
}