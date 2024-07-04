import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            int c = in.nextInt();
            int d = in.nextInt();
            Integer[][] xi = new Integer[c - 1][2];
            for (int i = 0; i < c - 1; i++) {
                xi[i][0] = i + 1;
                xi[i][1] = -in.nextInt();
            }
            Arrays.sort(xi, Comparator.comparingInt(i -> i[1]));

            @SuppressWarnings("unchecked")
            Map<Integer, Integer>[] edges = new HashMap[c];
            for (int i = 0; i < c; i++)
                edges[i] = new HashMap<>();

            for (int i = 0; i < d; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                int w = i;
                edges[x].put(y, w);
                edges[y].put(x, w);
            }

            int[] y = new int[d];
            Arrays.fill(y, 1000000);
            int[] lat = new int[c];
            int[] src = new int[c];
            Arrays.fill(src, -1);
            src[0] = 0;
            int[] di = new int[c];
            int last = 0;
            int time = 0;

            for (Map.Entry<Integer, Integer> neighbour : edges[0].entrySet()) {
                src[neighbour.getKey()] = 0;
                di[neighbour.getKey()] = neighbour.getValue();
            }

            for (Integer[] x : xi) {
                int next = x[1];
                if (next > last) {
                    time++;
                    last = next;
                }
                y[di[x[0]]] = time - lat[src[x[0]]];
                lat[x[0]] = time;
                for (Map.Entry<Integer, Integer> neighbour : edges[x[0]].entrySet()) {
                    if (src[neighbour.getKey()] == -1) {
                        src[neighbour.getKey()] = x[0];
                        di[neighbour.getKey()] = neighbour.getValue();
                    }
                }
            }

            out.printf("Case #%d:", tc);
            for (int value : y) {
                out.printf(" %d", value);
            }
            out.println();
        }
        finish();
    }

    public static void finish() {
        out.close();
        in.close();
        System.exit(0);
    }

    static class InputReader implements Iterator<String>, Closeable {

        private BufferedReader r;
        private StringTokenizer st;

        public InputReader(InputStream i) {
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasNext() {
            return peekToken() != null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            String ans = peekToken();
            st = null;
            return ans;
        }

        public String nextLine() {
            peekToken();
            String ans = st.nextToken("\n");
            st = null;
            return ans;
        }

        public void close() {
            try {
                r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String peekToken() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st != null && st.hasMoreTokens() ? st.nextToken() : null;
        }
    }
}