import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numOfTasks = in.nextInt();
            int[][] map = new int[numOfTasks][2];
            for (int k = 0; k < numOfTasks; k++) { 
                int key = in.nextInt();
                int value = in.nextInt();
                int j = k - 1; 
            while (j >= 0 && map[j][0] < key) { 
                    map[j + 1][0] = map[j][0];
                    map[j + 1][1] = map[j][1];
                    j = j - 1; 
                } 
                map[j + 1][0] = key;
                map[j + 1][1] = value;
            }
            int cLower = map[0][0];
            int cUpper = map[0][1];
            int jLower = 24 * 60 + 1;
            int jUpper = -1;
            StringBuilder result = new StringBuilder();
            result.append("C");
            for (int j = 1; j < numOfTasks; j++) {
                int taskLow = map[j][0];
                int taskUp = map[j][1];
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