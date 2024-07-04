import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            Map<String, Integer> intervalMap = new HashMap<>();
            boolean isImpossible = false;
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervalMap.put(intervals[i][0] + "-" + intervals[i][1], i);
            }
            
            if (!isImpossible) {
                processIntervals(intervals, t, intervalMap);
            }
        }
    }

    public static void processIntervals(int[][] intervals, int testCaseNumber, Map<String, Integer> intervalMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.length];
        result[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
        intervalMap.remove(intervals[0][0] + "-" + intervals[0][1]);
        
        int cEnd = intervals[0][1];
        int jEnd = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            String key = intervals[i][0] + "-" + intervals[i][1];
            Integer index = intervalMap.get(key);
            
            if (index == null) {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
            
            if (intervals[i][0] >= cEnd) {
                result[index] = 'C';
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                result[index] = 'J';
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
            
            intervalMap.remove(key);
        }
        
        System.out.println("Case #" + testCaseNumber + ": " + new String(result));
    }
}