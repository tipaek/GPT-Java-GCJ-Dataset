import java.util.Scanner;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        PrintWriter writer = new PrintWriter(System.out);

        for (int tn = 1; tn <= t; tn++) {
            int n = scan.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[n][n];

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Checking for row repetitions
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
            }

            // Checking for column repetitions
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i]]) {
                        colRepeats++;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
            }

            // Preparing the output
            String output = "Case #" + tn + ": " + trace + " " + rowRepeats + " " + colRepeats;
            writer.println(output);
        }

        writer.flush();
        writer.close();
        scan.close();
    }
}