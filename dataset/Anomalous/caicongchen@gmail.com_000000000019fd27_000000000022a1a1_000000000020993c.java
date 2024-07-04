import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        List<String> results = new ArrayList<>();
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                    rowSet.add(value);
                }
                if (rowSet.size() < matrixSize) {
                    rowDuplicates++;
                }
            }

            columnDuplicates = countColumnDuplicates(matrix);

            results.add(String.format("Case #%d: %d %d %d", t, trace, rowDuplicates, columnDuplicates));
        }

        results.forEach(System.out::println);
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int columnDuplicates = 0;
        int size = matrix.length;

        for (int col = 0; col < size; col++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int row = 0; row < size; row++) {
                columnSet.add(matrix[row][col]);
            }
            if (columnSet.size() < size) {
                columnDuplicates++;
            }
        }

        return columnDuplicates;
    }
}