import java.util.*;
import java.io.*;
public class Solution {
    public static int[][] matrix;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            matrix = new int[n][n];

            if(solve(n, k)) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int j = 0; j < matrix.length; j++) {
                    for (int l = 0; l < matrix[0].length; l++) {
                        System.out.print(matrix[j][l] + " ");
                    }
                    System.out.print("\n");
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }

        }
    }

    public static boolean solve(int n, int k) {
        return solve(n, k, 0, 0);
    }

    public static boolean solve(int n, int k, int row, int col) {
        if(row > n - 1) {
            return isValid(k);
        }
        for(int i = 1; i <= n; i++) {
            if(natural(i, row, col)) {
                matrix[row][col] = i;
                if(solve(n, k, col < n - 1 ? row : row + 1, col < n - 1 ? col + 1 : 0)) {
                    return isValid(k);
                }
            }
        }
        matrix[row][col] = 0;
        return false;
    }

    public static boolean natural(int num, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            if(num == matrix[i][col] || num == matrix[row][i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(int k) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum == k;
    }
}