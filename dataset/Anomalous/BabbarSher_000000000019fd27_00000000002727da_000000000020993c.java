import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int matrixSize = scanner.nextInt();
                scanner.nextLine();
                int[][] matrix = new int[matrixSize][matrixSize];

                for (int index = 0; index < matrixSize * matrixSize; index++) {
                    int element = scanner.nextInt();
                    matrix[index / matrixSize][index % matrixSize] = element;
                }

                int[] results = calculateResults(matrix, matrixSize);
                System.out.printf("Case #%d: %d %d %d%n", caseNumber, results[0], results[1], results[2]);
            }
        }
    }

    private static int[] calculateResults(int[][] matrix, int size) {
        int[] results = new int[3];
        int trace = 0;

        for (int i = 0; i < size; i++) {
            boolean[] rowValues = new boolean[size + 1];
            boolean rowHasDuplicates = false;

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (rowValues[matrix[i][j]]) {
                    rowHasDuplicates = true;
                }
                rowValues[matrix[i][j]] = true;
            }

            if (rowHasDuplicates) {
                results[1]++;
            }
        }

        results[0] = trace;

        for (int i = 0; i < size; i++) {
            boolean[] colValues = new boolean[size + 1];
            boolean colHasDuplicates = false;

            for (int j = 0; j < size; j++) {
                if (colValues[matrix[j][i]]) {
                    colHasDuplicates = true;
                }
                colValues[matrix[j][i]] = true;
            }

            if (colHasDuplicates) {
                results[2]++;
            }
        }

        return results;
    }
}