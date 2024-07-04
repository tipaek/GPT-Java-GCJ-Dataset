import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            
            // Calculating trace and checking for repeated rows and columns
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> columnSet = new HashSet<>();
                
                boolean rowHasDuplicates = false;
                boolean columnHasDuplicates = false;
                
                for (int j = 0; j < n; j++) {
                    // Check for duplicates in the row
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicates = true;
                    }
                    // Check for duplicates in the column
                    if (!columnSet.add(matrix[j][i])) {
                        columnHasDuplicates = true;
                    }
                }
                
                if (rowHasDuplicates) {
                    repeatedRows++;
                }
                if (columnHasDuplicates) {
                    repeatedColumns++;
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
        
        scanner.close();
    }
}