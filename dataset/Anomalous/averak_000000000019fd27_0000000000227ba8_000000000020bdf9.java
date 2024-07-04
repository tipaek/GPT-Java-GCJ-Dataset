import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int intervalsCount = in.nextInt();
            int[][] intervals = new int[intervalsCount][2];
            Map<String, Integer> indexMap = new HashMap<>();
            boolean impossible = false;

            for (int j = 0; j < intervalsCount; j++) {
                for (int k = 0; k < 2; k++) {
                    intervals[j][k] = in.nextInt();
                }

                String key = intervals[j][0] + "-" + intervals[j][1];
                if (indexMap.containsKey(key)) {
                    key += "-";
                    if (indexMap.containsKey(key)) {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
                indexMap.put(key, j);
            }

            if (!impossible) {
                assignTasks(intervals, i, indexMap);
            }
        }
    }

    private static void assignTasks(int[][] intervals, int caseNumber, Map<String, Integer> indexMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[intervals.length];
        result[indexMap.get(intervals[0][0] + "-" + intervals[0][1])] = 'C';
        int cEnd = intervals[0][1];
        int jEnd = 0;

        for (int i = 1; i < intervals.length; i++) {
            String key = intervals[i][0] + "-" + intervals[i][1];
            if (intervals[i][0] >= cEnd) {
                result[indexMap.get(key)] = 'C';
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                result[indexMap.get(key)] = 'J';
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + caseNumber + ": " + new String(result));
    }
}