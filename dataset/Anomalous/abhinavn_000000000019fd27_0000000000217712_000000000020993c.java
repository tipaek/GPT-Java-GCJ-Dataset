import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0, numRows = 0, numCols = 0;

            boolean[] rowFlags = new boolean[N];
            boolean[] colFlags = new boolean[N];

            for (int r = 0; r < N; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < N; c++) {
                    int value = in.nextInt();
                    matrix[r][c] = value;

                    if (r == c) {
                        trace += value;
                    }

                    if (!rowSet.add(value)) {
                        if (!rowFlags[r]) {
                            numRows++;
                            rowFlags[r] = true;
                        }
                    }
                }
            }

            for (int c = 0; c < N; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < N; r++) {
                    if (!colSet.add(matrix[r][c])) {
                        if (!colFlags[c]) {
                            numCols++;
                            colFlags[c] = true;
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + numRows + " " + numCols);
        }
    }
}