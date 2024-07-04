import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int added = 1;
            int numOfTasks = in.nextInt();
            char[] ans = new char[numOfTasks];
            int[][] map = new int[numOfTasks][3];
            for (int k = 0; k < numOfTasks; k++) { 
                int key = in.nextInt();
                int value = in.nextInt();
                int j = k - 1; 
            while (j >= 0 && map[j][0] > key) { 
                    map[j + 1][0] = map[j][0];
                    map[j + 1][1] = map[j][1];
                    map[j + 1][2] = map[j][2];
                    j = j - 1; 
                } 
                map[j + 1][0] = key;
                map[j + 1][1] = value;
                map[j + 1][2] = k;
            }
            int cLower = map[0][0];
            int cUpper = map[0][1];
            int jLower = 24 * 60 + 1;
            int jUpper = -1;
            ans[map[0][2]] = 'C';
            for (int j = 1; j < numOfTasks; j++) {
                int taskLow = map[j][0];
                int taskUp = map[j][1];
                int pos = map[j][2];
                if(taskUp <= cLower) {
                    added++;
                    ans[pos] = 'C';
                    cLower = taskLow;
                } 
                else if(taskLow >= cUpper) {
                    added++;
                    ans[pos] = 'C';
                    cUpper = taskUp;
                }
                else if(taskUp <= jLower) {
                    added++;
                    ans[pos] = 'J';
                    jLower = taskLow;
                    if(jUpper < 0) {
                        jUpper = taskUp;
                    }
                } 
                else if(taskLow >= jUpper) {
                    added++;
                    ans[pos] = 'J';
                    jUpper = taskUp;
                    if(jLower > 24 * 60) {
                        jLower = taskLow;
                    }
                } else {
                    
                }    
            }
            String result = "";
            if(added < numOfTasks) {
                result = "IMPOSSIBLE";
            } else {
                result = new String(ans);
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
}