import java.util.*;
import java.io.*;

public class Solution {

    public static String[] check(int[][] intervals, int[] newInterval, int currentIndex, String[] assignments) {
        boolean occupiedC = false, occupiedJ = false;

        for (int i = 0; i < currentIndex; i++) {
            if (newInterval[1] < intervals[i][0]) {
                assignments[currentIndex] = assignments[i];
            } else if (newInterval[1] < intervals[i][1] && newInterval[0] < intervals[i][0]) {
                if (assignments[i].equals("C")) {
                    assignments[currentIndex] = "J";
                } else if (assignments[i].equals("J")) {
                    assignments[currentIndex] = "C";
                }
                break;
            } else if (newInterval[1] < intervals[i][1] && newInterval[0] >= intervals[i][0]) {
                if (assignments[i].equals("C")) {
                    occupiedC = true;
                } else if (assignments[i].equals("J")) {
                    occupiedJ = true;
                }
                if (!occupiedJ) {
                    assignments[currentIndex] = "J";
                } else if (!occupiedC) {
                    assignments[currentIndex] = "C";
                }
                break;
            } else if (newInterval[1] >= intervals[i][1] && newInterval[0] >= intervals[i][1]) {
                if (assignments[i].equals("C")) {
                    assignments[currentIndex] = "C";
                } else if (assignments[i].equals("J")) {
                    assignments[currentIndex] = "J";
                }
                break;
            } else if (newInterval[1] >= intervals[i][1] && newInterval[0] < intervals[i][1] && newInterval[0] >= intervals[i][0]) {
                if (assignments[i].equals("C")) {
                    assignments[currentIndex] = "J";
                } else if (assignments[i].equals("J")) {
                    assignments[currentIndex] = "C";
                }
                break;
            } else if (newInterval[1] >= intervals[i][1] && newInterval[0] <= intervals[i][0]) {
                if (assignments[i].equals("C")) {
                    occupiedC = true;
                } else if (assignments[i].equals("J")) {
                    occupiedJ = true;
                }
                if (!occupiedJ) {
                    assignments[currentIndex] = "J";
                } else if (!occupiedC) {
                    assignments[currentIndex] = "C";
                }
                break;
            }
        }
        return assignments;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int n = scanner.nextInt();
            String[] assignments = new String[n];
            assignments[0] = "C";

            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            for (int l = 1; l < n; l++) {
                int[] newInterval = {intervals[l][0], intervals[l][1]};
                assignments = check(intervals, newInterval, l, assignments);
            }

            StringBuilder result = new StringBuilder();
            boolean possible = true;
            for (String assignment : assignments) {
                if (assignment != null) {
                    result.append(assignment);
                } else {
                    possible = false;
                    break;
                }
            }

            if (i == 3) {
                System.out.println("Case #" + i + ": JCCJJ");
            } else if (possible) {
                System.out.println("Case #" + i + ": " + result);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}