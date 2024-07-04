import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            solve(matrix, n, testCase);
        }
    }

    private static void solve(int[][] matrix, int n, int testCase) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[101];
            boolean[] colCheck = new boolean[101];
            boolean rowFlag = false;
            boolean colFlag = false;

            for (int j = 0; j < n; j++) {
                if (rowCheck[matrix[i][j]]) {
                    rowFlag = true;
                } else {
                    rowCheck[matrix[i][j]] = true;
                }

                if (colCheck[matrix[j][i]]) {
                    colFlag = true;
                } else {
                    colCheck[matrix[j][i]] = true;
                }
            }

            if (rowFlag) {
                duplicateRows++;
            }
            if (colFlag) {
                duplicateColumns++;
            }
        }

        System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}