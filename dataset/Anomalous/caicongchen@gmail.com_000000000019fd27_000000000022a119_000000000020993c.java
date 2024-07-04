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
            int rowRepeats = 0;
            int columnRepeats = 0;

            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    rowSet.add(value);
                    if (row == col) {
                        trace += value;
                    }
                }
                if (rowSet.size() != matrixSize) {
                    rowRepeats++;
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != matrixSize) {
                    columnRepeats++;
                }
            }

            results.add(String.format("Case #%d: %d %d %d", t, trace, rowRepeats, columnRepeats));
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}