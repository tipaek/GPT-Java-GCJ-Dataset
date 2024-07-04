import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, duplicateRows = 0, duplicateColumns = 0;
            
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateRow = false;
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    if (row == col) {
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
            
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicateCol = false;
                for (int row = 0; row < n; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        hasDuplicateCol = true;
                    }
                }
                if (hasDuplicateCol) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}