import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numOfTasks = in.nextInt();
            String[] arrayOfTasks = new String[numOfTasks];
            int cLower = in.nextInt();
            int cUpper = in.nextInt();
            int jLower = 24 * 60 + 1;
            int jUpper = -1;
            StringBuilder result = new StringBuilder();
            arrayOfTasks[0] = "C";
            for (int j = 1; j < numOfTasks; j++) {
                int taskLow = in.nextInt();
                int taskUp = in.nextInt();
                if(taskUp <= cLower) {
                    arrayOfTasks[j] = "C";
                    cLower = taskLow;
                } 
                else if(taskLow >= cUpper) {
                    arrayOfTasks[j] = "C";
                    cUpper = taskUp;
                }
                else if(taskUp <= jLower) {
                    arrayOfTasks[j] = "J";
                    jLower = taskLow;
                    if(jUpper < 0) {
                        jUpper = taskUp;
                    }
                } 
                else if(taskLow >= jUpper) {
                    arrayOfTasks[j] = "J";
                    jUpper = taskUp;
                    if(jLower > 24 * 60) {
                        jLower = taskLow;
                    }
                } else {
                    result.append("IMPOSSIBLE");
                    break;
                }    
            }
            if(result.length() == 0) {
                for (int j = 0; j < numOfTasks; j++) {
                    result.append(arrayOfTasks[j]);
                }
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}