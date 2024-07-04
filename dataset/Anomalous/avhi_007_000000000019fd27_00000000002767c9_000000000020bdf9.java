import java.util.*;
import java.io.*;

public class Solution {
    public static String[] check(int[][] intervals, int[] currentInterval, int currentIndex, String[] assignments) {
        boolean occupiedC = false, occupiedJ = false;

        for (int i = 0; i < currentIndex; i++) {
            if (currentInterval[1] <= intervals[i][0]) {
                assignments[currentIndex] = assignments[i];
            } else if (currentInterval[1] > intervals[i][0] && currentInterval[0] <= intervals[i][0]) {
                if (assignments[i].equals("C")) {
                    assignments[currentIndex] = "J";
                } else if (assignments[i].equals("J")) {
                    assignments[currentIndex] = "C";
                }
                break;
            } else if (currentInterval[1] < intervals[i][1] && currentInterval[0] < intervals[i][0]) {
                if (assignments[i].equals("C")) {
                    assignments[currentIndex] = "J";
                } else if (assignments[i].equals("J")) {
                    assignments[currentIndex] = "C";
                }
                break;
            } else if (currentInterval[1] < intervals[i][1] && currentInterval[0] >= intervals[i][0]) {
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
            } else if (currentInterval[1] >= intervals[i][1] && currentInterval[0] >= intervals[i][1]) {
                assignments[currentIndex] = assignments[i];
                break;
            } else if (currentInterval[1] >= intervals[i][1] && currentInterval[0] < intervals[i][1] && currentInterval[0] >= intervals[i][0]) {
                if (assignments[i].equals("C")) {
                    assignments[currentIndex] = "J";
                } else if (assignments[i].equals("J")) {
                    assignments[currentIndex] = "C";
                }
                break;
            } else if (currentInterval[1] >= intervals[i][1] && currentInterval[0] <= intervals[i][0]) {
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
        String impossible = "IMPOSSIBLE";
        int[] temp = new int[2];
        int T = scanner.nextInt();

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
                temp[0] = intervals[l][0];
                temp[1] = intervals[l][1];
                assigned = check(intervals, temp, l, assigned);
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
        scanner.close();
    }
}