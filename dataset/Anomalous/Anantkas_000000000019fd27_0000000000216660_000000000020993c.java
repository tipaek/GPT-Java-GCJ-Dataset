import java.util.*;
import java.io.*;

public class Solution {

    private static String calculateMatrixProperties(int[][] matrix, int size) {
        int[] rowDuplicates = new int[size];
        int[] columnDuplicates = new int[size];
        int diagonalSum = 0;

        List<Map<Integer, Integer>> rowMaps = new ArrayList<>();
        List<Map<Integer, Integer>> columnMaps = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            rowMaps.add(new HashMap<>());
            columnMaps.add(new HashMap<>());
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = matrix[i][j];

                if (i == j) {
                    diagonalSum += value;
                }

                if (rowDuplicates[i] == 0) {
                    if (rowMaps.get(i).containsKey(value)) {
                        rowDuplicates[i] = 1;
                    } else {
                        rowMaps.get(i).put(value, 1);
                    }
                }

                if (columnDuplicates[j] == 0) {
                    if (columnMaps.get(j).containsKey(value)) {
                        columnDuplicates[j] = 1;
                    } else {
                        columnMaps.get(j).put(value, 1);
                    }
                }
            }
        }

        int totalRowDuplicates = Arrays.stream(rowDuplicates).sum();
        int totalColumnDuplicates = Arrays.stream(columnDuplicates).sum();

        return diagonalSum + " " + totalRowDuplicates + " " + totalColumnDuplicates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.println("Case #" + testCase + ": " + calculateMatrixProperties(matrix, size));
        }
    }
}