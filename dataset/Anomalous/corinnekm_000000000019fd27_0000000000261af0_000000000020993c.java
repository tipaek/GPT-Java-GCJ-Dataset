import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0;
            int repeatedRows = 0;

            for (int i = 0; i < matrixSize; i++) {
                String[] rowValues = scanner.nextLine().split(" ");
                HashMap<Integer, Boolean> rowMap = new HashMap<>();

                for (int j = 0; j < matrixSize; j++) {
                    int value = Integer.parseInt(rowValues[j]);
                    if (i == j) {
                        trace += value;
                    }
                    rowMap.put(value, true);
                    matrix[i][j] = value;
                }

                if (rowMap.size() < matrixSize) {
                    repeatedRows++;
                }
            }

            int repeatedColumns = countRepeatedColumns(matrixSize, matrix);
            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, repeatedRows, repeatedColumns);
        }
    }

    private static int countRepeatedColumns(int size, int[][] matrix) {
        int repeatedColumns = 0;

        for (int col = 0; col < size; col++) {
            HashMap<Integer, Boolean> colMap = new HashMap<>();

            for (int row = 0; row < size; row++) {
                int value = matrix[row][col];
                colMap.put(value, true);
            }

            if (colMap.size() < size) {
                repeatedColumns++;
            }
        }

        return repeatedColumns;
    }
}