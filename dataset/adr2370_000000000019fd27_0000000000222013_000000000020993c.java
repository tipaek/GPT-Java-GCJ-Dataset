package app;

import java.io.*;
import java.util.*;

class App {
    public static void main(final String[] args) throws Exception {
        final BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        final int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[N][N];
            int trace = 0;
            int dupRow = 0;
            int dupColumn = 0;
            for (int row = 0; row < N; row++) {
                st = new StringTokenizer(f.readLine());
                for (int column = 0; column < N; column++) {
                    matrix[row][column] = Integer.parseInt(st.nextToken());
                    if (row == column) {
                        trace += matrix[row][column];
                    }
                }
            }
            for (int column = 0; column < N; column++) {
                for (int row = 0; row < N; row++) {
                    boolean dup = false;
                    for (int nextRow = row + 1; nextRow < N; nextRow++) {
                        if (matrix[row][column] == matrix[nextRow][column]) {
                            dup = true;
                            break;
                        }
                    }
                    if (dup) {
                        dupRow++;
                        break;
                    }
                }
            }
            for (int column = 0; column < N; column++) {
                for (int row = 0; row < N; row++) {
                    boolean dup = false;
                    for (int nextRow = row + 1; nextRow < N; nextRow++) {
                        if (matrix[column][row] == matrix[column][nextRow]) {
                            dup = true;
                            break;
                        }
                    }
                    if (dup) {
                        dupColumn++;
                        break;
                    }
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", t + 1, trace, dupColumn, dupRow);
        }
    }
}
