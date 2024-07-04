import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = in.nextInt();
                }
            }
            String sol = solve(matrix);
            System.out.println("Case #" + x + ": " + sol.charAt(0) + " " + sol.charAt(1) + " " + sol.charAt(2));
        }
    }

    private static String solve(int[][] input) {
        int n = input.length;
        int col = 0;
        int row = 0;
        int trace = 0;

        for (int i = 0; i < n; i++) {
            trace += input[i][i];
            for (int j = 0; j < n; j++) {
                // Check for duplicate values in the current row
                for (int k = j + 1; k < n; k++) {
                    if (input[i][j] == input[i][k]) {
                        row++;
                        break;
                    }
                }
                // Check for duplicate values in the current column
                for (int k = i + 1; k < n; k++) {
                    if (input[j][i] == input[j][k]) {
                        col++;
                        break;
                    }
                }
            }
        }

        return trace + "" + row + "" + col;
    }
}