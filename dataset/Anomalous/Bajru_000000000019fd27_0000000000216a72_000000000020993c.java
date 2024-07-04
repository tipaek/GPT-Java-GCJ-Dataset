import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[][] mat = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k] = scan.nextInt();
                }
            }
            solve(mat, n, i + 1); // Passing i + 1 to match the case number starting from 1
        }
    }

    private static void solve(int[][] mat, int n, int t) {
        int trace = 0;

        // Calculate the trace of the matrix
        for (int i = 0; i < n; i++) {
            trace += mat[i][i];
        }

        int rowRepeats = 0;
        int colRepeats = 0;

        // Check for repeated elements in rows and columns
        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[101];
            boolean[] colCheck = new boolean[101];
            boolean rowFlag = false;
            boolean colFlag = false;

            for (int j = 0; j < n; j++) {
                if (rowCheck[mat[i][j]]) {
                    rowFlag = true;
                } else {
                    rowCheck[mat[i][j]] = true;
                }

                if (colCheck[mat[j][i]]) {
                    colFlag = true;
                } else {
                    colCheck[mat[j][i]] = true;
                }
            }

            if (rowFlag) {
                rowRepeats++;
            }
            if (colFlag) {
                colRepeats++;
            }
        }

        System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}