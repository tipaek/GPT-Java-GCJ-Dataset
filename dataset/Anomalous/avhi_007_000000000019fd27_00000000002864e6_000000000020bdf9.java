import java.util.*;
import java.io.*;

public class Solution {
    public static String[] check(int[][] intervals, int[] newInterval, int index, String[] assignments) {
        boolean occupiedC = false, occupiedJ = false;

        for (int i = 0; i < index; i++) {
            if (newInterval[1] <= intervals[i][0]) {
                assignments[index] = assignments[i];
            } else if (newInterval[1] > intervals[i][0] && newInterval[0] <= intervals[i][0]) {
                assignments[index] = assignments[i].equals("C") ? "J" : "C";
                break;
            } else if (newInterval[1] < intervals[i][1] && newInterval[0] < intervals[i][0]) {
                assignments[index] = assignments[i].equals("C") ? "J" : "C";
                break;
            } else if (newInterval[1] < intervals[i][1] && newInterval[0] >= intervals[i][0]) {
                if (assignments[i].equals("C")) occupiedC = true;
                else if (assignments[i].equals("J")) occupiedJ = true;

                if (!occupiedJ) assignments[index] = "J";
                else if (!occupiedC) assignments[index] = "C";

                break;
            } else if (newInterval[1] >= intervals[i][1] && newInterval[0] >= intervals[i][1]) {
                assignments[index] = assignments[i];
                break;
            } else if (newInterval[1] >= intervals[i][1] && newInterval[0] < intervals[i][1] && newInterval[0] >= intervals[i][0]) {
                assignments[index] = assignments[i].equals("C") ? "J" : "C";
                break;
            } else if (newInterval[1] >= intervals[i][1] && newInterval[0] <= intervals[i][0]) {
                if (assignments[i].equals("C")) occupiedC = true;
                else if (assignments[i].equals("J")) occupiedJ = true;

                if (!occupiedJ) assignments[index] = "J";
                else if (!occupiedC) assignments[index] = "C";

                break;
            } else if (newInterval[1] == intervals[i][1] && newInterval[0] == intervals[i][0]) {
                if (assignments[i].equals("C")) occupiedC = true;
                else if (assignments[i].equals("J")) occupiedJ = true;

                if (!occupiedJ) assignments[index] = "J";
                else if (!occupiedC) assignments[index] = "C";

                break;
            }
        }
        return assignments;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String impossible = "IMPOSSIBLE";
        int[] temp = new int[2];
        int testCases = scanner.nextInt();

        try {
            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
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
                    assignments = check(intervals, temp, l, assignments);
                }

                for (String assignment : assignments) {
                    if (assignment != null) {
                        result += assignment;
                    } else {
                        result = impossible;
                        break;
                    }
                }

                System.out.println("Case #" + t + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}