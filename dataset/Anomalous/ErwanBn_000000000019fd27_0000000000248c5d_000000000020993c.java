import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfMatrices = scanner.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            int dimension = scanner.nextInt();
            List<int[]> matrix = new ArrayList<>();
            int maxRowCount = 0;
            int diagonalSum = 0;

            for (int row = 0; row < dimension; row++) {
                int[] rowData = new int[dimension];
                Map<Integer, Integer> rowCount = new HashMap<>();

                for (int col = 0; col < dimension; col++) {
                    int value = scanner.nextInt();
                    rowData[col] = value;
                    rowCount.put(value, rowCount.getOrDefault(value, 0) + 1);
                    if (row == col) {
                        diagonalSum += value;
                    }
                }

                int currentMaxRowCount = rowCount.values().stream().max(Integer::compare).orElse(0);
                if (currentMaxRowCount > maxRowCount) {
                    maxRowCount = currentMaxRowCount;
                }
                matrix.add(rowData);
            }

            if (maxRowCount == 1) {
                maxRowCount = 0;
            }

            int maxColCount = 0;

            for (int col = 0; col < dimension; col++) {
                Map<Integer, Integer> colCount = new HashMap<>();

                for (int row = 0; row < dimension; row++) {
                    int value = matrix.get(row)[col];
                    colCount.put(value, colCount.getOrDefault(value, 0) + 1);
                }

                int currentMaxColCount = colCount.values().stream().max(Integer::compare).orElse(0);
                if (currentMaxColCount > maxColCount) {
                    maxColCount = currentMaxColCount;
                }
            }

            if (maxColCount == 1) {
                maxColCount = 0;
            }

            if (i != 0) {
                System.out.print("\n");
            }
            System.out.print("Case #" + (i + 1) + ": " + diagonalSum + " " + maxRowCount + " " + maxColCount);
        }
    }
}