import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        int[][] results = new int[t][3];

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Read matrix input
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scan.nextInt();
                }
            }

            // Calculate trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            // Calculate row duplicates
            for (int row = 0; row < n; row++) {
                Set<Integer> seen = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    if (!seen.add(matrix[row][col])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Calculate column duplicates
            for (int col = 0; col < n; col++) {
                Set<Integer> seen = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    if (!seen.add(matrix[row][col])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Store results
            results[i][0] = trace;
            results[i][1] = rowDuplicates;
            results[i][2] = colDuplicates;
        }

        // Print results
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i][0] + " " + results[i][1] + " " + results[i][2]);
        }
    }
}