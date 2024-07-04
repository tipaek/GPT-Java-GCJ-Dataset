import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visited;
    static boolean[] color;

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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int testCases = sc.nextInt();

        for (int k = 1; k <= testCases; k++) {
            StringBuilder result = new StringBuilder();
            int n = sc.nextInt();
            result.append("Case #").append(k).append(": ");
            
            Point[] intervals = new Point[n];
            adjacencyList = new ArrayList[n];
            visited = new boolean[n];
            color = new boolean[n];

            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            for (int i = 0; i < n; i++) {
                intervals[i] = new Point(sc.nextInt(), sc.nextInt());
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isIntersecting(intervals[i], intervals[j])) {
                        adjacencyList[i].add(j);
                        adjacencyList[j].add(i);
                    }
                }
            }

            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && !bfs(i)) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    result.append(color[i] ? 'J' : 'C');
                }
            }
            result.append("\n");
            System.out.print(result);
        }
    }

    static boolean bfs(int v) {
        visited[v] = true;
        for (int u : adjacencyList[v]) {
            if (visited[u]) {
                if (color[u] == color[v]) return false;
            } else {
                color[u] = !color[v];
                if (!bfs(u)) return false;
            }
        }
        return true;
    }

    static boolean isIntersecting(Point p1, Point p2) {
        return (p1.x > p2.x && p1.x < p2.y) ||
               (p1.y > p2.x && p1.y < p2.y) ||
               (p2.x > p1.x && p2.x < p1.y) ||
               (p2.y > p1.x && p2.y < p1.y) ||
               (p1.x == p2.x && p1.y == p2.y);
    }
}