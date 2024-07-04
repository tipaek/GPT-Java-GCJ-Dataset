import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test cases

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        int n = intervals.length;
        int[] assigned = new int[n];
        Arrays.fill(assigned, -1); // -1 means unassigned, 0 for C, 1 for J

        List<int[]> cameron = new ArrayList<>();
        List<int[]> jamie = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (canAssign(cameron, intervals[i])) {
                cameron.add(intervals[i]);
                assigned[i] = 0;
            } else if (canAssign(jamie, intervals[i])) {
                jamie.add(intervals[i]);
                assigned[i] = 1;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (int assign : assigned) {
            result.append(assign == 0 ? 'C' : 'J');
        }

        return result.toString();
    }

    private static boolean canAssign(List<int[]> schedule, int[] interval) {
        for (int[] task : schedule) {
            if (interval[0] < task[1] && interval[1] > task[0]) {
                return false;
            }
        }
        return true;
    }
}