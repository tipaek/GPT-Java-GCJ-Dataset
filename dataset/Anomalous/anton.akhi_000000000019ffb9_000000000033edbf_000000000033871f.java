import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private class Edge {
        int x, y, d, n;

        public Edge(int x2, int y2, int i) {
            x = x2;
            y = y2;
            n = i;
        }
    }

    private class Node implements Comparable<Node> {
        int n, t;

        public Node(int i, int order) {
            n = i;
            t = order;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(t, o.t);
        }
    }

    private void solve() {
        int testCount = nextInt();
        for (int test = 1; test <= testCount; test++) {
            out.print("Case #" + test + ": ");
            int n = nextInt();
            int m = nextInt();
            ArrayList<Edge>[] edges = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            HashMap<Integer, ArrayList<Integer>> layerMap = new HashMap<>();
            ArrayList<Node> nodes = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                int order = nextInt();
                if (order < 0) {
                    order = -order;
                    layerMap.computeIfAbsent(order, k -> new ArrayList<>()).add(i);
                } else {
                    nodes.add(new Node(i, order));
                }
            }
            nodes.add(new Node(0, 0));
            Collections.sort(nodes);
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                int x = nextInt() - 1;
                int y = nextInt() - 1;
                edges[x].add(new Edge(x, y, i));
                edges[y].add(new Edge(y, x, i));
            }
            int time = 0;
            int[] done = new int[n];
            Arrays.fill(done, -1);
            int processedTime = 0;
            int processedAll = 0;
            for (int layer = 1; layer < n; layer++) {
                if (!layerMap.containsKey(layer)) continue;
                while (processedAll < layer) {
                    Node next = nodes.get(processedTime++);
                    set(next.n, done, edges, next.t, ans);
                    processedAll++;
                    time = next.t;
                }
                time++;
                for (int x : layerMap.get(layer)) {
                    set(x, done, edges, time, ans);
                    processedAll++;
                }
            }
            while (processedTime < nodes.size()) {
                Node next = nodes.get(processedTime++);
                set(next.n, done, edges, next.t, ans);
                processedAll++;
            }
            for (int i = 0; i < ans.length; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
            out.flush();
        }
    }

    private void set(int x, int[] done, ArrayList<Edge>[] edges, int time, int[] ans) {
        done[x] = time;
        for (Edge e : edges[x]) {
            if (done[e.y] >= 0) {
                ans[e.n] = Math.max(time - done[e.y], 1);
            }
        }
    }
}