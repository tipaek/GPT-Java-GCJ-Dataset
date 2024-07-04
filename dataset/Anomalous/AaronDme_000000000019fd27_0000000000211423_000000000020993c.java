import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine().trim());
        
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(input.readLine().trim());
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                String[] row = input.readLine().trim().split(" ");
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }
            
            int trace = calculateTrace(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateCols(matrix, n);
            
            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
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
            boolean[] isPresent = new boolean[size];
            for (int j = 0; j < size; j++) {
                int value = matrix[i][j] - 1;
                if (isPresent[value]) {
                    duplicateRows++;
                    break;
                }
                isPresent[value] = true;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int i = 0; i < size; i++) {
            boolean[] isPresent = new boolean[size];
            for (int j = 0; j < size; j++) {
                int value = matrix[j][i] - 1;
                if (isPresent[value]) {
                    duplicateCols++;
                    break;
                }
                isPresent[value] = true;
            }
        }
        return duplicateCols;
    }
}