import java.util.*;
import java.io.*;

public class Solution {
    public static String[] check(int[][] intervals, int[] current, int index, String[] assignments) {
        boolean occupiedC = false, occupiedJ = false;

        for (int i = 0; i < index; i++) {
            if (current[1] <= intervals[i][0]) {
                assignments[index] = assignments[i];
            } else if (current[1] <= intervals[i][1] && current[0] < intervals[i][0]) {
                assignments[index] = assignments[i].equals("C") ? "J" : "C";
                break;
            } else if (current[1] <= intervals[i][1] && current[0] >= intervals[i][0]) {
                if (assignments[i].equals("C")) occupiedC = true;
                if (assignments[i].equals("J")) occupiedJ = true;

                if (!occupiedJ) {
                    assignments[index] = "J";
                } else if (!occupiedC) {
                    assignments[index] = "C";
                }
                break;
            } else if (current[1] >= intervals[i][1] && current[0] >= intervals[i][1]) {
                assignments[index] = assignments[i];
                break;
            } else if (current[1] >= intervals[i][1] && current[0] < intervals[i][1] && current[0] >= intervals[i][0]) {
                assignments[index] = assignments[i].equals("C") ? "J" : "C";
                break;
            } else if (current[1] >= intervals[i][1] && current[0] <= intervals[i][0]) {
                if (assignments[i].equals("C")) occupiedC = true;
                if (assignments[i].equals("J")) occupiedJ = true;

                if (!occupiedJ) {
                    assignments[index] = "J";
                } else if (!occupiedC) {
                    assignments[index] = "C";
                }
                break;
            }
        }
        return assignments;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String impossible = "IMPOSSIBLE";
        int[] tmp = new int[2];
        int T = scanner.nextInt();

        try {
            for (int i = 1; i <= T; i++) {
                int n = scanner.nextInt();
                String ans = "";
                String[] assigned = new String[n];
                assigned[0] = "C";

                int[][] intervals = new int[n][2];
                for (int j = 0; j < n; j++) {
                    intervals[j][0] = scanner.nextInt();
                    intervals[j][1] = scanner.nextInt();
                }

                for (int l = 1; l < n; l++) {
                    tmp[0] = intervals[l][0];
                    tmp[1] = intervals[l][1];
                    assigned = check(intervals, tmp, l, assigned);
                }

                for (int m = 0; m < n; m++) {
                    if (assigned[m] != null) {
                        ans += assigned[m];
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