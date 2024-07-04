import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static List<Edge> path = new ArrayList<>();
    static boolean flag = false;
    static boolean[][] vis;
    static int n;
    static long[][] pascals;

    public static void main(String[] args) throws IOException {
        int t = readInt();
        pascals = new long[1005][1005];
        initializePascalsTriangle();

        for (int z = 1; z <= t; z++) {
            System.out.println("Case #" + z + ": ");
            flag = false;
            n = readInt();
            vis = new boolean[1000][1000];
            path.clear();
            dfs(0, 0, 1);
        }
    }

    static void initializePascalsTriangle() {
        pascals[0][0] = 1;
        for (int i = 1; i < 1000; i++) {
            pascals[i][0] = 1;
            pascals[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascals[i][j] = pascals[i - 1][j - 1] + pascals[i - 1][j];
            }
        }
    }

    static void dfs(int x, int y, long sum) {
        if (flag) return;
        vis[x][y] = true;
        path.add(new Edge(x, y));

        if (sum == n && path.size() <= 500) {
            flag = true;
            for (Edge e : path) {
                System.out.println((e.x + 1) + " " + (e.y + 1));
            }
            return;
        }

        explore(x - 1, y, sum);
        explore(x - 1, y - 1, sum);
        explore(x, y - 1, sum);
        explore(x + 1, y, sum);
        explore(x + 1, y + 1, sum);
        explore(x, y + 1, sum);

        path.remove(path.size() - 1);
    }

    static void explore(int x, int y, long sum) {
        if (isValid(x, y) && !vis[x][y]) {
            dfs(x, y, sum + pascals[x][y]);
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < 1000 && y < 1000 && pascals[x][y] != 0;
    }

    static class Edge {
        int x, y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return input.readLine().trim();
    }
}