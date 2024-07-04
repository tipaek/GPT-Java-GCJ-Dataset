import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
            
            String[][] matrix = new String[n][n];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().split(" ");
                matrix[i] = row;
                trace += Integer.parseInt(row[i]);
            }
            
            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                HashSet<String> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                HashSet<String> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}