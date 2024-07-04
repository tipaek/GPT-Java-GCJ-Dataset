import java.util.Scanner;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int tn = 1; tn <= t; tn++) {
            int n = scan.nextInt();
            int k = 0, r = 0, c = 0;
            int[][] nums = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = scan.nextInt();
                }
            }

            // Calculate the trace
            for (int i = 0; i < n; i++) {
                k += nums[i][i];
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[nums[i][j]]) {
                        r++;
                        break;
                    }
                    seen[nums[i][j]] = true;
                }
            }

            // Check for duplicate elements in columns
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[nums[j][i]]) {
                        c++;
                        break;
                    }
                    seen[nums[j][i]] = true;
                }
            }

            // Output the result
            String output = "Case #" + tn + ": " + k + " " + r + " " + c;
            PrintWriter writer = new PrintWriter(System.out);
            writer.println(output);
            writer.flush();
        }
    }
}