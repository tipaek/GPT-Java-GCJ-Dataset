import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    int a = in.nextInt();
    int b = in.nextInt();
    Loop: for (int q = 1; q <= t; ++q) {
        
        if(a == 1000000000-5) {
            for(int i = -5; i <= 5; i++) {
                for(int j = -5; j <= 5; j++) {
                    System.out.println(i + " " + j);
                    String s = in.next();
                    if(s.equals("CENTER")) continue Loop;
                }
            }
        }
        
        if(a == 1000000000 - 50) {
            long first = 0;
            long testx = 0;
            Outer: while(true) {
                testx = 1000000000 - first;
                System.out.println(testx + " " + 101);
                String s = in.next();
                if(s.equals("HIT")) break Outer;
                first++;
            }
            
            for(int y = -50; y <= 50; y++) {
                long test = 50+1-first;
                System.out.println(test + " " + y);
                String s = in.next();
                if(s.equals("CENTER")) continue Loop;
            }
        }
        
        
      
    }
  }
}