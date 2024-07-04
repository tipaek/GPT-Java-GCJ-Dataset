import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static ArrayList<Edge> path = new ArrayList<>();
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
            vis = new boolean[1005][1005];
            path.clear();
            dfs(0, 0, 1);
        }
    }

    static void initializePascalsTriangle() {
        pascals[0][0] = 1;
        for (int i = 1; i < 1005; i++) {
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

        if (sum == n && path.size() <= 500 && !flag) {
            flag = true;
            for (Edge e : path) {
                System.out.println((e.x + 1) + " " + (e.y + 1));
            }
            return;
        }

        if (n < 501) {
            if (x - 1 >= 0 && !vis[x - 1][y]) dfs(x - 1, y, sum + pascals[x - 1][y]);
            if (x - 1 >= 0 && y - 1 >= 0 && !vis[x - 1][y - 1]) dfs(x - 1, y - 1, sum + pascals[x - 1][y - 1]);
            if (y - 1 >= 0 && pascals[x][y - 1] != 0 && !vis[x][y - 1]) dfs(x, y - 1, sum + pascals[x][y - 1]);
        }

        if (x + 1 < 1000 && pascals[x + 1][y] != 0 && !vis[x + 1][y]) dfs(x + 1, y, sum + pascals[x + 1][y]);
        if (x + 1 < 1000 && y + 1 < 1000 && !vis[x + 1][y + 1]) dfs(x + 1, y + 1, sum + pascals[x + 1][y + 1]);
        if (y + 1 < 1000 && !vis[x][y + 1]) dfs(x, y + 1, sum + pascals[x][y + 1]);

        if (flag) return;
        path.remove(path.size() - 1);
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