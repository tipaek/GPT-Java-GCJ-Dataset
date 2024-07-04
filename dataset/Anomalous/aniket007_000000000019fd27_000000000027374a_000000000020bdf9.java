import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int cCount = 0, jCount = 0;
            int[][] C = new int[2][n];
            int[][] J = new int[2][n];
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            outerLoop:
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assignedToC = false;
                boolean assignedToJ = false;

                if (cCount == 0) {
                    C[0][cCount] = start;
                    C[1][cCount++] = end;
                    schedule.append("C");
                    assignedToC = true;
                } else {
                    for (int u = cCount - 1; u >= 0; u--) {
                        if (!(start >= C[1][u] || end <= C[0][u])) {
                            assignedToC = false;
                            break;
                        }
                        assignedToC = true;
                    }
                    if (assignedToC) {
                        C[0][cCount] = start;
                        C[1][cCount++] = end;
                        schedule.append("C");
                    }
                }

                if (!assignedToC) {
                    if (jCount == 0) {
                        J[0][jCount] = start;
                        J[1][jCount++] = end;
                        schedule.append("J");
                        assignedToJ = true;
                    } else {
                        for (int y = jCount - 1; y >= 0; y--) {
                            if (!(start >= J[1][y] || end <= J[0][y])) {
                                assignedToJ = false;
                                break;
                            }
                            assignedToJ = true;
                        }
                        if (assignedToJ) {
                            J[0][jCount] = start;
                            J[1][jCount++] = end;
                            schedule.append("J");
                        }
                    }
                }

                if (!assignedToC && !assignedToJ) {
                    isImpossible = true;
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                    break outerLoop;
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + testCase + ": " + schedule.toString());
            }
        }
    }
}