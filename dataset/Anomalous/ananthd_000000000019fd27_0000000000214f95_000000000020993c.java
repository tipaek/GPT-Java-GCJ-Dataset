import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int[][] matrix = new int[100][100];

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            int size = scanner.nextInt();

            for (int row = 0; row < size; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();
                    if (!rowHasDuplicate && rowSet.contains(value)) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                    }
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                    rowSet.add(value);
                }
            }

            for (int col = 0; col < size; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < size; row++) {
                    int value = matrix[row][col];
                    if (colSet.contains(value)) {
                        duplicateCols++;
                        break;
                    }
                    colSet.add(value);
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}