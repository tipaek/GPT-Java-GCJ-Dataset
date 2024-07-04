import java.util.*;
import java.io.*;

class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = readMatrix(scanner, n);
            int[] rowSums = new int[n];
            int[] colSums = new int[n];
            int trace = calculateTrace(matrix, n, rowSums, colSums);
            
            int expectedSum = calculateExpectedSum(n);
            int duplicateRows = countDuplicates(rowSums, expectedSum, n);
            int duplicateCols = countDuplicates(colSums, expectedSum, n);
            
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
    
    private static int[][] readMatrix(Scanner scanner, int n) {
        int[][] matrix = new int[n][n];
        scanner.nextLine(); // Consume the remaining newline
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }
    
    private static int calculateTrace(int[][] matrix, int n, int[] rowSums, int[] colSums) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
            rowSums[i] = rowSet.size();
            colSums[i] = colSet.size();
        }
        return trace;
    }
    
    private static int calculateExpectedSum(int n) {
        return n;
    }
    
    private static int countDuplicates(int[] sums, int expectedSum, int n) {
        int duplicates = 0;
        for (int i = 0; i < n; i++) {
            if (sums[i] != expectedSum) {
                duplicates++;
            }
        }
        return duplicates;
    }
}