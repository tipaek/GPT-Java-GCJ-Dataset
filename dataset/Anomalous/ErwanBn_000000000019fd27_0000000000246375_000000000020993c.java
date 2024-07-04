import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numMatrices = scanner.nextInt();

        for (int i = 0; i < numMatrices; i++) {
            int dimension = scanner.nextInt();
            List<int[]> matrix = new ArrayList<>();
            int maxRowDuplicates = 0;
            int diagonalSum = 0;

            for (int row = 0; row < dimension; row++) {
                int[] currentRow = new int[dimension];
                Map<Integer, Integer> rowCount = new HashMap<>();

                for (int col = 0; col < dimension; col++) {
                    int currentValue = scanner.nextInt();
                    currentRow[col] = currentValue;

                    rowCount.put(currentValue, rowCount.getOrDefault(currentValue, 0) + 1);

                    if (row == col) {
                        diagonalSum += currentValue;
                    }
                }

                int rowMax = rowCount.values().stream().max(Integer::compare).orElse(0);
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
                    int currentValue = matrix.get(row)[col];
                    colCount.put(currentValue, colCount.getOrDefault(currentValue, 0) + 1);
                }

                int colMax = colCount.values().stream().max(Integer::compare).orElse(0);
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