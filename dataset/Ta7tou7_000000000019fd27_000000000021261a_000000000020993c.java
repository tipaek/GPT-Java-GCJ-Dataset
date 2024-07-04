import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n  = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            solve(i+1, n, matrix);
        }
    }

    private static void solve(int x, int n, int[][] matrix) {
        boolean[] found = new boolean[n];
        int r = 0, c = 0, k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int current = matrix[i][j];
                if(found[current-1]) {
                    r++;
                    break;
                }
                found[current-1]= true;
            }
            Arrays.fill(found, false);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int current = matrix[j][i];
                if(found[current-1]) {
                    c++;
                    break;
                }
                found[current-1]= true;
            }
            Arrays.fill(found, false);
        }

        for (int i = 0; i < n; i++) {
            k += matrix[i][i];
        }
        System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
    }
}
