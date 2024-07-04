import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int t = 1 ; t <= T; t++) {
            int N = scan.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }
            int trace = trace(N, matrix);
            int row = row(N, matrix);
            int column = column(N, matrix);
            System.out.printf("Case #%d: %d %d %d\n", t, trace, row, column);
        }
    }
    private int trace(int N, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    private int row(int N, int[][] matrix) {
        int row = 0;
        for (int i = 0; i < N; i++) {
            int[] counter = new int[N+1];
            for (int j = 0; j < N; j++) {
                counter[matrix[i][j]] += 1;
            }
            for (int k = 1; k <= N; k++) {
                if (1 < counter[k]) {
                    row += 1;
                    break;
                }
            }
        }
        return row;
    }
    private int column(int N, int[][] matrix) {
        int column = 0;
        for (int j = 0; j < N; j++) {
            int[] counter = new int[N+1];
            for (int i = 0; i < N; i++) {
                counter[matrix[i][j]] += 1;
            }
            for (int k = 1; k <= N; k++) {
                if (1 < counter[k]) {
                    column += 1;
                    break;
                }
            }
        }
        return column;
    }
}
