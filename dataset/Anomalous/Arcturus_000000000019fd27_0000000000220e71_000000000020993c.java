import java.util.*;
import java.io.*;

public class Solution {
    public static void vestigium(int caseNum, Scanner scanner) {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        int trace = 0, duplicateRows = 0, duplicateCols = 0;

        // Read the matrix and calculate the trace and duplicate rows
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean hasDuplicateRow = false;
            for (int j = 0; j < size; j++) {
                int value = scanner.nextInt();
                matrix[i][j] = value;
                if (i == j) {
                    trace += value;
                }
                if (!rowSet.add(value)) {
                    hasDuplicateRow = true;
                }
            }
            if (hasDuplicateRow) {
                duplicateRows++;
            }
        }

        // Calculate duplicate columns
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean hasDuplicateCol = false;
            for (int i = 0; i < size; i++) {
                if (!colSet.add(matrix[i][j])) {
                    hasDuplicateCol = true;
                }
            }
            if (hasDuplicateCol) {
                duplicateCols++;
            }
        }

        System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            vestigium(i, scanner);
        }
        scanner.close();
    }
}