import java.util.Scanner;

public class Solution {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            int[][] intervals = new int[2][n];
            int[][] original = new int[2][n];

            for (int l = 0; l < n; l++) {
                original[0][l] = intervals[0][l] = sc.nextInt();
                original[1][l] = intervals[1][l] = sc.nextInt();
            }

            sort(intervals);

            StringBuilder assignment = new StringBuilder();
            StringBuilder result = new StringBuilder();
            int[][] C = new int[2][n];
            int[][] J = new int[2][n];
            int cCount = 0, jCount = 0;
            boolean impossible = false;

            outer:
            for (int l = 0; l < n; l++) {
                int start = intervals[0][l];
                int end = intervals[1][l];

                if (cCount == 0 || start >= C[1][cCount - 1]) {
                    C[0][cCount] = start;
                    C[1][cCount] = end;
                    assignment.append('C');
                    cCount++;
                } else if (jCount == 0 || start >= J[1][jCount - 1]) {
                    J[0][jCount] = start;
                    J[1][jCount] = end;
                    assignment.append('J');
                    jCount++;
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    impossible = true;
                    break outer;
                }
            }

            if (!impossible) {
                for (int l = 0; l < n; l++) {
                    for (int k = 0; k < n; k++) {
                        if (original[0][l] == intervals[0][k] && original[1][l] == intervals[1][k]) {
                            result.append(assignment.charAt(k));
                            break;
                        }
                    }
                }
                System.out.println("Case #" + i + ": " + result);
            }
        }
        sc.close();
    }

    static void sort(int[][] a) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[0][j] > a[0][j + 1]) {
                    int tempStart = a[0][j];
                    int tempEnd = a[1][j];
                    a[0][j] = a[0][j + 1];
                    a[1][j] = a[1][j + 1];
                    a[0][j + 1] = tempStart;
                    a[1][j + 1] = tempEnd;
                }
            }
        }
    }
}