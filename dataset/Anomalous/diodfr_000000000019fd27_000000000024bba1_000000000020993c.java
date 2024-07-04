import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int t = 1; t <= testCases; t++) {
                int matrixSize = Integer.parseInt(scanner.nextLine());
                int[][] matrix = new int[matrixSize][matrixSize];

                for (int i = 0; i < matrixSize; i++) {
                    String[] line = scanner.nextLine().split(" ");
                    for (int j = 0; j < matrixSize; j++) {
                        matrix[i][j] = Integer.parseInt(line[j]);
                    }
                }

                int diagonalSum = 0;
                for (int i = 0; i < matrixSize; i++) {
                    diagonalSum += matrix[i][i];
                }

                int maxColDuplicates = 0;
                for (int i = 0; i < matrixSize; i++) {
                    int[] colValues = new int[matrixSize];
                    for (int j = 0; j < matrixSize; j++) {
                        colValues[matrix[i][j] - 1]++;
                    }
                    maxColDuplicates = Math.max(maxColDuplicates, countDuplicates(colValues));
                }

                int maxRowDuplicates = 0;
                for (int i = 0; i < matrixSize; i++) {
                    int[] rowValues = new int[matrixSize];
                    for (int j = 0; j < matrixSize; j++) {
                        rowValues[matrix[j][i] - 1]++;
                    }
                    maxRowDuplicates = Math.max(maxRowDuplicates, countDuplicates(rowValues));
                }

                System.out.printf("Case #%d: %d %d %d%n", t, diagonalSum, maxColDuplicates, maxRowDuplicates);
            }
        }
    }

    private static int countDuplicates(int[] values) {
        int duplicateCount = 0;
        for (int value : values) {
            if (value > 1) {
                duplicateCount += value;
            }
        }
        return duplicateCount;
    }
}