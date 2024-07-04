import java.util.Scanner;

public class Solution {

    private static int n;
    private static int trace;
    private static int[][] matrix;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {

            n = scanner.nextInt();
            trace = scanner.nextInt();
            matrix = new int[n][n];
            boolean result = solve(0);

            if (result) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                printMatrix();
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean solve(int index) {

        if (index == n * n) {
            return isValid();
        }

        boolean[] used = new boolean[n];
        int row = index / n;
        int col = index % n;

        for (int i = 0; i < row; i++) {
            used[matrix[i][col]] = true;
        }
        for (int i = 0; i < col; i++) {
            used[matrix[row][i]] = true;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            matrix[row][col] = i;
            if (solve(index + 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValid() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum + n == trace;
    }

    private static void printMatrix() {
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][0] + 1);
            for (int j = 1; j < n; j++) {
                System.out.print(" " + (matrix[i][j] + 1));
            }
            System.out.println();
        }
    }
}