import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int cCount = 0, jCount = 0;
            int[][] intervals = new int[2][n];
            int[][] cIntervals = new int[2][n];
            int[][] jIntervals = new int[2][n];
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int l = 0; l < n; l++) {
                intervals[0][l] = sc.nextInt();
                intervals[1][l] = sc.nextInt();
            }

            outerLoop:
            for (int l = 0; l < n; l++) {
                int start = intervals[0][l];
                int end = intervals[1][l];
                boolean canAssignC = true, canAssignJ = true;

                // Check if the interval can be assigned to C
                for (int u = 0; u < cCount; u++) {
                    if (!(start >= cIntervals[1][u] || end <= cIntervals[0][u])) {
                        canAssignC = false;
                        break;
                    }
                }

                if (canAssignC) {
                    cIntervals[0][cCount] = start;
                    cIntervals[1][cCount] = end;
                    schedule.append("C");
                    cCount++;
                } else {
                    // Check if the interval can be assigned to J
                    for (int y = 0; y < jCount; y++) {
                        if (!(start >= jIntervals[1][y] || end <= jIntervals[0][y])) {
                            canAssignJ = false;
                            break;
                        }
                    }

                    if (canAssignJ) {
                        jIntervals[0][jCount] = start;
                        jIntervals[1][jCount] = end;
                        schedule.append("J");
                        jCount++;
                    } else {
                        isImpossible = true;
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        break outerLoop;
                    }
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
    }
}