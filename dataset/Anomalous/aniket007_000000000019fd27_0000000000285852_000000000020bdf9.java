import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int c = 0, j = 0;
            int[][] C = new int[2][n + 1];
            int[][] J = new int[2][n + 1];
            StringBuilder s = new StringBuilder();
            boolean isImpossible = false;

            outerLoop:
            for (int l = 0; l < n; l++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean canAssignToC = true;
                boolean canAssignToJ = true;

                for (int u = c - 1; u >= 0; u--) {
                    if (!(start >= C[1][u] || end <= C[0][u])) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    C[0][c] = start;
                    C[1][c] = end;
                    s.append("C");
                    c++;
                } else {
                    for (int y = j - 1; y >= 0; y--) {
                        if (!(start >= J[1][y] || end <= J[0][y])) {
                            canAssignToJ = false;
                            break;
                        }
                    }

                    if (canAssignToJ) {
                        J[0][j] = start;
                        J[1][j] = end;
                        s.append("J");
                        j++;
                    } else {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        isImpossible = true;
                        break outerLoop;
                    }
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + i + ": " + s.toString());
            }
        }
    }
}