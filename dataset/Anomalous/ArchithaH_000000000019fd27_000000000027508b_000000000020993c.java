import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            // Check for duplicate rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate columns
            for (int i = 0; i < n; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            // Calculate diagonal sum
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            // Print the results
            System.out.println("Case #" + t + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }

        scan.close();
    }
}