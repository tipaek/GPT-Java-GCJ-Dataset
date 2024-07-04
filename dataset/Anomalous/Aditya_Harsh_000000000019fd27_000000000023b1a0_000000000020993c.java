import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] results = new int[t][4];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            results[i][0] = i + 1;
            results[i][1] = trace;

            // Check for duplicate values in columns
            int duplicateColumns = 0;
            for (int col = 0; col < n; col++) {
                Set<Integer> seen = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!seen.add(matrix[row][col])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            results[i][2] = duplicateColumns;

            // Check for duplicate values in rows
            int duplicateRows = 0;
            for (int row = 0; row < n; row++) {
                Set<Integer> seen = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!seen.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            results[i][3] = duplicateRows;
        }

        // Print the results
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + results[i][0] + ": " + results[i][1] + " " + results[i][3] + " " + results[i][2]);
        }
    }
}