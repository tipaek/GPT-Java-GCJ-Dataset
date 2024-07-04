import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SecurityUpdate solver = new SecurityUpdate();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class SecurityUpdate {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            int n = in.nextInt(), m = in.nextInt();

            int[] x = new int[n];
            for (int i = 1; i < n; i++) {
                x[i] = in.nextInt();
            }
            int[] from = new int[m], to = new int[m];
            for (int i = 0; i < m; i++) {
                from[i] = in.nextInt() - 1;
                to[i] = in.nextInt() - 1;
            }

            List<Vertex> unknown = new ArrayList<>();
            List<Vertex> known = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (x[i] < 0) {
                    unknown.add(new Vertex(i, -x[i]));
                } else {
                    known.add(new Vertex(i, x[i]));
                }
            }
            Collections.sort(unknown);
            Collections.sort(known);


            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            int usedKnown = 0;
            int lastDist = 0;
            for (int i = 0; i < unknown.size(); ) {
                int j = i;
                while (j < unknown.size() && unknown.get(i).value == unknown.get(j).value) {
                    j++;
                }

                int less = unknown.get(i).value;
                while (i + usedKnown < less) {
                    dist[known.get(usedKnown).id] = known.get(usedKnown).value;
                    lastDist = known.get(usedKnown).value;
                    usedKnown++;
                }

                lastDist++;
                for (int t = i; t < j; t++) {
                    dist[unknown.get(t).id] = lastDist;
                }
                i = j;
            }
            while (usedKnown < known.size()) {
                dist[known.get(usedKnown).id] = known.get(usedKnown).value;
                usedKnown++;
            }

            for (int i = 0; i < m; i++) {
                int edgeLen = Math.abs(dist[from[i]] - dist[to[i]]);
                out.print(Math.max(1, edgeLen) + " ");
            }
            out.println();
        }

        class Vertex implements Comparable<Vertex> {
            int id;
            int value;

            public Vertex(int id, int value) {
                this.id = id;
                this.value = value;
            }

            public int compareTo(Vertex other) {
                return Integer.compare(value, other.value);
            }

        }

    }

    static class FastScanner {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

    }
}

