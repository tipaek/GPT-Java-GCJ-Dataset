import java.util.*;
import java.io.*;

public class Vestigium {

    public static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countNonUniqueRows(int[][] matrix, int size) {
        int nonUniqueRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() < size) {
                nonUniqueRows++;
            }
        }
        return nonUniqueRows;
    }

    public static int countNonUniqueColumns(int[][] matrix, int size) {
        int nonUniqueColumns = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() < size) {
                nonUniqueColumns++;
            }
        }
        return nonUniqueColumns;
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

            int trace = calculateTrace(matrix, size);
            int nonUniqueRows = countNonUniqueRows(matrix, size);
            int nonUniqueColumns = countNonUniqueColumns(matrix, size);

            System.out.println("Case #" + testCase + ": " + trace + " " + nonUniqueRows + " " + nonUniqueColumns);
        }
    }
}