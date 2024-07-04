import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] intervals = new int[size][2];
            Map<String, Integer> indexMap = new HashMap<>();
            boolean isImpossible = false;

            for (int i = 0; i < size; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                String key = intervals[i][0] + "-" + intervals[i][1];

                if (!indexMap.containsKey(key)) {
                    indexMap.put(key, i);
                } else {
                    String duplicateKey = key + "-";
                    if (!indexMap.containsKey(duplicateKey)) {
                        indexMap.put(duplicateKey, i);
                    } else {
                        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (!isImpossible) {
                processIntervals(intervals, testCase, indexMap);
            }
        }
    }

    private static void processIntervals(int[][] intervals, int testCase, Map<String, Integer> indexMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.length];
        int cEnd = intervals[0][1];
        int jEnd = 0;

        result[indexMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';

        for (int i = 1; i < intervals.length; i++) {
            String key = intervals[i][0] + "-" + intervals[i][1];

            if (intervals[i][0] >= cEnd) {
                assignTask(result, indexMap, key, 'C');
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                assignTask(result, indexMap, key, 'J');
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + testCase + ": " + new String(result));
    }

    private static void assignTask(char[] result, Map<String, Integer> indexMap, String key, char task) {
        if (result[indexMap.get(key)] == '\u0000') {
            result[indexMap.get(key)] = task;
        } else {
            result[indexMap.get(key + "-")] = task;
        }
    }
}