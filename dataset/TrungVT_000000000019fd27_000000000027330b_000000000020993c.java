import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] mat = new int[n][n];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    mat[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(solve1(new Matrix(i + 1, mat)));
        }
    }

    public static String solve1(Matrix input) {
        return "Case #"
                + input.index + ": "
                + input.sumDiag + " "
                + input.repeatedRows + " "
                + input.repeatedCols;
    }

    static class Matrix {
        int index;
        int[][] mat;
        int sumDiag;
        int repeatedRows;
        int repeatedCols;

        public Matrix(int index, int[][] mat) {
            this.index = index;
            this.mat = mat;
            int n = mat.length;
            for (int i = 0; i < n; i++) {
                assert mat[i].length == n;
                sumDiag += mat[i][i];
                boolean[] found = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (found[mat[i][j]]) {
                        repeatedRows++;
                        break;
                    }
                    found[mat[i][j]] = true;
                }
            }
            for (int j = 0; j < n; j++) {
                boolean[] found = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (found[mat[i][j]]) {
                        repeatedCols++;
                        break;
                    }
                    found[mat[i][j]] = true;
                }
            }
        }
    }
}
