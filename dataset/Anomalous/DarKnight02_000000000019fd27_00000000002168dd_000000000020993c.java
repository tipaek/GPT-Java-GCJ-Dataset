import java.util.*;
import java.io.*;

public class Solution {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static boolean areDistinct(Integer[] arr) {
        return new HashSet<>(Arrays.asList(arr)).size() == arr.length;
    }

    private static int countIdenticalRows(Integer[][] mat) {
        int count = 0;
        for (Integer[] row : mat) {
            if (!areDistinct(row)) {
                count++;
            }
        }
        return count;
    }

    private static Integer[][] rotateMatrix(int N, Integer[][] mat) {
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[y][N - 1 - x];
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
                mat[N - 1 - y][x] = temp;
            }
        }
        return mat;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(nextToken());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(nextToken());
            Integer[][] grid = new Integer[N][N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(nextToken());
                    grid[i][j] = num;
                    if (i == j) {
                        sum += num;
                    }
                }
            }
            int r = countIdenticalRows(grid);
            int c = countIdenticalRows(rotateMatrix(N, grid));
            System.out.println("Case #" + t + ": " + sum + " " + r + " " + c);
        }
    }

    private static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}