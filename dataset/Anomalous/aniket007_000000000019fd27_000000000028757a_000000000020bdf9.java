import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            int[][] C = new int[n][2];
            int[][] J = new int[n][2];
            int cCount = 0, jCount = 0;
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int l = 0; l < n; l++) {
                intervals[l][0] = sc.nextInt();
                intervals[l][1] = sc.nextInt();
            }

            outerLoop:
            for (int l = 0; l < n; l++) {
                int start = intervals[l][0];
                int end = intervals[l][1];
                boolean canAssignC = true, canAssignJ = true;

                for (int u = 0; u < cCount; u++) {
                    if (!(start >= C[u][1] || end <= C[u][0])) {
                        canAssignC = false;
                        break;
                    }
                }

                if (canAssignC) {
                    C[cCount][0] = start;
                    C[cCount][1] = end;
                    result.append("C");
                    cCount++;
                } else {
                    for (int u = 0; u < jCount; u++) {
                        if (!(start >= J[u][1] || end <= J[u][0])) {
                            canAssignJ = false;
                            break;
                        }
                    }

                    if (canAssignJ) {
                        J[jCount][0] = start;
                        J[jCount][1] = end;
                        result.append("J");
                        jCount++;
                    } else {
                        isImpossible = true;
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        break outerLoop;
                    }
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }

        sc.close();
    }
}