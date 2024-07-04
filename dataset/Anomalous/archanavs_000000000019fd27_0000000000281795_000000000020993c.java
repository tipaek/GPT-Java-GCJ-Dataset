package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        matrix[row][col] = scanner.nextInt();
                    }
                }
                processCase(t, size, matrix);
            }
        }
    }

    private static void processCase(int caseNumber, int size, int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < size; i++) {
            HashSet<Integer> rowValues = new HashSet<>();
            HashSet<Integer> columnValues = new HashSet<>();

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                rowValues.add(matrix[i][j]);
                columnValues.add(matrix[j][i]);
            }

            if (rowValues.size() != size) {
                duplicateRows++;
            }
            if (columnValues.size() != size) {
                duplicateColumns++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}