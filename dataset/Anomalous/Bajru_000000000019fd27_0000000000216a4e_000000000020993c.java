import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            processMatrix(matrix, n, t);
        }
    }

    private static void processMatrix(int[][] matrix, int size, int caseNumber) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[101];
            boolean[] colCheck = new boolean[101];
            boolean rowFlag = false;
            boolean colFlag = false;

            for (int j = 0; j < size; j++) {
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

            if (rowFlag) rowRepeats++;
            if (colFlag) colRepeats++;
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}