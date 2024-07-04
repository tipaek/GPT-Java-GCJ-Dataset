import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static List<Edge> path = new ArrayList<>();
    static boolean flag = false;
    static boolean[][] visited;
    static int n;
    static long[][] pascalsTriangle;

    public static void main(String[] args) throws IOException {
        int testCases = readInt();
        pascalsTriangle = new long[1005][1005];
        initializePascalsTriangle();

        for (int z = 1; z <= testCases; z++) {
            System.out.println("Case #" + z + ": ");
            flag = false;
            n = readInt();
            visited = new boolean[1005][1005];
            path.clear();
            dfs(0, 0, 1);
        }
    }

    static void initializePascalsTriangle() {
        pascalsTriangle[0][0] = 1;
        for (int i = 1; i < 1005; i++) {
            pascalsTriangle[i][0] = 1;
            pascalsTriangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascalsTriangle[i][j] = pascalsTriangle[i - 1][j - 1] + pascalsTriangle[i - 1][j];
            }
        }
    }

    static void dfs(int x, int y, long sum) {
        if (flag) return;
        visited[x][y] = true;
        path.add(new Edge(x, y));

        if (sum == n && path.size() <= 500 && !flag) {
            flag = true;
            for (Edge edge : path) {
                System.out.println((edge.x + 1) + " " + (edge.y + 1));
            }
            return;
        }

        if (isValidMove(x, y + 1)) dfs(x, y + 1, sum + pascalsTriangle[x + 1][y + 1]);
        if (flag) return;
        if (isValidMove(x + 1, y)) dfs(x + 1, y, sum + pascalsTriangle[x + 1][y]);
        if (flag) return;
        if (isValidMove(x + 1, y + 1)) dfs(x + 1, y + 1, sum + pascalsTriangle[x + 1][y + 1]);
        if (flag) return;

        if (n != 501) {
            if (isValidMove(x - 1, y)) dfs(x - 1, y, sum + pascalsTriangle[x - 1][y]);
            if (flag) return;
            if (isValidMove(x - 1, y - 1)) dfs(x - 1, y - 1, sum + pascalsTriangle[x - 1][y - 1]);
            if (flag) return;
            if (isValidMove(x, y - 1)) dfs(x, y - 1, sum + pascalsTriangle[x][y - 1]);
            if (flag) return;
        }

        path.remove(path.size() - 1);
    }

    static boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && x < 1000 && y < 1000 && !visited[x][y];
    }

    static class Edge {
        int x, y;

        Edge(int x0, int y0) {
            x = x0;
            y = y0;
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(input.readLine().trim());
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