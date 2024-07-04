import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    for (int i = 1; i <= t; ++i) {
      int open = 0;
      System.out.print("Case #" + i + ": ");
      for (char c: in.nextLine()) {
        int ci = c - '0';
        if (ci > open) {
          for(int j = 0; j < ci - open; j++)
            System.out.print('(');
        }
        else {
          for(int j = 0; j < open - ci; j++)
            System.out.print(')');
        }
        System.out.print(c);
        open = ci;
      }
      System.out.println();
    }
  }
}