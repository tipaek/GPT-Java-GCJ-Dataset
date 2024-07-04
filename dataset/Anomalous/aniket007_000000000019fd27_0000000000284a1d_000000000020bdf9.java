import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int cCount = 0, jCount = 0;
            int[][] C = new int[2][n];
            int[][] J = new int[2][n];
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int l = 0; l < n; l++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean assigned = false;

                // Try to assign to C
                if (cCount == 0 || canAssign(C, cCount, start, end)) {
                    C[0][cCount] = start;
                    C[1][cCount++] = end;
                    schedule.append("C");
                    assigned = true;
                } else if (jCount == 0 || canAssign(J, jCount, start, end)) {
                    // Try to assign to J
                    J[0][jCount] = start;
                    J[1][jCount++] = end;
                    schedule.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
        sc.close();
    }

    private static boolean canAssign(int[][] schedule, int count, int start, int end) {
        for (int i = count - 1; i >= 0; i--) {
            if (!(start >= schedule[1][i] || end <= schedule[0][i])) {
                return false;
            }
        }
        return true;
    }
}