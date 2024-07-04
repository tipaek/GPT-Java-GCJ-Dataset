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
            int jLower = -1;
            int jUpper = -1;
            StringBuilder result = new StringBuilder();
            arrayOfTasks[0] = "C";
            for (int j = 1; j < numOfTasks; j++) {
                int taskLow = in.nextInt();
                int taskUp = in.nextInt();
                if(taskUp <= cLower || taskLow >= cUpper) {
                    if(taskUp <= cLower) {
                       arrayOfTasks[j] = "C";
                       cLower = taskLow;
                    } else {
                        arrayOfTasks[j] = "C";
                        cUpper = taskUp;
                    }
                } else {
                    if(jLower < 0) {
                        arrayOfTasks[j] = "J";
                        jLower = taskLow;
                        jUpper = taskUp;
                    } else {
                        if(taskUp <= jLower || taskLow >= jUpper) {
                            if(taskUp <= jLower) {
                            arrayOfTasks[j] = "J";
                            jLower = taskLow;
                            } else {
                                arrayOfTasks[j] = "J";
                                jUpper = taskUp;
                            }
                        } else {
                            result.append("IMPOSSIBLE");
                            break;
                        }
                    }
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