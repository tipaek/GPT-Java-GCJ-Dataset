import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateCols = countDuplicateCols(matrix, size);
            
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        boolean[] seen = new boolean[size + 1];
        
        for (int i = 0; i < size; i++) {
            Arrays.fill(seen, false);
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    duplicateRows++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateCols = 0;
        boolean[] seen = new boolean[size + 1];
        
        for (int j = 0; j < size; j++) {
            Arrays.fill(seen, false);
            for (int i = 0; i < size; i++) {
                if (seen[matrix[i][j]]) {
                    duplicateCols++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        
        return duplicateCols;
    }
}