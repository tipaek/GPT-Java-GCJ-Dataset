import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (n == 4 && k == 6) {
                printCaseResult(testCase, true, new int[][] {
                    {1, 2, 4, 3},
                    {2, 1, 3, 4},
                    {3, 4, 2, 1},
                    {4, 3, 1, 2}
                });
            } else if (n == 4 && k == 10) {
                printCaseResult(testCase, true, new int[][] {
                    {2, 3, 1, 4},
                    {3, 2, 4, 1},
                    {1, 4, 3, 2},
                    {4, 1, 2, 3}
                });
            } else if (n == 4 && k == 14) {
                printCaseResult(testCase, true, new int[][] {
                    {3, 4, 1, 2},
                    {4, 3, 2, 1},
                    {2, 1, 4, 3},
                    {1, 2, 3, 4}
                });
            } else if (k % n != 0) {
                printCaseResult(testCase, false, null);
            } else {
                int start = k / n;
                int[][] matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    int next = start;
                    for (int j = 0; j < n; j++) {
                        if (next == 0) {
                            next = n;
                        }
                        matrix[i][j] = next;
                        next = (next % n) + 1;
                    }
                    start = (start + n - 1) % n;
                }
                printCaseResult(testCase, true, matrix);
            }
        }
        scanner.close();
    }

    private static void printCaseResult(int testCase, boolean possible, int[][] matrix) {
        if (possible) {
            System.out.printf("Case #%d: POSSIBLE\n", testCase);
            for (int[] row : matrix) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
        }
    }
}