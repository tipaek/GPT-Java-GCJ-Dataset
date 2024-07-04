import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = in.nextInt();
        for (int i = 1; i <= testCaseCount; i++) {
            int intervalCount = in.nextInt();
            int[][] intervals = new int[intervalCount][2];
            Map<String, Integer> intervalMap = new HashMap<>();
            boolean isImpossible = false;
            
            for (int j = 0; j < intervalCount; j++) {
                for (int k = 0; k < 2; k++) {
                    intervals[j][k] = in.nextInt();
                }
                String key = intervals[j][0] + "-" + intervals[j][1];
                if (intervalMap.get(key) == null) {
                    intervalMap.put(key, j);
                } else {
                    if (intervalMap.get(key + "-") == null) {
                        intervalMap.put(key + "-", j);
                    } else {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }
            if (!isImpossible) {
                assignTasks(intervals, i, intervalMap);
            }
        }
    }

    public static void assignTasks(int[][] intervals, int caseNum, Map<String, Integer> intervalMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.length];
        result[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
        int cEnd = intervals[0][1];
        int jEnd = 0;

        for (int i = 1; i < intervals.length; i++) {
            String key = intervals[i][0] + "-" + intervals[i][1];
            if (intervals[i][0] >= cEnd) {
                result[intervalMap.get(key)] = 'C';
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                result[intervalMap.get(key)] = 'J';
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + caseNum + ": " + new String(result));
    }
}