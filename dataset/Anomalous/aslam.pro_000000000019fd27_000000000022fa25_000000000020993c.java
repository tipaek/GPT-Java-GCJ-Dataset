import java.util.*;
import java.io.*;

public class Solution {
    static int row = 0, col = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int x = 1; x <= T; ++x) {
            int N = in.nextInt();
            int[][] M = new int[N][N];
            int trace = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = in.nextInt();
                    if (i == j) {
                        trace += M[i][j];
                    }
                }
            }

            check(N, M);

            System.out.println("Case #" + x + ": " + trace + " " + row + " " + col);
            row = 0;
            col = 0;
        }
    }

    public static void check(int n, int[][] mat) {
        for (int i = 0; i < n; i++) {
            boolean rowDuplicate = false, colDuplicate = false;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (!rowDuplicate && mat[i][j] == mat[i][k]) {
                        row++;
                        rowDuplicate = true;
                    }
                    if (!colDuplicate && mat[j][i] == mat[k][i]) {
                        col++;
                        colDuplicate = true;
                    }
                    if (rowDuplicate && colDuplicate) {
                        break;
                    }
                }
                if (rowDuplicate && colDuplicate) {
                    break;
                }
            }
        }
    }
}