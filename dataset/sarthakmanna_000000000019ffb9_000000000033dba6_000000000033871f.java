import java.io.*;
import java.util.*;
import java.math.*;

public class Solution implements Runnable {
    @Override
    public void run() {
        try {
            new Solver().solve();
            System.exit(0);
        } catch (Exception | Error e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        //new Thread(null, new Solution(), "Solver", 1l << 25).start();
        new Solution().run();
    }
}

class Solver {
    final FastIO hp = new FastIO();
    final int MAXN = 1000_006;
    final long MOD = (long) 1e9 + 7;

    void solve() throws Exception {
        int tc = TESTCASES ? hp.nextInt() : 1;
        for (int tce = 1; tce <= tc; ++tce) solve(tce);
        hp.flush();
    }

    boolean TESTCASES = true;
    int N, M;
    int[] X;
    int[][] E;
    ArrayList<int[]>[] graph;


    void solve(int tc) throws Exception {
        hp.print("Case #" + tc + ": ");

        int i, j, k;
        N = hp.nextInt(); M = hp.nextInt();
        X = hp.getIntArray(N - 1);
        E = new int[M][];

        graph = new ArrayList[N];
        for (i = 0; i < N; ++i) graph[i] = new ArrayList<>();
        for (i = 0; i < M; ++i) {
            int a = hp.nextInt() - 1, b = hp.nextInt() - 1;
            E[i] = new int[] {a, b, -7};
            graph[a].add(E[i]); graph[b].add(E[i]);
        }

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (i = 0; i < N - 1; ++i) {
            int countBefore = -X[i];
            map.putIfAbsent(countBefore, new ArrayList<>());
            map.get(countBefore).add(i + 1);
        }

        long[] time = new long[N];
        Arrays.fill(time, -7);
        time[0] = 0;

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            long maxTime = 0;
            for (int vertex : entry.getValue()) {
                for (int[] edge : graph[vertex]) {
                    maxTime = Math.max(maxTime, time[edge[0]]);
                    maxTime = Math.max(maxTime, time[edge[1]]);
                }
            }
            ++maxTime;

            for (int vertex : entry.getValue()) {
                time[vertex] = maxTime;
            }

            for (int vertex : entry.getValue()) {
                for (int[] edge : graph[vertex]) {
                    int connNode = edge[0] == vertex ? edge[1] : edge[0];
                    if (time[connNode] < 0) {
                        continue;
                    } else if (time[connNode] < maxTime) {
                        edge[2] = (int) (maxTime - time[connNode]);
                    } else {
                        edge[2] = (int) 1e6;
                    }
                }
            }
        }

        for (int[] edge : E) hp.print(edge[2] + " ");
        hp.println();
    }
}


class FastIO {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");
    StringBuilder sb = new StringBuilder();

    public String next() throws Exception {
        while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    public String nextLine() throws Exception {
        return br.readLine();
    }

    public void print(Object o) {
        sb.append(o);
    }

    public void println() {
        print("\n");
    }

    public void println(Object o) {
        print(o);
        println();
    }

    public void flush() {
        System.out.print(sb);
        sb = new StringBuilder();
    }

    int[] getIntArray(int size) throws Exception {
        int[] ret = new int[size];
        for (int i = 0; i < size; ++i) ret[i] = nextInt();
        return ret;
    }

    long[] getLongArray(int size) throws Exception {
        long[] ret = new long[size];
        for (int i = 0; i < size; ++i) ret[i] = nextLong();
        return ret;
    }
}