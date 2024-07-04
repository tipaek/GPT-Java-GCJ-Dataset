import java.util.*;

public class Solution {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            int c = 0, j = 0;
            int[][] intervals = new int[2][n];
            int[][] C = new int[2][n];
            int[][] J = new int[2][n];
            String schedule = "", result = "";
            boolean isImpossible = false;
            int[][] originalIntervals = new int[2][n];

            for (int l = 0; l < n; l++) {
                originalIntervals[0][l] = intervals[0][l] = sc.nextInt();
                originalIntervals[1][l] = intervals[1][l] = sc.nextInt();
            }

            sortIntervals(intervals);

            outerLoop:
            for (int l = 0; l < n; l++) {
                int start = intervals[0][l];
                int end = intervals[1][l];

                if (c == 0 || start >= C[1][c - 1]) {
                    C[0][c] = start;
                    C[1][c] = end;
                    schedule += "C";
                    c++;
                } else if (j == 0 || start >= J[1][j - 1]) {
                    J[0][j] = start;
                    J[1][j] = end;
                    schedule += "J";
                    j++;
                } else {
                    isImpossible = true;
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    break outerLoop;
                }
            }

            if (!isImpossible) {
                for (int l = 0; l < n; l++) {
                    for (int k = 0; k < n; k++) {
                        if (originalIntervals[0][l] == intervals[0][k] && originalIntervals[1][l] == intervals[1][k]) {
                            result += schedule.charAt(k);
                            break;
                        }
                    }
                }
                System.out.println("Case #" + i + ": " + result);
            }
        }
    }

    static void sortIntervals(int[][] intervals) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (intervals[0][j] > intervals[0][j + 1]) {
                    int tempStart = intervals[0][j];
                    int tempEnd = intervals[1][j];
                    intervals[0][j] = intervals[0][j + 1];
                    intervals[1][j] = intervals[1][j + 1];
                    intervals[0][j + 1] = tempStart;
                    intervals[1][j + 1] = tempEnd;
                }
            }
        }
    }
}