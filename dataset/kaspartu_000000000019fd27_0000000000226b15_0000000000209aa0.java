import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        int tc = 0;

        while (++tc <= T) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] grid = new int[N][N];
            grid = generateLatinSquare(N, K, 0);
            if (grid.length == 0) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + tc + ": POSSIBLE");
                for (int[] r: grid) {
                    for (int i: r) System.out.print(i + " ");
                    System.out.println("");
                }
            }
        }
    }

    public static int[][] generateLatinSquare(int n, int k, int start) {
        if (start >= n) {
            return new int[0][0];
        }
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j]=((i + 1 + start) + j) % n;
                if (grid[i][j] == 0) grid[i][j] = n;
            }
        }
        if (sumDiag(grid) != k) generateLatinSquare(n, k, start + 1);
        else
            return grid;
        return new int[0][0];
    }

    public static int sumDiag(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            res += grid[i][i];
        }
        return res;
    }
}