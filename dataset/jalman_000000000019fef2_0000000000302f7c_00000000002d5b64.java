import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int q = 1; q <= t; ++q) {
        
        int rr = in.nextInt();
        int ss = in.nextInt();
        
        int ret = (rr-1)*(ss-1);
        
        System.out.println("Case #" + q + ": " + ret);
        
        for(int r = rr; r > 1; r--) {
            for(int j = 0; j < ss-1; j++) {
                System.out.println((r*(j+1)) + " " + (r-1));
            }
        }
        
        
    }
  }
}