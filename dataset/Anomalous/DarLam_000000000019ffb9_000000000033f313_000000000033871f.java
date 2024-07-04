import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    private PrintStream out;
    private BufferedReader in;
    private StringTokenizer st;

    public void solve() throws IOException {
        long startTime = System.currentTimeMillis();

        int testCaseCount = nextInt();
        for (int test = 1; test <= testCaseCount; test++) {
            int n = nextInt();
            int m = nextInt();
            int[] x = new int[n];
            for (int i = 1; i < n; i++) {
                x[i] = nextInt();
            }
            int[] u = new int[m];
            int[] v = new int[m];
            for (int i = 0; i < m; i++) {
                u[i] = nextInt() - 1;
                v[i] = nextInt() - 1;
            }
            int[] distances = calculateDistances(n, x, m, u, v);
            out.print("Case #" + test + ":");
            for (int distance : distances) {
                out.print(" " + distance);
            }
            out.println();
        }

        System.err.println("Execution time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private int[] calculateDistances(int n, int[] x, int m, int[] u, int[] v) {
        Integer[] sortedIndices = getSortedIndices(n, x);
        int[] dist = new int[n];
        int[][][] graph = buildGraph(n, m, u, v);
        int[] resultDistances = new int[m];
        Arrays.fill(resultDistances, 1000000);

        for (int i = 1; i < n; i++) {
            if (x[sortedIndices[i]] == x[sortedIndices[i - 1]]) {
                dist[sortedIndices[i]] = dist[sortedIndices[i - 1]];
            } else {
                dist[sortedIndices[i]] = dist[sortedIndices[i - 1]] + 1;
            }
            int a = sortedIndices[i];
            for (int[] edge : graph[a]) {
                int b = edge[0];
                if (x[b] > x[a]) {
                    resultDistances[edge[1]] = dist[a] - dist[b];
                }
            }
        }
        return resultDistances;
    }

    private int[][][] buildGraph(int n, int m, int[] u, int[] v) {
        int[] edgeCount = new int[n];
        for (int i = 0; i < m; i++) {
            edgeCount[u[i]]++;
            edgeCount[v[i]]++;
        }

        int[][][] graph = new int[n][][];
        for (int i = 0; i < n; i++) {
            graph[i] = new int[edgeCount[i]][2];
            edgeCount[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            graph[u[i]][edgeCount[u[i]]][0] = v[i];
            graph[u[i]][edgeCount[u[i]]][1] = i;
            edgeCount[u[i]]++;
            graph[v[i]][edgeCount[v[i]]][0] = u[i];
            graph[v[i]][edgeCount[v[i]]][1] = i;
            edgeCount[v[i]]++;
        }

        return graph;
    }

    private Integer[] getSortedIndices(int n, int[] x) {
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int u = random.nextInt(n);
            int v = random.nextInt(n);
            Integer temp = indices[u];
            indices[u] = indices[v];
            indices[v] = temp;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(x[b], x[a]));
        return indices;
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    @Override
    public void run() {
        try {
            solve();
            out.close();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public Solution(String filename) throws IOException {
        Locale.setDefault(Locale.US);
        if (filename == null) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintStream(new BufferedOutputStream(System.out));
        } else {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(filename + ".in")));
            out = new PrintStream(new BufferedOutputStream(new FileOutputStream(filename + ".out")));
        }
        st = new StringTokenizer("");
    }

    public static void main(String[] args) throws IOException {
        new Thread(new Solution(null)).start();
    }
}