import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int x = in.nextInt();
                    matrix[r][c] = x;
                    if (r == c) trace += x;
                }
            }
            int sum = N * (N + 1) / 2;
            int repeatElementRows = 0, repeatElementCols = 0;
            for (int r = 0; r < N; r++) {
                boolean[] visited = new boolean[N];
                for (int c = 0; c < N; c++) {
                    if (visited[matrix[r][c]-1]) {
                        repeatElementRows++;
                        break;
                    }
                    visited[matrix[r][c]-1] = true;
                }
            }
            for (int c = 0; c < N; c++) {
                boolean[] visited = new boolean[N];
                for (int r = 0; r < N; r++) {
                    if (visited[matrix[r][c]-1]) {
                        repeatElementCols++;
                        break;
                    }
                    visited[matrix[r][c]-1] = true;
                }
            }
            System.out.println("Case #" + tc + ": " + trace + " " + repeatElementRows + " " + repeatElementCols);
        }
    }
}