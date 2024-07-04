import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
            }
            
            String result = assignTasks(intervals, n);
            System.out.println("Case #" + tt + ": " + result);
        }
    }

    private static String assignTasks(int[][] intervals, int n) {
        List<int[]> cList = new ArrayList<>();
        List<int[]> jList = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (canAssign(cList, start, end)) {
                cList.add(new int[] { start, end });
                schedule.append("C");
            } else if (canAssign(jList, start, end)) {
                jList.add(new int[] { start, end });
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    private static boolean canAssign(List<int[]> list, int start, int end) {
        for (int[] interval : list) {
            if (intervalsOverlap(interval[0], interval[1], start, end)) {
                return false;
            }
        }
        return true;
    }

    private static boolean intervalsOverlap(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && start2 < end1);
    }
}