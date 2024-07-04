import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    static int n, m, tte;
    static int[] val;
    static ArrayList<Node>[] graph;
    static int[][] edge;
    static int[] time;

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        StringBuilder sb = new StringBuilder();
        int t = in.nextInt();

        for (int t0 = 1; t0 <= t; t0++) {
            n = in.nextInt();
            m = in.nextInt();
            val = new int[n + 1];
            edge = new int[m][2];

            for (int i = 2; i <= n; i++) {
                val[i] = in.nextInt() * -1;
            }

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            time = new int[n + 1];
            int[] edtime = new int[m];
            int[] nodind = new int[n + 1];
            int[] par = new int[n + 1];
            boolean[] visited = new boolean[n + 1];

            time[1] = 0;

            for (int i = 0; i < m; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                edge[i][0] = x;
                edge[i][1] = y;
                graph[x].add(new Node(y, i));
                graph[y].add(new Node(x, i));
            }

            tte = 0;
            Set<Integer> list = new HashSet<>();
            visited[1] = true;

            for (Node z : graph[1]) {
                visited[z.v] = true;
                list.add(z.v);
                nodind[z.v] = z.ind;
                par[z.v] = 1;
            }

            int before = 1;

            while (true) {
                Set<Integer> nlist = new HashSet<>();
                int c = 0;

                for (int x : list) {
                    if (val[x] == before) {
                        visited[x] = true;
                        edtime[nodind[x]] = tte - time[par[x]] + 1;
                        time[x] = tte + 1;
                        c++;

                        for (Node z : graph[x]) {
                            if (!visited[z.v]) {
                                visited[z.v] = true;
                                nlist.add(z.v);
                                nodind[z.v] = z.ind;
                                par[z.v] = x;
                            }
                        }
                    } else if (val[x] > before) {
                        nlist.add(x);
                    }
                }

                tte++;
                before += c;
                list = nlist;

                if (before >= n) {
                    break;
                }
            }

            for (int i = 0; i < m; i++) {
                if (edtime[i] == 0) {
                    edtime[i] = Integer.MAX_VALUE;
                }
            }

            sb.append("Case #").append(t0).append(": ");
            for (int i = 0; i < m; i++) {
                sb.append(edtime[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

class Node {
    int v, ind;

    public Node(int v, int ind) {
        this.v = v;
        this.ind = ind;
    }
}

class FastReader {
    private byte[] buf = new byte[2048];
    private int index, total;
    private InputStream in;

    public FastReader(InputStream is) {
        in = is;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    public String next() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = scan()) > 32);
        return sb.toString();
    }

    public int nextInt() throws IOException {
        int c, val = 0;
        while ((c = scan()) <= 32);
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            val = (val << 3) + (val << 1) + (c & 15);
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }

    public long nextLong() throws IOException {
        int c;
        long val = 0;
        while ((c = scan()) <= 32);
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            val = (val << 3) + (val << 1) + (c & 15);
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }
}