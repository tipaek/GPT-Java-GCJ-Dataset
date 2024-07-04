import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static final int OFFSET = -1000000000;
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = scanner.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int K = scanner.nextInt();
            int Q = scanner.nextInt();
            String s = scanner.nextLine();
            char[] c = s.toCharArray();
            int[] edge = new int[K + 1];
            Arrays.fill(edge, -1);

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < K; i++) {
                if (c[i] == '(') {
                    stack.push(i);
                } else {
                    int tmp = stack.pop();
                    edge[tmp + 1] = i + 1;
                    edge[i + 1] = tmp + 1;
                }
            }

            int[] S = new int[Q];
            for (int i = 0; i < K; i++) scanner.nextInt(); // Skip input
            for (int i = 0; i < K; i++) scanner.nextInt(); // Skip input
            for (int i = 0; i < K; i++) scanner.nextInt(); // Skip input
            for (int i = 0; i < Q; i++) S[i] = scanner.nextInt();

            Queue<Integer> queue = new LinkedList<>();
            int totalDistance = 0;

            for (int i = 0; i < Q; i++) {
                int end = scanner.nextInt();
                int start = S[i];
                int distance = bfs(start, end, K, edge, queue);

                totalDistance += distance;
            }

            out.println("Case #" + tt + ": " + totalDistance);
        }

        out.close();
    }

    private static int bfs(int start, int end, int K, int[] edge, Queue<Integer> queue) {
        int distance = Math.abs(start - end);
        if (distance <= 2) {
            return distance;
        }

        if (distance == 3) {
            return edge[start] == end ? 1 : 3;
        }

        boolean[] visited = new boolean[K + 1];
        queue.clear();
        queue.add(start);
        visited[start] = true;
        int res = 0;

        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int current = queue.poll();
                if (current < 1 || current > K) continue;

                if (current == end + 1 || current == end - 1 || edge[current] == end) {
                    return res + 1;
                }

                if (!visited[current - 1]) {
                    queue.add(current - 1);
                    visited[current - 1] = true;
                }

                if (!visited[current + 1]) {
                    queue.add(current + 1);
                    visited[current + 1] = true;
                }

                if (!visited[edge[current]]) {
                    queue.add(edge[current]);
                    visited[edge[current]] = true;
                }
            }
            res++;
        }

        return res;
    }

    // MyScanner class for faster input
    public static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
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