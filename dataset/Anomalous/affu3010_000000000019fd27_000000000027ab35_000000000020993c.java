import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += mat[i][i];
            }

            // Counting rows with repeated elements
            int rowRepeats = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[mat[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[mat[i][j]] = true;
                }
            }

            // Counting columns with repeated elements
            int colRepeats = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[mat[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    seen[mat[i][j]] = true;
                }
            }

            // Printing the result
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        sc.close();
    }
}