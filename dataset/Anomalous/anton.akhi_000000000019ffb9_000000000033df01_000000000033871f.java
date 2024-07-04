import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void execute() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        process();
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
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

    private static class Edge {
        int x, y, d, n;

        public Edge(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    private void process() {
        int testCases = nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            out.print("Case #" + testCase + ": ");
            int n = nextInt();
            int m = nextInt();
            List<Edge>[] edges = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            Map<Integer, List<Integer>> layerMap = new HashMap<>();
            for (int i = 1; i < n; i++) {
                int order = -nextInt();
                layerMap.computeIfAbsent(order, k -> new ArrayList<>()).add(i);
            }
            int[] results = new int[m];
            for (int i = 0; i < m; i++) {
                int x = nextInt() - 1;
                int y = nextInt() - 1;
                edges[x].add(new Edge(x, y, i));
                edges[y].add(new Edge(y, x, i));
            }
            int time = 0;
            int[] completionTimes = new int[n];
            Arrays.fill(completionTimes, -1);
            completionTimes[0] = 0;

            for (int layer = 1; layer < n; layer++) {
                if (!layerMap.containsKey(layer)) {
                    continue;
                }
                time++;
                List<Integer> nodes = layerMap.get(layer);
                for (int node : nodes) {
                    completionTimes[node] = time;
                    for (Edge edge : edges[node]) {
                        if (completionTimes[edge.y] >= 0) {
                            results[edge.n] = Math.max(time - completionTimes[edge.y], 1);
                        }
                    }
                }
            }
            for (int result : results) {
                out.print(result + " ");
            }
            out.println();
        }
    }
}