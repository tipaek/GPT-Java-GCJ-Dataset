import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int a = in.nextInt();
    int b = in.nextInt();
    for (int q = 1; q <= t; ++q) {
        Outer: for(int i = -5; i <= 5; i++) {
            for(int j = -5; j <= 5; j++) {
                System.out.println(i + " " + j);
                String s = in.next();
                if(s.equals("CENTER")) break Outer;
            }
        }
      
    }
  }
}