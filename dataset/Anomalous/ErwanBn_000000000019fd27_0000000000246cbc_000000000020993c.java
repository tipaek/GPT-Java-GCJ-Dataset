import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfMatrices = scanner.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            int dimension = scanner.nextInt();
            List<int[]> matrix = new ArrayList<>();
            int diagonalSum = 0;
            int maxRowDuplicates = 0;

            for (int row = 0; row < dimension; row++) {
                int[] currentRow = new int[dimension];
                Map<Integer, Integer> rowCount = new HashMap<>();
                for (int col = 0; col < dimension; col++) {
                    int value = scanner.nextInt();
                    currentRow[col] = value;
                    rowCount.put(value, rowCount.getOrDefault(value, 0) + 1);
                    if (row == col) {
                        diagonalSum += value;
                    }
                }
                int rowMax = Collections.max(rowCount.values());
                if (rowMax > maxRowDuplicates) {
                    maxRowDuplicates = rowMax;
                }
                matrix.add(currentRow);
            }

            if (maxRowDuplicates == 1) {
                maxRowDuplicates = 0;
            }

            int maxColDuplicates = 0;

            for (int col = 0; col < dimension; col++) {
                Map<Integer, Integer> colCount = new HashMap<>();
                for (int row = 0; row < dimension; row++) {
                    int value = matrix.get(row)[col];
                    colCount.put(value, colCount.getOrDefault(value, 0) + 1);
                }
                int colMax = Collections.max(colCount.values());
                if (colMax > maxColDuplicates) {
                    maxColDuplicates = colMax;
                }
            }

            if (maxColDuplicates == 1) {
                maxColDuplicates = 0;
            }

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + maxRowDuplicates + " " + maxColDuplicates);
        }
    }
}