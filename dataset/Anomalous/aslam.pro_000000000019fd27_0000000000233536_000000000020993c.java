import java.util.*;
import java.io.*;

public class Solution {
    static int row = 0, col = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int x = 1; x <= T; ++x) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            checkDuplicates(N, matrix);

            System.out.println("Case #" + x + ": " + trace + " " + row + " " + col);
            row = 0;
            col = 0;
        }
    }

    public static void checkDuplicates(int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            boolean rowDuplicate = false, colDuplicate = false;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (!rowDuplicate && matrix[i][j] == matrix[i][k]) {
                        row++;
                        rowDuplicate = true;
                    }

                    if (!colDuplicate && matrix[j][i] == matrix[k][i]) {
                        col++;
                        colDuplicate = true;
                    }
                }
            }
        }
    }
}