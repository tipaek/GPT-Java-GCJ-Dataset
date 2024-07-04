import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int caseNum = 1; caseNum <= n; caseNum++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int rowsWithDuplicates = countRowsWithDuplicates(matrix, size);
            int columnsWithDuplicates = countColumnsWithDuplicates(matrix, size);

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowsWithDuplicates + " " + columnsWithDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowsWithDuplicates(int[][] matrix, int size) {
        int rowsWithDuplicates = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                rowsWithDuplicates++;
            }
        }
        return rowsWithDuplicates;
    }

    private static int countColumnsWithDuplicates(int[][] matrix, int size) {
        int columnsWithDuplicates = 0;
        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                columnsWithDuplicates++;
            }
        }
        return columnsWithDuplicates;
    }

    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}