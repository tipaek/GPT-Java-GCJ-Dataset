import java.util.Scanner;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int tn = 1; tn <= t; tn++) {
            int n = scan.nextInt();
            int k = 0, r = 0, c = 0;
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                k += matrix[i][i];
            }

            // Calculate the number of rows with repeated elements
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        r++;
                        hasDuplicate = true;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Calculate the number of columns with repeated elements
            for (int i = 0; i < n; i++) {
                boolean hasDuplicate = false;
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i]]) {
                        c++;
                        hasDuplicate = true;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
            }

            // Print the result for the current test case
            String output = "Case #" + tn + ": " + k + " " + r + " " + c;
            try (PrintWriter writer = new PrintWriter(System.out)) {
                writer.println(output);
                writer.flush();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}