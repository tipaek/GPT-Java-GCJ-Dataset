import java.io.*;
import java.util.*;

public class Solution {
    public static int[] solution(int[][] matrix) {
        int n = matrix.length;
        int total = 0;
        int rowsInvalid = 0;
        int columnsInvalid = 0;

        // Calculate the trace
        for (int i = 0; i < n; i++) {
            total += matrix[i][i];
        }

        // Check rows and columns for uniqueness
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if (rowSet.size() != n) {
                rowsInvalid++;
            }
            if (colSet.size() != n) {
                columnsInvalid++;
            }
        }

        return new int[]{total, rowsInvalid, columnsInvalid};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(in.readLine().trim());

        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(in.readLine().trim());
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(in.readLine().trim());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            int[] ans = solution(matrix);
            out.write(String.format("Case #%d: %d %d %d\n", test, ans[0], ans[1], ans[2]));
        }
        out.flush();
        out.close();
    }
}