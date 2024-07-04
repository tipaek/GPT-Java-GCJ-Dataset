import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();

            int[][] matrix = new int[N][N];
            int[][] transposedMatrix = new int[N][N];

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    matrix[row][col] = scanner.nextInt();
                    transposedMatrix[col][row] = matrix[row][col];
                }
            }

            int traceValue = calculateTrace(matrix);
            int repeatedRows = countRepeatedNumbersInRows(matrix);
            int repeatedCols = countRepeatedNumbersInRows(transposedMatrix);

            System.out.println("Case #" + (i + 1) + ": " + traceValue + " " + repeatedRows + " " + repeatedCols);
        }

        scanner.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedNumbersInRows(int[][] matrix) {
        int repeatedCount = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueNumbers = new HashSet<>();
            for (int num : row) {
                if (!uniqueNumbers.add(num)) {
                    repeatedCount++;
                    break;
                }
            }
        }
        return repeatedCount;
    }
}