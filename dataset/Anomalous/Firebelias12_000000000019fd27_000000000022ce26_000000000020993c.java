import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int repeatR = calculateMaxRepetitions(matrix, n, true);
            int repeatC = calculateMaxRepetitions(matrix, n, false);

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatR + " " + repeatC);
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int calculateMaxRepetitions(int[][] matrix, int n, boolean isRow) {
        int maxRepetitions = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[n + 1];
            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                count[value]++;
                if (count[value] > maxRepetitions) {
                    maxRepetitions = count[value];
                }
            }
        }
        return maxRepetitions;
    }
}