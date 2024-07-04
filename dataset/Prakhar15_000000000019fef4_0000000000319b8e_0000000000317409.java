import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            String path = in.next();
            
            int out = -1;
            
            if (n == 0 && m == 0) {
                out = 0;
            }
            
            for (int j = 0; j < path.length(); j++) {
                
                if (path.charAt(j) == 'N') {
                    m++;
                } else if (path.charAt(j) == 'S') {
                    m--;
                } else if (path.charAt(j) == 'E') {
                    n++;
                } else if (path.charAt(j) == 'W') {
                    n--;
                }
                
                if (Math.abs(n)+Math.abs(m) <= j+1) {
                    out = j+1;
                    break;
                }
            }
            
            String output = "IMPOSSIBLE";
            if (out >= 0) {
                output = out + "";
            }
            
            System.out.println("Case #" + i + ": " + output);
        }
    }
}