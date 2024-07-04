import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int countUniqueCols(int n, int[][] matrix) {
        int cols = 0;
        for (int i = 0; i < n; ++i) {
            Set<Integer> uniq = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                uniq.add(matrix[j][i]);
            }
            if (uniq.size() != n) {
                cols++;
            }
        }
        return cols;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][]  matrix = new int[102][102];
        for (int t = 0; t < T; ++t) {
            int trace = 0, rows = 0, cols = 0;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; ++i) {
                String[] line = br.readLine().split(" ");
                Set<Integer> uniq = new HashSet<>();
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    uniq.add(matrix[i][j]);
                }
                if (uniq.size() != n) {
                    rows++;
                }
            }
            cols = countUniqueCols(n, matrix);
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rows + " " + cols);
        }



    }
}
