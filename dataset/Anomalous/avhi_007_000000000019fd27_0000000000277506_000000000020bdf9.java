import java.util.*;
import java.io.*;

public class Solution {
    public static String[] check(int[][] intervals, int[] current, int index, String[] assignments) {
        boolean occupiedC = false, occupiedJ = false;

        for (int i = 0; i < index; i++) {
            if (current[1] <= intervals[i][0]) {
                assignments[index] = assignments[i];
            } else if (current[1] > intervals[i][0] && current[0] <= intervals[i][0]) {
                assignments[index] = assignments[i].equals("C") ? "J" : "C";
                break;
            } else if (current[1] < intervals[i][1] && current[0] < intervals[i][0]) {
                assignments[index] = assignments[i].equals("C") ? "J" : "C";
                break;
            } else if (current[1] < intervals[i][1] && current[0] >= intervals[i][0]) {
                if (assignments[i].equals("C")) occupiedC = true;
                else if (assignments[i].equals("J")) occupiedJ = true;

                if (!occupiedJ) assignments[index] = "J";
                else if (!occupiedC) assignments[index] = "C";

                break;
            } else if (current[1] >= intervals[i][1] && current[0] >= intervals[i][1]) {
                assignments[index] = assignments[i];
                break;
            } else if (current[1] >= intervals[i][1] && current[0] < intervals[i][1] && current[0] >= intervals[i][0]) {
                assignments[index] = assignments[i].equals("C") ? "J" : "C";
                break;
            } else if (current[1] >= intervals[i][1] && current[0] <= intervals[i][0]) {
                if (assignments[i].equals("C")) occupiedC = true;
                else if (assignments[i].equals("J")) occupiedJ = true;

                if (!occupiedJ) assignments[index] = "J";
                else if (!occupiedC) assignments[index] = "C";

                break;
            } else if (current[1] == intervals[i][1] && current[0] == intervals[i][0]) {
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
        int T = scanner.nextInt();

        try {
            for (int i = 1; i <= T; i++) {
                int n = scanner.nextInt();
                String ans = "";
                String[] assignments = new String[n];
                assignments[0] = "C";
                int[][] intervals = new int[n][2];

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 2; k++) {
                        intervals[j][k] = scanner.nextInt();
                    }
                }

                for (int l = 1; l < n; l++) {
                    temp[0] = intervals[l][0];
                    temp[1] = intervals[l][1];
                    assignments = check(intervals, temp, l, assignments);
                }

                for (int m = 0; m < n; m++) {
                    if (assignments[m] != null) {
                        ans += assignments[m];
                    } else {
                        ans = impossible;
                        break;
                    }
                }

                System.out.println("Case #" + i + ": " + ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}