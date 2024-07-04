import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] C = new int[2][n];
            int[][] J = new int[2][n];
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;
            int cCount = 0, jCount = 0;

            for (int l = 0; l < n; l++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                boolean assigned = false;

                if (cCount == 0) {
                    C[0][cCount] = start;
                    C[1][cCount++] = end;
                    schedule.append("C");
                    assigned = true;
                } else {
                    for (int u = cCount - 1; u >= 0; u--) {
                        if (start < C[1][u] && end > C[0][u]) {
                            assigned = false;
                            break;
                        } else {
                            assigned = true;
                        }
                    }
                    if (assigned) {
                        C[0][cCount] = start;
                        C[1][cCount++] = end;
                        schedule.append("C");
                    } else {
                        assigned = false;
                        if (jCount == 0) {
                            J[0][jCount] = start;
                            J[1][jCount++] = end;
                            schedule.append("J");
                            assigned = true;
                        } else {
                            for (int y = jCount - 1; y >= 0; y--) {
                                if (start < J[1][y] && end > J[0][y]) {
                                    assigned = false;
                                    break;
                                } else {
                                    assigned = true;
                                }
                            }
                            if (assigned) {
                                J[0][jCount] = start;
                                J[1][jCount++] = end;
                                schedule.append("J");
                            } else {
                                isImpossible = true;
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                break;
                            }
                        }
                    }
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }

        sc.close();
    }
}