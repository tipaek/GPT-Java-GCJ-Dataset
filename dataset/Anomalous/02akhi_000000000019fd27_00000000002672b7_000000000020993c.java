import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int v = 1; v <= t; v++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(row[j]);
                    matrix[i][j] = value;

                    if (i == j) {
                        trace += value;
                    }

                    if (!rowSet.add(value)) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            bw.write(String.format("Case #%d: %d %d %d%n", v, trace, rowRepeats, colRepeats));
        }

        bw.flush();
    }
}