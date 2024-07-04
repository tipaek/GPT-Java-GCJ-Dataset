import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int k = 0;
            for (int i = 0; i < N; i++) {
                k += matrix[i][i];
            }

            int r = 0;
            for (int i = 0; i < N; i++) {
                boolean[] check = new boolean[N+1];
                for (int j = 0; j < N; j++) {
                    if (check[matrix[i][j]]) {
                        r++;
                        break;
                    }
                    check[matrix[i][j]] = true;
                }
            }

            int c = 0;
            for (int j = 0; j < N; j++) {
                boolean[] check = new boolean[N+1];
                for (int i = 0; i < N; i++) {
                    if (check[matrix[i][j]]) {
                        c++;
                        break;
                    }
                    check[matrix[i][j]] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t, k, r, c);
        }
    }
}
