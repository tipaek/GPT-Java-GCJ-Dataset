import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int k = 0, r = 0, c = 0;
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                int[] row = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    int v = sc.nextInt();
                    if (i == j) {
                        k += v;
                    }
                    if (row[v] > 0 && r <= i) {
                        r++;
                    }
                    row[v] = v;
                    arr[i][j] = v;
                }
            }

            for (int i = 0; i < n; i++) {
                int[] col = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    int v = arr[j][i];
                    if (col[v] > 0 && c <= i) {
                        c++;
                        break;
                    }
                    col[v] = v;
                }
            }
            
            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }
}