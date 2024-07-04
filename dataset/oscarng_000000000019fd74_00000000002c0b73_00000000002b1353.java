import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Pascal Walk
public class Solution {
    final static int N = 51;
    static int[][] matrix = init(N);

    public static List<int[]> solve(int n) {
        boolean[][] visited = new boolean[N][N];
        List<int[]> path = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}, {-1,-1}, {1,1}};

        helper(visited, path, n, 0, 1, 1, dirs, ans);

        return ans;
    }

    private static void helper(boolean[][] visited, List<int[]> path, int n, int sum, int r, int c, int[][] dirs,List<int[]> ans) {
        if (path.size() > 500 || sum > n || r < 1 || r >= N || c < 1 || c > r || visited[r][c] || !ans.isEmpty()) {
            return;
        }

        if (sum == n) {
            ans.addAll(path);
            return;
        }

        visited[r][c] = true;
        path.add(new int[]{r, c});

        for (int[] d : dirs) {
            helper(visited, path, n, sum + matrix[r][c], r+d[0], c+d[1], dirs, ans);
        }

        visited[r][c] = false;
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        // System.out.println("num of case: " + t);
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            List<int[]> ans = solve(n);

            System.out.println(String.format("Case #%d:", i));
            for (int[] e : ans) {
                System.out.println(e[0] + " " + e[1]);
            }
        }
    }

    private static int[][] init(int N) {
        int[][] matrix = new int[N][N];

        for (int r = 1; r < N; ++r) {
            for (int c = 1; c <= r; c++) {
                if (c == 1 || c == r) {
                    matrix[r][c] = 1;
                } else {
                    matrix[r][c] = matrix[r-1][c] + matrix[r-1][c-1];
                }
            }
        }

        return matrix;
    }
}