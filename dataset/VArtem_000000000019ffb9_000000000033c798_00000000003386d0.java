import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.OptionalInt;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.PrintWriter;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.List;
import java.util.stream.Stream;
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
        WormholeInOne solver = new WormholeInOne();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class WormholeInOne {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            int n = in.nextInt();
            Point[] a = new Point[n];
            for (int i = 0; i < n; i++) {
                a[i] = new Point(in.nextInt(), in.nextInt());
            }
            if (n == 1) {
                out.println(1);
                return;
            }
            Map<Point, List<Integer>> dirs = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    Point dir = new Point(a[i], a[j]);
                    dir.normalize();
                    if (!dirs.containsKey(dir)) {
                        dirs.put(dir, new ArrayList<>());
                    }
                    dirs.get(dir).add(i * n + j);
                }
            }

            DSU dsu = new DSU(n);
            int ans = dirs.values().stream().mapToInt(integers -> {
                dsu.clear();
                for (int pair : integers) {
                    dsu.unite(pair / n, pair % n);
                }
                List<Integer> sizes = new ArrayList<>();
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if (dsu.get(i) == i) {
                        if (dsu.size[i] % 2 == 0) {
                            sum += dsu.size[i];
                        } else {
                            sizes.add(dsu.size[i]);
                        }
                    }
                }
                Collections.sort(sizes);
                Collections.reverse(sizes);
                for (int i = 0; i < sizes.size(); i += 2) {
                    if (i == sizes.size() - 1) {
                        sum += sizes.get(i);
                        break;
                    }
                    sum += sizes.get(i) + sizes.get(i + 1);
                    if (sizes.get(i + 1) == 1) {
                        break;
                    }
                }

                return sum;
            }).max().getAsInt();
            out.println(ans);
        }

        class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public Point(Point a, Point b) {
                this.x = b.x - a.x;
                this.y = b.y - a.y;
            }

            void normalize() {
                int g = Math.abs(MathUtils.gcd(x, y));
                x /= g;
                y /= g;
                if (x < 0 || x == 0 && y < 0) {
                    x *= -1;
                    y *= -1;
                }
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x &&
                        y == point.y;
            }

            public int hashCode() {
                return Objects.hash(x, y);
            }

            public String toString() {
                return "Point{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
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

    static class MathUtils {
        public static int gcd(int a, int b) {
            int t;
            while (a != 0) {
                t = b % a;
                b = a;
                a = t;
            }
            return b;
        }

    }

    static class DSU {
        int[] parent;
        int[] rank;
        public int[] size;
        public int sets;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            this.sets = n;
        }

        public int get(int v) {
            if (parent[v] == v) {
                return v;
            }
            return parent[v] = get(parent[v]);
        }

        public boolean unite(int u, int v) {
            u = get(u);
            v = get(v);
            if (u == v) {
                return false;
            }
            sets--;
            if (rank[u] == rank[v]) {
                rank[u]++;
            }
            if (rank[u] > rank[v]) {
                parent[v] = u;
                size[u] += size[v];
            } else {
                parent[u] = v;
                size[v] += size[u];
            }
            return true;
        }

        public void clear() {
            Arrays.fill(rank, 0);
            Arrays.fill(size, 1);
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            this.sets = parent.length;
        }

    }
}

