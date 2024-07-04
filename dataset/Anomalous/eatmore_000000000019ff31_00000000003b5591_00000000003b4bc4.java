import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {

    static class MaxFlow {
        static int n;
        static int[] edgesLen, caps;
        static int[][] edges;
        static int capsLen;

        static void init() {
            edgesLen = new int[n];
            edges = new int[n][6];
            capsLen = 0;
            caps = new int[6];
        }

        static int addEdge(int from, int to, int capacity, int reverseCapacity) {
            if (caps.length == capsLen) {
                caps = Arrays.copyOf(caps, (capsLen << 1) + 2);
            }
            caps[capsLen] = capacity;
            caps[capsLen + 1] = reverseCapacity;
            capsLen += 2;

            if (edges[from].length == edgesLen[from]) {
                edges[from] = Arrays.copyOf(edges[from], (edgesLen[from] << 1) + 2);
            }
            edges[from][edgesLen[from]] = to;
            edges[from][edgesLen[from] + 1] = capsLen - 2;
            edgesLen[from] += 2;

            if (edges[to].length == edgesLen[to]) {
                edges[to] = Arrays.copyOf(edges[to], (edgesLen[to] << 1) + 2);
            }
            edges[to][edgesLen[to]] = from;
            edges[to][edgesLen[to] + 1] = capsLen - 1;
            edgesLen[to] += 2;

            return capsLen - 2;
        }

        static int dinic(int source, int sink) {
            int[] dist = new int[n];
            int[] curEdge = new int[n];
            int[] queue = new int[n];
            int flow = 0;

            while (true) {
                Arrays.fill(dist, -1);
                dist[source] = 0;
                queue[0] = source;
                int queueHead = 0, queueTail = 1;

                while (queueHead < queueTail) {
                    int cur = queue[queueHead++];
                    int ndist = dist[cur] + 1;
                    for (int i = 0; i < edgesLen[cur]; i += 2) {
                        if (caps[edges[cur][i + 1]] == 0) continue;
                        int to = edges[cur][i];
                        if (dist[to] < 0) {
                            dist[to] = ndist;
                            queue[queueTail++] = to;
                        }
                    }
                }

                if (dist[sink] < 0) return flow;

                Arrays.fill(curEdge, 0);
                int stackSize = 0;
                int cur = source;
                int eNum = 0;

                while (true) {
                    if (cur == sink) {
                        int curFlow = Integer.MAX_VALUE;
                        for (int i = 0; i < stackSize; i++) {
                            int c = queue[i];
                            curFlow = Math.min(curFlow, caps[edges[c][curEdge[c] + 1]]);
                        }
                        for (int i = 0; i < stackSize; i++) {
                            int c = queue[i];
                            int cap = edges[c][curEdge[c] + 1];
                            caps[cap] -= curFlow;
                            caps[cap ^ 1] += curFlow;
                        }
                        flow += curFlow;
                        stackSize = 0;
                        cur = source;
                        eNum = curEdge[source];
                        continue;
                    }

                    int ndist = stackSize + 1;
                    while (eNum < edgesLen[cur]) {
                        int next = edges[cur][eNum];
                        if (caps[edges[cur][eNum + 1]] != 0 && dist[next] == ndist) {
                            curEdge[cur] = eNum;
                            queue[stackSize++] = cur;
                            cur = next;
                            eNum = curEdge[cur];
                            continue;
                        }
                        eNum += 2;
                    }

                    curEdge[cur] = eNum;
                    if (stackSize == 0) break;
                    cur = queue[--stackSize];
                    eNum = curEdge[cur] + 2;
                }
            }
        }
    }

    static long[] e;
    static long seen;
    static int[] exit, comp;
    static int exitPos, nComps;
    static long needHole, ce[];

    static int toCode(char c) {
        if ('A' <= c && c <= 'Z') return c - 'A';
        if ('a' <= c && c <= 'z') return c - 'a' + 26;
        if ('0' <= c && c <= '9') return c - '0' + 52;
        throw new AssertionError();
    }

    static void solve() throws Exception {
        String s = scanString();
        int n = scanInt();
        e = new long[62];
        for (int i = 0; i < n; i++) {
            String r = scanString();
            e[toCode(r.charAt(0))] |= 1L << toCode(r.charAt(1));
        }

        seen = 0;
        exit = new int[62];
        exitPos = 0;
        for (int i = 0; i < 62; i++) {
            dfs1(i);
        }

        nComps = 0;
        comp = new int[62];
        Arrays.fill(comp, -1);
        needHole = 0;
        ce = new long[62];
        for (int i = 61; i >= 0; i--) {
            if (comp[exit[i]] < 0) {
                dfs2(exit[i]);
                nComps++;
            }
        }

        int ans = 0;
        long have = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = toCode(s.charAt(i));
            if ((have & (1L << c)) == 0) {
                have |= 1L << c;
                ++ans;
            }
        }

        int[] nHoles = new int[nComps];
        for (int i = 0; i < 62; i++) {
            if ((have & (1L << i)) == 0) {
                ++nHoles[comp[i]];
            }
        }

        MaxFlow.n = 2 * nComps + 2;
        MaxFlow.init();
        int needFlow = 0;
        for (int i = 0; i < nComps; i++) {
            int enter = nHoles[i], exit = 0;
            if ((needHole & (1L << i)) != 0 && enter == 0) {
                enter = exit = 1;
            }
            if (enter != 0) {
                MaxFlow.addEdge(2 * nComps, 2 * i + 1, enter, 0);
            }
            if (exit != 0) {
                MaxFlow.addEdge(2 * i, 2 * nComps + 1, exit, 0);
            }
            needFlow += exit;
            MaxFlow.addEdge(2 * i, 2 * i + 1, 2 * 62, 0);
            for (int j = 0; j < i; j++) {
                if ((ce[i] & (1L << j)) != 0) {
                    MaxFlow.addEdge(2 * i + 1, 2 * j, 2 * 62, 0);
                }
            }
        }

        ans -= needFlow - MaxFlow.dinic(2 * nComps, 2 * nComps + 1);
        printCase();
        out.println(ans);
    }

    static void dfs1(int cur) {
        if ((seen & (1L << cur)) != 0) return;
        seen |= 1L << cur;
        for (int next = 0; next < 62; next++) {
            if ((e[cur] & (1L << next)) != 0) {
                dfs1(next);
            }
        }
        exit[exitPos++] = cur;
    }

    static void dfs2(int cur) {
        comp[cur] = nComps;
        for (int next = 0; next < 62; next++) {
            if ((e[next] & (1L << cur)) != 0) {
                if (comp[next] < 0) {
                    dfs2(next);
                }
                needHole |= 1L << comp[next];
                ce[nComps] |= 1L << comp[next];
            }
        }
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static long scanLong() throws IOException {
        return Long.parseLong(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}