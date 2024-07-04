import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            
            // Reading matrix and calculating trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            // Checking for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowElements = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowElements.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            
            // Checking for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> columnElements = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!columnElements.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}