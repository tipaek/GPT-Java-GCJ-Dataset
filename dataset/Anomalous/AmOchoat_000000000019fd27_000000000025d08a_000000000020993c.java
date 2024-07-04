import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringBuilder result = new StringBuilder();
            int cases = Integer.parseInt(reader.readLine().trim());
            
            for (int caseIndex = 1; caseIndex <= cases; caseIndex++) {
                int n = Integer.parseInt(reader.readLine().trim());
                int[][] matrix = new int[n][n];
                
                for (int row = 0; row < n; row++) {
                    String[] rowData = reader.readLine().trim().split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(rowData[col]);
                    }
                }
                
                int diagonalSum = 0;
                for (int i = 0; i < n; i++) {
                    diagonalSum += matrix[i][i];
                }
                
                int duplicateRows = 0;
                for (int row = 0; row < n; row++) {
                    if (hasDuplicates(matrix[row])) {
                        duplicateRows++;
                    }
                }
                
                int duplicateCols = 0;
                for (int col = 0; col < n; col++) {
                    if (hasDuplicates(getColumn(matrix, col))) {
                        duplicateCols++;
                    }
                }
                
                result.append(String.format("Case #%d: %d %d %d%n", caseIndex, diagonalSum, duplicateCols, duplicateRows));
            }
            
            System.out.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }
}