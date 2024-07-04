import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int intervalsCount = scanner.nextInt();
            int[][] intervals = new int[intervalsCount][2];
            Map<String, Integer> intervalMap = new HashMap<>();
            boolean isImpossible = false;
            
            for (int i = 0; i < intervalsCount; i++) {
                for (int j = 0; j < 2; j++) {
                    intervals[i][j] = scanner.nextInt();
                }
                String key = intervals[i][0] + "-" + intervals[i][1];
                
                if (intervalMap.containsKey(key)) {
                    String altKey = key + "-";
                    if (intervalMap.containsKey(altKey)) {
                        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    } else {
                        intervalMap.put(altKey, i);
                    }
                } else {
                    intervalMap.put(key, i);
                }
            }
            
            if (!isImpossible) {
                processIntervals(intervals, testCase, intervalMap);
            }
        }
    }

    private static void processIntervals(int[][] intervals, int testCase, Map<String, Integer> intervalMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        char[] result = new char[intervals.length];
        int cEnd = intervals[0][1];
        int jEnd = 0;
        result[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= cEnd) {
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
        }
        
        System.out.println("Case #" + testCase + ": " + new String(result));
    }
}