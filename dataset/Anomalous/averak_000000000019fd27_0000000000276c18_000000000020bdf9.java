import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            if (scanner.hasNext()) {
                int intervalsCount = scanner.nextInt();
                int[][] intervals = new int[intervalsCount][2];
                Map<String, Integer> intervalMap = new HashMap<>();
                boolean isImpossible = false;

                for (int i = 0; i < intervalsCount; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (scanner.hasNext()) {
                            intervals[i][j] = scanner.nextInt();
                        }
                    }
                    if (!isImpossible) {
                        String key = intervals[i][0] + "-" + intervals[i][1];
                        if (intervalMap.get(key) == null) {
                            intervalMap.put(key, i);
                        } else {
                            String conflictKey = key + "*";
                            if (intervalMap.get(conflictKey) == null) {
                                intervalMap.put(conflictKey, i);
                            } else {
                                isImpossible = true;
                            }
                        }
                    }
                }

                if (!isImpossible) {
                    assignTasks(intervals, testCase, intervalMap);
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                }
            }
        }
    }

    public static void assignTasks(int[][] intervals, int caseNumber, Map<String, Integer> intervalMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.length];
        int cEnd = intervals[0][1];
        int jEnd = 0;

        result[intervalMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
        intervalMap.remove(intervals[0][0] + "-" + intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            String key = intervals[i][0] + "-" + intervals[i][1];
            if (intervalMap.get(key) == null) {
                key = key + "*";
            }
            Integer index = intervalMap.get(key);
            if (index == null) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
            if (intervals[i][0] >= cEnd) {
                result[intervalMap.get(key)] = 'C';
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                result[intervalMap.get(key)] = 'J';
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
            intervalMap.remove(key);
        }
        System.out.println("Case #" + caseNumber + ": " + new String(result));
    }
}