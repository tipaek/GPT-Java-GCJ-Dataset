import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }
            int k = 0;
            for (int a = 0; a < n; a++) {
                k += matrix[a][a];
            }
            int r = 0;
            for (int row = 0; row < n; row++) {
                boolean[] existing = new boolean[n + 1];
                for (int col = 0; col < n; col++) {
                    if(existing[matrix[row][col]]) {
                        r++;
                        break;
                    }
                    existing[matrix[row][col]] = true;
                }
            }
            int c = 0;
            for (int col = 0; col < n; col++) {
                boolean[] existing = new boolean[n + 1];
                for (int row = 0; row < n; row++) {
                    if(existing[matrix[row][col]]) {
                        c++;
                        break;
                    }
                    existing[matrix[row][col]] = true;
                }
            }
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}