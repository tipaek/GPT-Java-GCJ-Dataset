import java.io.*;
import java.util.*;

public class Vestigium {
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(scanner.nextLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int trace = calculateTrace(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateColumns(matrix, n);

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}