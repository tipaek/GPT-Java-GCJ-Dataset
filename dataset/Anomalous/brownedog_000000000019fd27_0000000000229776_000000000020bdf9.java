import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; ++j) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        int n = intervals.length;
        char[] assignments = new char[n];
        Arrays.fill(assignments, 'C');
        
        List<Integer> cameronTasks = new ArrayList<>();
        List<Integer> jamieTasks = new ArrayList<>();

        cameronTasks.add(0);

        for (int i = 1; i < n; ++i) {
            boolean assigned = false;

            for (int camTask : cameronTasks) {
                if (overlaps(intervals[i], intervals[camTask])) {
                    assigned = tryAssignToJamie(i, intervals, jamieTasks, assignments);
                    if (assigned) break;
                }
            }

            if (!assigned) {
                cameronTasks.add(i);
                assignments[i] = 'C';
            }
        }

        return isPossible(assignments) ? new String(assignments) : "IMPOSSIBLE";
    }

    private static boolean tryAssignToJamie(int i, int[][] intervals, List<Integer> jamieTasks, char[] assignments) {
        for (int jamTask : jamieTasks) {
            if (overlaps(intervals[i], intervals[jamTask])) {
                return false;
            }
        }
        jamieTasks.add(i);
        assignments[i] = 'J';
        return true;
    }

    private static boolean overlaps(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval1[1] > interval2[0];
    }

    private static boolean isPossible(char[] assignments) {
        for (char assignment : assignments) {
            if (assignment == '\0') return false;
        }
        return true;
    }
}