import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for row duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
    }
}