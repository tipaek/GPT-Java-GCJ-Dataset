import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            System.out.print("Case #" + caseNumber++ + ": ");
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            
            // Calculating the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Checking for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                long uniqueCount = Arrays.stream(matrix[i]).distinct().count();
                if (uniqueCount != n) {
                    duplicateRows++;
                }
            }
            
            // Checking for duplicate elements in columns
            for (int i = 0; i < n; i++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    columnSet.add(matrix[j][i]);
                }
                if (columnSet.size() != n) {
                    duplicateCols++;
                }
            }
            
            // Printing the result
            System.out.println(trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}