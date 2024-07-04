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

        for (int i = 0; i < intervals.length; i++) {
            boolean assignedToCameron = true;

            for (int c = 0; c < cameronIndex; c++) {
                if (!(cameron[c][1] <= intervals[i][0] || cameron[c][0] >= intervals[i][1])) {
                    for (int j = 0; j < jamieIndex; j++) {
                        if (!(jamie[j][1] <= intervals[i][0] || jamie[j][0] >= intervals[i][1])) {
                            return "IMPOSSIBLE";
                        }
                    }

                    jamie[jamieIndex][0] = intervals[i][0];
                    jamie[jamieIndex][1] = intervals[i][1];
                    jamieIndex++;
                    result.append("J");
                    assignedToCameron = false;
                    break;
                }
            }

            if (assignedToCameron) {
                cameron[cameronIndex][0] = intervals[i][0];
                cameron[cameronIndex][1] = intervals[i][1];
                cameronIndex++;
                result.append("C");
            }
        }

        return result.toString();
    }
}