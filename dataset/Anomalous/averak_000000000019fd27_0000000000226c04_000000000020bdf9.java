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
            boolean isImpossible = false;
            
            for (int i = 0; i < intervalCount; i++) {
                for (int j = 0; j < 2; j++) {
                    intervals[i][j] = scanner.nextInt();
                }
                
                String intervalKey = intervals[i][0] + "-" + intervals[i][1];
                if (intervalMap.get(intervalKey) == null) {
                    intervalMap.put(intervalKey, i);
                } else {
                    String duplicateKey = intervalKey + "-";
                    if (intervalMap.get(duplicateKey) == null) {
                        intervalMap.put(duplicateKey, i);
                    } else {
                        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }
            
            if (!isImpossible) {
                assignTasks(intervals, testCase, intervalMap);
            }
        }
    }

    public static void assignTasks(int[][] intervals, int testCaseNumber, Map<String, Integer> intervalMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.length];
        int cEnd = intervals[0][1];
        int jEnd = 0;
        
        result[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
        
        for (int i = 1; i < intervals.length; i++) {
            String intervalKey = intervals[i][0] + "-" + intervals[i][1];
            String duplicateKey = intervalKey + "-";
            
            if (intervals[i][0] >= cEnd) {
                if (result[intervalMap.get(intervalKey)] == '\u0000') {
                    result[intervalMap.get(intervalKey)] = 'C';
                } else {
                    result[intervalMap.get(duplicateKey)] = 'C';
                }
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                if (result[intervalMap.get(intervalKey)] == '\u0000') {
                    result[intervalMap.get(intervalKey)] = 'J';
                } else {
                    result[intervalMap.get(duplicateKey)] = 'J';
                }
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }
        
        System.out.println("Case #" + testCaseNumber + ": " + new String(result));
    }
}