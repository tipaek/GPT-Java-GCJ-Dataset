import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine().trim());
        
        for (int caseNum = 0; caseNum < t; caseNum++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
            
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            // Calculate the trace of the matrix
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + (caseNum + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}