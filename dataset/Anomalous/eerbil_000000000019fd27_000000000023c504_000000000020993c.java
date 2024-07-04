import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numCases = scanner.nextInt();
        int[] sums = new int[numCases];
        int[] rows = new int[numCases];
        int[] cols = new int[numCases];

        for (int i = 0; i < numCases; i++) {
            int numRows = scanner.nextInt();
            int[][] rowCounts = new int[numRows][numRows];
            int[][] colCounts = new int[numRows][numRows];
            HashMap<Integer, Boolean> duplicateRows = new HashMap<>();
            HashMap<Integer, Boolean> duplicateCols = new HashMap<>();
            int diagonalSum = 0;

            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numRows; col++) {
                    int value = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += value;
                    }
                    rowCounts[row][value - 1]++;
                    colCounts[col][value - 1]++;
                    
                    if (rowCounts[row][value - 1] > 1 && !duplicateRows.containsKey(row)) {
                        duplicateRows.put(row, true);
                    }
                    if (colCounts[col][value - 1] > 1 && !duplicateCols.containsKey(col)) {
                        duplicateCols.put(col, true);
                    }
                }
            }

            sums[i] = diagonalSum;
            rows[i] = duplicateRows.size();
            cols[i] = duplicateCols.size();
        }

        scanner.close();

        for (int i = 0; i < numCases; i++) {
            System.out.println(sums[i] + " " + rows[i] + " " + cols[i]);
        }
    }
}