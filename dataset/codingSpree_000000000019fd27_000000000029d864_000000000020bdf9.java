import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int n = in.nextInt();
        int[][] input = new int[n][3];
        for (int p = 0; p < n; p++) {
            input[p][0] = in.nextInt();
            input[p][1] = in.nextInt();
            input[p][2] = p;
        }
        String s = getValidSchedule(input, n);
        System.out.println("Case #" + i + ": " + s);
    }
  }
    
    public static String getValidSchedule(int[][] activities, int n) {
        Arrays.sort(activities, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        char[] parent = new char[n];
        int cEnd = 0;
        int jEnd = 0;
        for (int i = 0; i < n; i++ ) {
            if (cEnd <= activities[i][0]) {
                parent[i] = 'C';
                cEnd = activities[i][1];
            } else if (jEnd <= activities[i][0]) {
                parent[i] = 'J';
                jEnd = activities[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("C");
        }
        for (int i = 0; i < n; i++) {
            result.setCharAt(activities[i][2], parent[i]);
        }
        return result.toString();
    }
  }