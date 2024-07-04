import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static List<Integer>[] adj;
    static boolean[] color;
    static boolean[] vis;

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int tst = 1; tst <= t; tst++) {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();
            sb.append("Case #").append(tst).append(": ");
            Point[] points = new Point[n];
            adj = new ArrayList[n];
            vis = new boolean[n];
            color = new boolean[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                points[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (intersects(points[i], points[j])) {
                        adj[i].add(j);
                        adj[j].add(i);
                    }
                }
            }
            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (!vis[i] && !dfs(i)) {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                sb.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append(color[i] ? 'C' : 'J');
                }
            }
            sb.append("\n");
            System.out.print(sb);
        }
    }

    static boolean dfs(int v) {
        vis[v] = true;
        for (int u : adj[v]) {
            if (vis[u]) {
                if (color[u] == color[v]) {
                    return false;
                }
            } else {
                color[u] = !color[v];
                if (!dfs(u)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean intersects(Point p1, Point p2) {
        return (p1.x > p2.x && p1.x < p2.y) || (p1.y > p2.x && p1.y < p2.y) ||
               (p2.x > p1.x && p2.x < p1.y) || (p2.y > p1.x && p2.y < p1.y) ||
               (p1.x == p2.x && p1.y == p2.y);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}