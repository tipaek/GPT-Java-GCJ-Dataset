import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static ArrayList<Edge> path = new ArrayList<>();
    static boolean flag = false, vis[][];
    static int n;
    static long[][] pascals;

    public static void main(String[] args) throws IOException {
        int t = readInt();
        pascals = new long[1000][1000];
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
        
        if (sum == n && path.size() <= 500 && !flag) {
            flag = true;
            for (Edge edge : path) {
                System.out.println((edge.x + 1) + " " + (edge.y + 1));
            }
            return;
        }

        exploreNeighbors(x, y, sum);
        path.remove(path.size() - 1);
    }

    static void exploreNeighbors(int x, int y, long sum) {
        if (x - 1 >= 0 && !vis[x - 1][y]) dfs(x - 1, y, sum + pascals[x - 1][y]);
        if (x - 1 >= 0 && y - 1 >= 0 && !vis[x - 1][y - 1]) dfs(x - 1, y - 1, sum + pascals[x - 1][y - 1]);
        if (y - 1 >= 0 && !vis[x][y - 1]) dfs(x, y - 1, sum + pascals[x][y - 1]);
        if (x + 1 < 1000 && !vis[x + 1][y]) dfs(x + 1, y, sum + pascals[x + 1][y]);
        if (x + 1 < 1000 && y + 1 < 1000 && !vis[x + 1][y + 1]) dfs(x + 1, y + 1, sum + pascals[x + 1][y + 1]);
        if (y + 1 < 1000 && !vis[x][y + 1]) dfs(x, y + 1, sum + pascals[x][y + 1]);
    }

    static class Edge {
        int x, y;

        Edge(int x0, int y0) {
            x = x0;
            y = y0;
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