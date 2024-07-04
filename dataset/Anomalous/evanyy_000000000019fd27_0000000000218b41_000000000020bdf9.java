import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            System.out.println("Case #" + t + ": " + assignTasks(intervals));
        }
    }

    public static String assignTasks(int[][] intervals) {
        StringBuilder result = new StringBuilder();
        int[][] cameron = new int[intervals.length][2];
        int[][] jamie = new int[intervals.length][2];
        int cameronIndex = 0;
        int jamieIndex = 0;

        for (int[] interval : intervals) {
            boolean assignedToCameron = true;

            for (int i = 0; i < cameronIndex; i++) {
                if (overlaps(cameron[i], interval)) {
                    assignedToCameron = false;
                    break;
                }
            }

            if (assignedToCameron) {
                cameron[cameronIndex++] = interval;
                result.append("C");
                continue;
            }

            boolean assignedToJamie = true;
            for (int i = 0; i < jamieIndex; i++) {
                if (overlaps(jamie[i], interval)) {
                    return "IMPOSSIBLE";
                }
            }

            jamie[jamieIndex++] = interval;
            result.append("J");
        }

        return result.toString();
    }

    private static boolean overlaps(int[] interval1, int[] interval2) {
        return !(interval1[1] <= interval2[0] || interval1[0] >= interval2[1]);
    }
}