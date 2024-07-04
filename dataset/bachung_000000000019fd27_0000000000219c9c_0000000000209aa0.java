import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) solve(reader, i + 1);
    }

    static void swap(int[][] grid, int col1, int col2) {
        for (int i = 0; i < grid.length; i++) {
            int temp = grid[i][col1];
            grid[i][col1] = grid[i][col2];
            grid[i][col2] = temp;
        }
    }

    static void solve(BufferedReader reader, int num) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        if (K % N == 0 && K > 0) {
            System.out.printf("Case #%d: POSSIBLE%n", num);
            int[][] grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = (j + i) % N + 1;
                }
            }
            int find = K / N;
            for (int i = 0; i < N; i++) {
                if (grid[i][i] != find) {
                    int toSwap = -1;
                    for (int j = 0; j < grid[i].length; j++) {
                        if (grid[i][j] == find) {
                            toSwap = j;
                            break;
                        }
                    }
                    swap(grid, i, toSwap);
                }
            }
            for (int row = 0; row < grid.length; row++) {
                String[] arr = new String[grid.length];
                for (int col = 0; col < grid.length; col++) {
                    arr[col] = grid[row][col] + "";
                }
                System.out.println(String.join(" ", arr));
            }
        } else {
            System.out.printf("Case #%d: IMPOSSIBLE%n", num);
        }
    }
}