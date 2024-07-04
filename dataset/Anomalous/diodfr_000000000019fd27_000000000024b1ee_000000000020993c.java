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
                    String[] row = scanner.nextLine().split(" ");
                    for (int j = 0; j < matrixSize; j++) {
                        matrix[i][j] = Integer.parseInt(row[j]);
                    }
                }

                int diagonalSum = 0;
                for (int i = 0; i < matrixSize; i++) {
                    diagonalSum += matrix[i][i];
                }

                int maxColumnRepetition = 0;
                for (int i = 0; i < matrixSize; i++) {
                    int[] columnCount = new int[matrixSize];
                    for (int j = 0; j < matrixSize; j++) {
                        columnCount[matrix[i][j] - 1]++;
                    }
                    maxColumnRepetition = Math.max(maxColumnRepetition, getMaxRepetition(columnCount));
                }

                int maxRowRepetition = 0;
                for (int i = 0; i < matrixSize; i++) {
                    int[] rowCount = new int[matrixSize];
                    for (int j = 0; j < matrixSize; j++) {
                        rowCount[matrix[j][i] - 1]++;
                    }
                    maxRowRepetition = Math.max(maxRowRepetition, getMaxRepetition(rowCount));
                }

                System.out.printf("Case #%d: %d %d %d%n", t, diagonalSum, maxColumnRepetition, maxRowRepetition);
            }
        }
    }

    private static int getMaxRepetition(int[] counts) {
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        return max == 1 ? 0 : max;
    }
}