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
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                String key = intervals[i][0] + "-" + intervals[i][1];
                if (!intervalMap.containsKey(key)) {
                    intervalMap.put(key, i);
                } else if (!intervalMap.containsKey(key + "*")) {
                    intervalMap.put(key + "*", i);
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                assignTasks(intervals, testCase, intervalMap);
            }
        }
    }

    private static void assignTasks(int[][] intervals, int testCase, Map<String, Integer> intervalMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.length];
        result[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
        int cEndTime = intervals[0][1];
        int jEndTime = 0;

        for (int i = 1; i < intervals.length; i++) {
            String key = intervals[i][0] + "-" + intervals[i][1];
            if (intervals[i][0] >= cEndTime) {
                if (result[intervalMap.get(key)] != 'C' && result[intervalMap.get(key)] != 'J') {
                    result[intervalMap.get(key)] = 'C';
                } else {
                    result[intervalMap.get(key + "*")] = 'C';
                }
                cEndTime = intervals[i][1];
            } else if (intervals[i][0] >= jEndTime) {
                if (result[intervalMap.get(key)] != 'C' && result[intervalMap.get(key)] != 'J') {
                    result[intervalMap.get(key)] = 'J';
                } else {
                    result[intervalMap.get(key + "*")] = 'J';
                }
                jEndTime = intervals[i][1];
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + testCase + ": " + new String(result));
    }
}