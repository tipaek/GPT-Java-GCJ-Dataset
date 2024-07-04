import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] rowElements = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowElements[col]);
                }
            }

            processMatrix(matrix, matrixSize, caseIndex);
        }
    }

    private static void processMatrix(int[][] matrix, int size, int caseIndex) {
        int diagonalSum = 0;
        int maxRowDuplicates = 1;
        int maxColDuplicates = 1;

        for (int i = 0; i < size; i++) {
            Map<Integer, Integer> rowMap = new HashMap<>();
            Map<Integer, Integer> colMap = new HashMap<>();

            diagonalSum += matrix[i][i];

            for (int j = 0; j < size; j++) {
                int rowValue = matrix[i][j];
                rowMap.put(rowValue, rowMap.getOrDefault(rowValue, 0) + 1);
                maxRowDuplicates = Math.max(maxRowDuplicates, rowMap.get(rowValue));

                int colValue = matrix[j][i];
                colMap.put(colValue, colMap.getOrDefault(colValue, 0) + 1);
                maxColDuplicates = Math.max(maxColDuplicates, colMap.get(colValue));
            }
        }

        maxRowDuplicates = (maxRowDuplicates == 1) ? 0 : maxRowDuplicates;
        maxColDuplicates = (maxColDuplicates == 1) ? 0 : maxColDuplicates;

        System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + maxRowDuplicates + " " + maxColDuplicates);
        System.out.flush();
    }
}