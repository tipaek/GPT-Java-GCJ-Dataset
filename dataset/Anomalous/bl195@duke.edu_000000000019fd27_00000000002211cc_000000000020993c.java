import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        
        for (int i = 0; i < size; i++) {
            int n = scan.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int[][] matrix = new int[n][n];
            
            // Read matrix and calculate trace
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    matrix[x][y] = scan.nextInt();
                    if (x == y) {
                        trace += matrix[x][y];
                    }
                }
            }
            
            // Check for duplicate entries in rows
            for (int x = 0; x < n; x++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    if (!rowSet.add(matrix[x][y])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            // Check for duplicate entries in columns
            for (int y = 0; y < n; y++) {
                Set<Integer> colSet = new HashSet<>();
                for (int x = 0; x < n; x++) {
                    if (!colSet.add(matrix[x][y])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scan.close();
    }
}