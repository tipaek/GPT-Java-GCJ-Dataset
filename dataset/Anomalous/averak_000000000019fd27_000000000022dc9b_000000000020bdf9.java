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
                String key = intervals[i][0] + "-" + intervals[i][1];
                
                if (intervalMap.putIfAbsent(key, i) != null) {
                    key += "*";
                    if (intervalMap.putIfAbsent(key, i) != null) {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (!isImpossible) {
                assignTasks(intervals, t, intervalMap);
            }
        }
    }

    private static void assignTasks(int[][] intervals, int caseNum, Map<String, Integer> intervalMap) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        char[] schedule = new char[intervals.length];
        int cEnd = intervals[0][1];
        int jEnd = -1;
        
        schedule[intervalMap.remove(intervals[0][0] + "-" + intervals[0][1])] = 'C';

        for (int i = 1; i < intervals.length; i++) {
            String key = intervals[i][0] + "-" + intervals[i][1];
            Integer index = intervalMap.remove(key);
            if (index == null) {
                key += "*";
                index = intervalMap.remove(key);
            }

            if (index == null) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                return;
            }

            if (intervals[i][0] >= cEnd) {
                schedule[index] = 'C';
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                schedule[index] = 'J';
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + caseNum + ": " + new String(schedule));
    }
}