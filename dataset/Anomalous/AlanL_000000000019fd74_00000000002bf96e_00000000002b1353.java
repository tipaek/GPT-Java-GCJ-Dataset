import java.util.*;
import java.io.*;

public class Solution {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final ArrayList<Edge> path = new ArrayList<>();
    private static boolean flag = false;
    private static boolean[][] vis;
    private static int n;
    private static long[][] pascals;

    public static void main(String[] args) throws IOException {
        int t = readInt();
        pascals = new long[1005][1005];
        initializePascalsTriangle();

        for (int z = 1; z <= t; z++) {
            System.out.println("Case #" + z + ": ");
            flag = false;
            n = readInt();
            vis = new boolean[1005][1005];
            path.clear();
            dfs(0, 0, 1);
        }
    }

    private static void initializePascalsTriangle() {
        pascals[0][0] = 1;
        for (int i = 1; i < 1005; i++) {
            pascals[i][0] = 1;
            pascals[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascals[i][j] = pascals[i - 1][j - 1] + pascals[i - 1][j];
            }
        }
    }

    private static void dfs(int x, int y, long sum) {
        if (flag) return;
        vis[x][y] = true;
        path.add(new Edge(x, y));
        if (sum == n && path.size() <= 500 && !flag) {
            flag = true;
            for (Edge edge : path) {
                System.out.println((edge.x + 1) + " " + (edge.y + 1));
            }
            return;
        }

        if (n != 501) {
            if (isValidMove(x - 1, y)) dfs(x - 1, y, sum + pascals[x - 1][y]);
            if (flag) return;
            if (isValidMove(x - 1, y - 1)) dfs(x - 1, y - 1, sum + pascals[x - 1][y - 1]);
            if (flag) return;
            if (isValidMove(x, y - 1)) dfs(x, y - 1, sum + pascals[x][y - 1]);
            if (flag) return;
        }

        if (isValidMove(x, y + 1)) dfs(x, y + 1, sum + pascals[x][y + 1]);
        if (flag) return;
        if (isValidMove(x + 1, y)) dfs(x + 1, y, sum + pascals[x + 1][y]);
        if (flag) return;
        if (isValidMove(x + 1, y + 1)) dfs(x + 1, y + 1, sum + pascals[x + 1][y + 1]);
        if (flag) return;

        path.remove(path.size() - 1);
    }

    private static boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && x < 1000 && y < 1000 && !vis[x][y] && pascals[x][y] != 0;
    }

    private static class Edge {
        int x, y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    private static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private static char readChar() throws IOException {
        return next().charAt(0);
    }

    private static String readLine() throws IOException {
        return input.readLine().trim();
    }
}