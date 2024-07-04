import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int tasks = scan.nextInt();
            int[] startTimes = new int[tasks];
            int[] endTimes = new int[tasks];
            for (int i = 0; i < tasks; i++) {
                startTimes[i] = scan.nextInt();
                endTimes[i] = scan.nextInt();
            }

            String result = assignTasks(startTimes, endTimes);
            System.out.printf("Case #%d: %s\n", caseNum, result);
        }
    }

    private static String assignTasks(int[] startTimes, int[] endTimes) {
        List<int[]> cIntervals = new ArrayList<>();
        List<int[]> jIntervals = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < startTimes.length; i++) {
            boolean canAssignToC = canAssign(cIntervals, startTimes[i], endTimes[i]);
            boolean canAssignToJ = canAssign(jIntervals, startTimes[i], endTimes[i]);

            if (canAssignToC) {
                cIntervals.add(new int[]{startTimes[i], endTimes[i]});
                result.append("C");
            } else if (canAssignToJ) {
                jIntervals.add(new int[]{startTimes[i], endTimes[i]});
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean canAssign(List<int[]> intervals, int start, int end) {
        for (int[] interval : intervals) {
            if (overlaps(interval[0], interval[1], start, end)) {
                return false;
            }
        }
        return true;
    }

    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && start2 < end1);
    }
}