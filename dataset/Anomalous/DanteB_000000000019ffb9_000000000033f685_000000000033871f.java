import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = in.nextInt();
        for (int tc = 1; tc <= testCases; ++tc) {
            int c = in.nextInt();
            int d = in.nextInt();
            Integer[][] ranks = new Integer[c - 1][2];
            Integer[][] times = new Integer[c - 1][2];
            int rankIndex = 0, timeIndex = 0;

            for (int i = 0; i < c - 1; i++) {
                int val = in.nextInt();
                if (val < 0) {
                    ranks[rankIndex][0] = i + 1;
                    ranks[rankIndex][1] = -val;
                    rankIndex++;
                } else {
                    times[timeIndex][0] = i + 1;
                    times[timeIndex][1] = val;
                    timeIndex++;
                }
            }

            fillRemaining(ranks, rankIndex, c - 1, 1000000);
            fillRemaining(times, timeIndex, c - 1, 1000000);

            Arrays.sort(ranks, Comparator.comparingInt(a -> a[1]));
            Arrays.sort(times, Comparator.comparingInt(a -> a[1]));

            HashMap<Integer, Integer>[] edges = createEdges(c, d);

            int[] y = new int[d];
            Arrays.fill(y, 1000000);

            int[] lat = new int[c];
            int[] src = new int[c];
            Arrays.fill(src, 1, c, -1);

            int[] di = new int[c];
            initializeEdges(edges[0], src, di);

            int time = 0;
            rankIndex = 0;
            timeIndex = 0;

            for (int i = 1; i < c; i++) {
                int next = determineNextNode(ranks, times, i, rankIndex, timeIndex);
                if (ranks[rankIndex][1] == i && times[timeIndex][1] != 1000000) {
                    time = times[timeIndex][1];
                } else if (ranks[rankIndex][1] == i) {
                    time++;
                }
                rankIndex++;

                y[di[next]] = time - lat[src[next]];
                lat[next] = time;

                updateEdges(edges[next], src, di, next);
            }

            out.printf("Case #%d:", tc);
            for (int value : y) {
                out.printf(" %d", value);
            }
            out.println();
        }
        finish();
    }

    private static void fillRemaining(Integer[][] array, int startIndex, int endIndex, int fillValue) {
        for (int i = startIndex; i < endIndex; i++) {
            array[i][1] = fillValue;
        }
    }

    private static HashMap<Integer, Integer>[] createEdges(int c, int d) {
        @SuppressWarnings("unchecked")
        HashMap<Integer, Integer>[] edges = new HashMap[c];
        for (int i = 0; i < c; i++) {
            edges[i] = new HashMap<>();
        }
        for (int i = 0; i < d; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            int w = i;
            edges[x].put(y, w);
            edges[y].put(x, w);
        }
        return edges;
    }

    private static void initializeEdges(HashMap<Integer, Integer> initialEdges, int[] src, int[] di) {
        for (Map.Entry<Integer, Integer> neighbour : initialEdges.entrySet()) {
            src[neighbour.getKey()] = 0;
            di[neighbour.getKey()] = neighbour.getValue();
        }
    }

    private static int determineNextNode(Integer[][] ranks, Integer[][] times, int i, int rankIndex, int timeIndex) {
        if (ranks[rankIndex][1] <= i) {
            return ranks[rankIndex][0];
        } else {
            return times[timeIndex][0];
        }
    }

    private static void updateEdges(HashMap<Integer, Integer> currentEdges, int[] src, int[] di, int next) {
        for (Map.Entry<Integer, Integer> neighbour : currentEdges.entrySet()) {
            if (src[neighbour.getKey()] == -1) {
                src[neighbour.getKey()] = next;
                di[neighbour.getKey()] = neighbour.getValue();
            }
        }
    }

    public static void finish() {
        out.close();
        in.close();
        System.exit(0);
    }

    static class InputReader implements Iterator<String>, Closeable {
        private BufferedReader r;
        private StringTokenizer st;
        private String token;

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
            token = null;
            return ans;
        }

        public String nextLine() {
            peekToken();
            String ans = line;
            token = null;
            st = null;
            return ans;
        }

        public void close() {
            try {
                r.close();
            } catch (IOException e) {
                // Handle exception
            }
        }

        private String peekToken() {
            if (token == null) {
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                    // Handle exception
                }
            }
            return token;
        }
    }
}