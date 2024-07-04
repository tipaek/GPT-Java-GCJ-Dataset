import java.util.*;
import java.io.*;

public class Solution {
    static String schedule(List<int[]> intervals) {
        int[] j = null;
        int[] c = null;
        StringBuilder result = new StringBuilder();
        
        for (int[] interval : intervals) {
            if (j == null || j[1] <= interval[0] || interval[1] <= j[0]) {
                j = interval;
                result.append("J");
            } else if (c == null || c[1] <= interval[0] || interval[1] <= c[0]) {
                c = interval;
                result.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end});
            }
            
            String result = schedule(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}