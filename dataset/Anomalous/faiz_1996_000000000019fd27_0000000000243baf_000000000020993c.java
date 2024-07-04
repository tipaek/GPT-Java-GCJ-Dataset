import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<Matrix> matrices = new ArrayList<>(testCases);

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            matrices.add(new Matrix(size, matrix));
        }
        scanner.close();

        for (int i = 0; i < matrices.size(); i++) {
            Matrix matrix = matrices.get(i);
            System.out.printf("Case #%d: %d %d %d%n", i + 1, calculateTrace(matrix), countRowDuplicates(matrix), countColumnDuplicates(matrix));
        }
    }

    private static int calculateTrace(Matrix matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.size; i++) {
            trace += matrix.values[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(Matrix matrix) {
        int duplicateCount = 0;
        for (int i = 0; i < matrix.size; i++) {
            Set<Integer> uniqueValues = new HashSet<>();
            for (int j = 0; j < matrix.size; j++) {
                uniqueValues.add(matrix.values[i][j]);
            }
            if (uniqueValues.size() < matrix.size) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countColumnDuplicates(Matrix matrix) {
        int duplicateCount = 0;
        for (int j = 0; j < matrix.size; j++) {
            Set<Integer> uniqueValues = new HashSet<>();
            for (int i = 0; i < matrix.size; i++) {
                uniqueValues.add(matrix.values[i][j]);
            }
            if (uniqueValues.size() < matrix.size) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static class Matrix {
        int size;
        int[][] values;

        Matrix(int size, int[][] values) {
            this.size = size;
            this.values = values;
        }
    }
}