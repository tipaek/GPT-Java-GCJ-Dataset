import java.util.*;
import java.io.*;

public class Solution
{
          
    public static String solve(int n, int[][] matrix) {
        int k = 0, r = 0, c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    k = k + matrix[i][j];
                }

            }
        }
        for (int i = 0; i < n; i++) {
            outer: for (int j = 0; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    if (l != j && matrix[i][l] == matrix[i][j]) {
                        r++;
                        break outer;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            outer: for (int j = 0; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    if (l != j && matrix[l][i] == matrix[j][i]) {
                        c++;
                        break outer;
                    }
                }
            }
        }
        return (k + " " + r + " " + c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            
            int n = in.nextInt();
            int matrix[][] = new int[n][];
            for (int j = 0; j < n; j++) {
                matrix[j] = new int[n];
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + solve(n, matrix));
        }
    }
}