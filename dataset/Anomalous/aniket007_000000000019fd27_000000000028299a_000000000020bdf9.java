import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int c = 0, j = 0;
            int[][] C = new int[2][n];
            int[][] J = new int[2][n];
            StringBuilder s = new StringBuilder();
            boolean isPossible = true;

            for (int l = 0; l < n; l++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean assigned = false;

                if (c == 0) {
                    C[0][c] = start;
                    C[1][c++] = end;
                    s.append("C");
                } else {
                    boolean canAssignC = true;
                    for (int u = c - 1; u >= 0; u--) {
                        if (!(start >= C[1][u] || end <= C[0][u])) {
                            canAssignC = false;
                            break;
                        }
                    }
                    if (canAssignC) {
                        C[0][c] = start;
                        C[1][c++] = end;
                        s.append("C");
                        assigned = true;
                    }
                }

                if (!assigned) {
                    if (j == 0) {
                        J[0][j] = start;
                        J[1][j++] = end;
                        s.append("J");
                    } else {
                        boolean canAssignJ = true;
                        for (int y = j - 1; y >= 0; y--) {
                            if (!(start >= J[1][y] || end <= J[0][y])) {
                                canAssignJ = false;
                                break;
                            }
                        }
                        if (canAssignJ) {
                            J[0][j] = start;
                            J[1][j++] = end;
                            s.append("J");
                        } else {
                            isPossible = false;
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }

            if (isPossible) {
                System.out.println("Case #" + i + ": " + s.toString());
            }
        }

        sc.close();
    }
}