import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String line = in.next();
            System.out.println("Case #" + i + ": " + solve(line));
        }
    }
    
    private static String solve(String line)
    {
        StringBuilder sb = new StringBuilder();
        int curDepth = 0;
        for(int i = 0; i<line.length(); i++)
        {
            int d = line.charAt(i) - '0';
            if(d == curDepth)
            {
                sb.append(d);                
            }
            else if(d > curDepth)
            {
                int cnt = d-curDepth;
                while(cnt-->0)
                {
                    sb.append('(');
                }
                curDepth = d;
                sb.append(d);
            }
            else
            {
                int cnt = curDepth - d;
                while(cnt-->0)
                {
                    sb.append(')');
                }
                curDepth = d;
                sb.append(d);
            }
        }
        
        while(curDepth-->0) sb.append(')');
        
        return sb.toString();
    }
}
