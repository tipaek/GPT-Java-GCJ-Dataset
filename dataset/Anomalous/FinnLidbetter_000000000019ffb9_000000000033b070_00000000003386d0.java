import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int nTests = Integer.parseInt(br.readLine());
        for (int test = 0; test < nTests; test++) {
            int n = Integer.parseInt(br.readLine());
            Pt[] points = new Pt[n];
            for (int i = 0; i < n; i++) {
                String[] coordinates = br.readLine().split(" ");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                points[i] = new Pt(x, y);
            }

            int maxHoles = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    long dx = points[j].x - points[i].x;
                    long dy = points[j].y - points[i].y;
                    UnionFind uf = new UnionFind(n);
                    Map<FracLine, Integer> lineToRoot = new HashMap<>();

                    for (int k = 0; k < n; k++) {
                        FracLine line = new FracLine(points[k].x, points[k].y, points[k].x + dx, points[k].y + dy);
                        if (lineToRoot.containsKey(line)) {
                            uf.union(k, lineToRoot.get(line));
                        } else {
                            lineToRoot.put(line, k);
                        }
                    }

                    int singlePoints = 0;
                    int holes = 0;
                    for (int k = 0; k < n; k++) {
                        if (uf.find(k) == k) {
                            if (uf.getSize(k) > 1) {
                                holes += uf.getSize(k);
                            } else {
                                if (singlePoints < 2) {
                                    holes++;
                                    singlePoints++;
                                }
                            }
                        }
                    }
                    if (holes > maxHoles) {
                        maxHoles = holes;
                    }
                }
            }
            sb.append(String.format("Case #%d: %d\n", test + 1, maxHoles));
        }
        System.out.print(sb);
    }
}

class Pt {
    long x, y;

    public Pt(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Frac {
    long n, d;

    Frac(long n, long d) {
        long[] normalized = normalize(n, d);
        this.n = normalized[0];
        this.d = normalized[1];
    }

    Frac add(Frac other) {
        long newN = n * other.d + other.n * d;
        long newD = d * other.d;
        return new Frac(newN, newD);
    }

    Frac multiply(Frac other) {
        long newN = n * other.n;
        long newD = d * other.d;
        return new Frac(newN, newD);
    }

    long[] normalize(long n, long d) {
        if (n == 0) {
            d = 1;
        } else {
            long gcd = gcd(n, d);
            n /= gcd;
            d /= gcd;
            if (d < 0) {
                n *= -1;
                d *= -1;
            }
        }
        return new long[]{n, d};
    }

    Frac reciprocal() {
        return new Frac(d, n);
    }

    static long gcd(long a, long b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, d);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Frac frac = (Frac) obj;
        return n == frac.n && d == frac.d;
    }
}

class FracLine {
    Frac a, b, c;

    FracLine(long x1, long y1, long x2, long y2) {
        a = new Frac(y1 - y2, 1);
        b = new Frac(x2 - x1, 1);
        c = new Frac(x2 * y1 - x1 * y2, 1);
        Frac r = a.n != 0 ? a.reciprocal() : b.reciprocal();
        a = a.multiply(r);
        b = b.multiply(r);
        c = c.multiply(r);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a.n, a.d, b.n, b.d, c.n, c.d);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FracLine fracLine = (FracLine) obj;
        return a.equals(fracLine.a) && b.equals(fracLine.b) && c.equals(fracLine.c);
    }
}

class UnionFind {
    int[] parent, size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        return root;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int getSize(int p) {
        return size[find(p)];
    }

    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        size[rootQ] += size[rootP];
        parent[rootP] = rootQ;
    }
}