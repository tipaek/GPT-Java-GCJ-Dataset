import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (!rowHasDuplicate && !rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                }
                
                trace += matrix[i][i];
            }
            
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                
                for (int i = 0; i < n; i++) {
                    if (!colHasDuplicate && !colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        colHasDuplicate = true;
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}