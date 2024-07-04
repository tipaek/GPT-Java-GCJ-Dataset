import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public String solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        // Calculate the trace
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int i = 0; i < n; i++) {
            Set<Integer> uniqueRowValues = new HashSet<>();
            for (int j = 0; j < n; j++) {
                uniqueRowValues.add(matrix[i][j]);
            }
            if (uniqueRowValues.size() < n) {
                rowDuplicates++;
            }
        }

        // Check for duplicate values in columns
        for (int j = 0; j < n; j++) {
            Set<Integer> uniqueColValues = new HashSet<>();
            for (int i = 0; i < n; i++) {
                uniqueColValues.add(matrix[i][j]);
            }
            if (uniqueColValues.size() < n) {
                colDuplicates++;
            }
        }
        
        return trace + " " + rowDuplicates + " " + colDuplicates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Solution solution = new Solution();
        
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solution.solve(scanner));
        }
    }
}