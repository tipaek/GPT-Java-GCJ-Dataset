import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Vestigium {
    public static void main(String[] args) throws FileNotFoundException {
        File text = new File("test.txt");
        Scanner in = new Scanner(text);
        int testCases = in.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];

            // Reading the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int rowDuplicates = countRowDuplicates(matrix, size);
            int colDuplicates = countColumnDuplicates(matrix, size);

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, rowDuplicates, colDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                colSet.add(matrix[i][j]);
            }
            if (colSet.size() != size) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }
}