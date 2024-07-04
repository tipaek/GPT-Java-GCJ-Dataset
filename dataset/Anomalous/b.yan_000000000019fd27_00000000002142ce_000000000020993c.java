import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            // Reading the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }
            
            // Count rows with duplicate elements
            int duplicateRows = 0;
            for (int i = 0; i < size; i++) {
                boolean[] seen = new boolean[size];
                boolean hasDuplicate = false;
                for (int j = 0; j < size; j++) {
                    if (seen[matrix[i][j] - 1]) {
                        hasDuplicate = true;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }
            
            // Count columns with duplicate elements
            int duplicateColumns = 0;
            for (int j = 0; j < size; j++) {
                boolean[] seen = new boolean[size];
                boolean hasDuplicate = false;
                for (int i = 0; i < size; i++) {
                    if (seen[matrix[i][j] - 1]) {
                        hasDuplicate = true;
                        break;
                    }
                    seen[matrix[i][j] - 1] = true;
                }
                if (hasDuplicate) {
                    duplicateColumns++;
                }
            }
            
            // Print the result for the current test case
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}