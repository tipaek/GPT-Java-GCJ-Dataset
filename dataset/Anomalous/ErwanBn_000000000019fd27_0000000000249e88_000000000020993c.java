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
            int totalDuplicateRows = 0;

            for (int row = 0; row < dimension; row++) {
                int[] rowData = new int[dimension];
                Map<Integer, Integer> rowCounts = new HashMap<>();
                boolean hasDuplicate = false;

                for (int col = 0; col < dimension; col++) {
                    int value = scanner.nextInt();
                    rowData[col] = value;
                    rowCounts.put(value, rowCounts.getOrDefault(value, 0) + 1);

                    if (rowCounts.get(value) > 1) {
                        hasDuplicate = true;
                    }

                    if (row == col) {
                        diagonalSum += value;
                    }
                }

                if (hasDuplicate) {
                    totalDuplicateRows++;
                }

                matrix.add(rowData);
            }

            int totalDuplicateColumns = 0;

            for (int col = 0; col < dimension; col++) {
                Map<Integer, Integer> colCounts = new HashMap<>();
                boolean hasDuplicate = false;

                for (int row = 0; row < dimension; row++) {
                    int value = matrix.get(row)[col];
                    colCounts.put(value, colCounts.getOrDefault(value, 0) + 1);

                    if (colCounts.get(value) > 1) {
                        hasDuplicate = true;
                    }
                }

                if (hasDuplicate) {
                    totalDuplicateColumns++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + totalDuplicateRows + " " + totalDuplicateColumns);
        }

        scanner.close();
    }
}