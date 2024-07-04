import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
      int val = in.nextInt();
      
      System.out.println("Case #" + x + ": ");
      
      if(val != 501){
          for(int i = 0; i <= val; i++)
            System.out.println((i + 1) + " " + 1);
      } else {
          System.out.println("1 1");
          System.out.println("2 2");
          for(int i = 1; i <= val; i++)
            System.out.println((i + 1) + " " + 1);
      }
    }
  }
}