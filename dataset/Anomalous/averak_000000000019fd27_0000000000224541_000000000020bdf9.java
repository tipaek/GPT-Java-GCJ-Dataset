import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int intervalCount = scanner.nextInt();
            int[][] intervals = new int[intervalCount][2];
            Map<String, Integer> intervalMap = new HashMap<>();
            
            for (int i = 0; i < intervalCount; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervalMap.put(intervals[i][0] + "-" + intervals[i][1], i);
            }
            
            assignTasks(intervals, testCase, intervalMap);
        }
    }
    
    private static void assignTasks(int[][] intervals, int testCaseNumber, Map<String, Integer> intervalMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.length];
        
        result[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
        int cEndTime = intervals[0][1];
        int jEndTime = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= cEndTime) {
                result[intervalMap.get(intervals[i][0] + "-" + intervals[i][1])] = 'C';
                cEndTime = intervals[i][1];
            } else if (intervals[i][0] >= jEndTime) {
                result[intervalMap.get(intervals[i][0] + "-" + intervals[i][1])] = 'J';
                jEndTime = intervals[i][1];
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }
        
        System.out.println("Case #" + testCaseNumber + ": " + new String(result));
    }
}