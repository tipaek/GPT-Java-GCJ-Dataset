import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static final int LIMIT = 500; // 500
    static int[][] dirsL = {{1,1},{1,0},{0,1},{-1,0},{0,-1},{-1,-1}};
    static int[][] dirsR = {{1,0},{1,1},{0,-1},{-1,-1},{0,1},{-1,0}};
    static int[][] tri = new int[LIMIT][LIMIT];
    static boolean[][] visited = new boolean[LIMIT][LIMIT];
    static int upTo = 0;

    static {
        tri[0][0] = 1;
    }

    public static List<int[]> solve(int N) {
        visited = new boolean[LIMIT][LIMIT];
        List<int[]> path = new ArrayList<>();
        if (dfs(0, 0, 0, N, path)) return path;
        return new ArrayList<>();
    }

    private static boolean dfs(int x, int y, int sum, int N, List<int[]> path) {
        if (path.size() >= LIMIT || sum >= N) return false;
        visited[x][y] = true;
        if (x > upTo && upTo < LIMIT - 1) calc();
        sum += tri[x][y];
        path.add(new int[]{x, y});
        if (sum == N) {
            return true;
        }
        int[][] dirs = y < x / 2 ? dirsL : dirsR;
        for (int[] dir : dirs) {
            int xx = x + dir[0], yy = y + dir[1];
            if (inBound(xx, yy) && !visited[xx][yy] && dfs(xx, yy, sum, N, path)) return true;
        }
        visited[x][y] = false;
        // sum -= tri[x][y];
        path.remove(path.size() - 1);
        return false;
    }

    private static void calc() {
        int row = upTo + 1;
        tri[row][0] = tri[row-1][0];
        tri[row][row] = tri[row-1][row-1];
        for (int i = 1; i < row; i++) {
            tri[row][i] = tri[row-1][i-1] + tri[row-1][i];
        }
        upTo++;
    }

    private static boolean inBound(int x, int y) {
        return x >= 0 && x < LIMIT && y >= 0 && y <= x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ks = 1; ks <= T; ++ks) {
            int n = in.nextInt();
            List<int[]> list = solve(n);
            System.out.println("Case #" + ks + ":");
            for (int[] res : list) System.out.println((res[0] + 1) + " " + (res[1] + 1));
        }
    }
}