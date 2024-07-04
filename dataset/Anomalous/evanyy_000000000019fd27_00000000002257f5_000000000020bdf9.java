import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + assignTasks(intervals));
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
            for (int k = 0; k < cameronIndex; k++) {
                if (!(cameron[k][1] <= interval[0] || cameron[k][0] >= interval[1])) {
                    assignedToCameron = false;
                    break;
                }
            }

            if (assignedToCameron) {
                cameron[cameronIndex][0] = interval[0];
                cameron[cameronIndex][1] = interval[1];
                cameronIndex++;
                result.append("C");
            } else {
                boolean assignedToJamie = true;
                for (int m = 0; m < jamieIndex; m++) {
                    if (!(jamie[m][1] <= interval[0] || jamie[m][0] >= interval[1])) {
                        return "IMPOSSIBLE";
                    }
                }
                jamie[jamieIndex][0] = interval[0];
                jamie[jamieIndex][1] = interval[1];
                jamieIndex++;
                result.append("J");
            }
        }
        return result.toString();
    }
}