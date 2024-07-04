import java.util.*;
import java.io.*;

public class Solution {

    public static String[] assignTasks(int[][] intervals, int[] newInterval, int n, String[] assignments) {
        boolean occupiedC = false, occupiedJ = false;

        for (int i = 0; i < n; i++) {
            if (newInterval[1] < intervals[i][0]) {
                assignments[n] = assignments[i];
            } else if (newInterval[1] < intervals[i][1] && newInterval[0] < intervals[i][0]) {
                assignments[n] = assignments[i].equals("C") ? "J" : "C";
                break;
            } else if (newInterval[1] < intervals[i][1] && newInterval[0] >= intervals[i][0]) {
                if (assignments[i].equals("C")) occupiedC = true;
                else if (assignments[i].equals("J")) occupiedJ = true;

                if (!occupiedJ) assignments[n] = "J";
                else if (!occupiedC) assignments[n] = "C";
                break;
            } else if (newInterval[1] >= intervals[i][1] && newInterval[0] >= intervals[i][1]) {
                assignments[n] = assignments[i];
                break;
            } else if (newInterval[1] >= intervals[i][1] && newInterval[0] < intervals[i][1] && newInterval[0] >= intervals[i][0]) {
                assignments[n] = assignments[i].equals("C") ? "J" : "C";
                break;
            } else if (newInterval[1] >= intervals[i][1] && newInterval[0] <= intervals[i][0]) {
                if (assignments[i].equals("C")) occupiedC = true;
                else if (assignments[i].equals("J")) occupiedJ = true;

                if (!occupiedJ) assignments[n] = "J";
                else if (!occupiedC) assignments[n] = "C";
                break;
            }
        }
        return assignments;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String IMPOSSIBLE = "IMPOSSIBLE";
        int[] temp = new int[2];
        int T = scanner.nextInt();

        try {
            for (int i = 1; i <= T; i++) {
                int n = scanner.nextInt();
                if (n >= 2 && n <= 10) {
                    String result = "";
                    String[] assignments = new String[n];
                    assignments[0] = "C";
                    int[][] intervals = new int[n][2];

                    for (int j = 0; j < n; j++) {
                        intervals[j][0] = scanner.nextInt();
                        intervals[j][1] = scanner.nextInt();
                    }

                    for (int l = 1; l < n; l++) {
                        temp[0] = intervals[l][0];
                        temp[1] = intervals[l][1];
                        assignments = assignTasks(intervals, temp, l, assignments);
                    }

                    for (int m = 0; m < n; m++) {
                        if (assignments[m] != null) {
                            result += assignments[m];
                        } else {
                            result = IMPOSSIBLE;
                            break;
                        }
                    }
                    System.out.println("Case #" + i + ": " + result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}