import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numOfTasks = in.nextInt();
            int cLower = in.nextInt();
            int cUpper = in.nextInt();
            int jLower = 24 * 60 + 1;
            int jUpper = -1;
            StringBuilder result = new StringBuilder();
            result.append("C");
            for (int j = 1; j < numOfTasks; j++) {
                int taskLow = in.nextInt();
                int taskUp = in.nextInt();
                if(taskUp <= cLower) {
                    result.append("C");
                    cLower = taskLow;
                } 
                else if(taskLow >= cUpper) {
                    result.append("C");
                    cUpper = taskUp;
                }
                else if(taskUp <= jLower) {
                    result.append("J");
                    jLower = taskLow;
                    if(jUpper < 0) {
                        jUpper = taskUp;
                    }
                } 
                else if(taskLow >= jUpper) {
                    result.append("J");
                    jUpper = taskUp;
                    if(jLower > 24 * 60) {
                        jLower = taskLow;
                    }
                } else {
                    break;
                }    
            }
            if(result.length() < numOfTasks) {
                result.delete(0, result.length());
                result.append("IMPOSSIBLE");
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}