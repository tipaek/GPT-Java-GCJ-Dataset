import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for row and column repeats
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    // Check row
                    if (!rowSet.add(matrix[i][j])) {
                        rowRepeats++;
                        break;
                    }
                    // Check column
                    if (!colSet.add(matrix[j][i])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + p + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        sc.close();
    }
}