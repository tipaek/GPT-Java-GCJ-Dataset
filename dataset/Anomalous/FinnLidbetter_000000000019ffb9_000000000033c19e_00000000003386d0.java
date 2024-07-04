import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int nTests = Integer.parseInt(br.readLine());
        for (int test = 0; test < nTests; test++) {
            int n = Integer.parseInt(br.readLine());
            Pt[] pts = new Pt[n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                pts[i] = new Pt(x, y);
            }
            int bestHoles = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    long dx = pts[j].x - pts[i].x;
                    long dy = pts[j].y - pts[i].y;
                    UnionFind uf = new UnionFind(n);
                    Map<FracLine, Integer> lineToRoot = new HashMap<>();
                    for (int k = 0; k < n; k++) {
                        FracLine f = new FracLine(pts[k].x, pts[k].y, pts[k].x + dx, pts[k].y + dy);
                        if (lineToRoot.containsKey(f)) {
                            uf.union(k, lineToRoot.get(f));
                        } else {
                            lineToRoot.put(f, k);
                        }
                    }
                    int onesUsed = 0;
                    int nHoles = 0;
                    for (int k = 0; k < n; k++) {
                        if (uf.find(k) == k) {
                            if (uf.getSize(k) > 1) {
                                nHoles += uf.getSize(k);
                            } else {
                                if (onesUsed < 2) {
                                    nHoles++;
                                    onesUsed++;
                                }
                            }
                        }
                    }
                    if (nHoles > bestHoles) {
                        bestHoles = nHoles;
                    }
                }
            }
            sb.append(String.format("Case #%d: %d\n", test + 1, bestHoles));
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
    private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
    BigInteger n, d;

    Frac(BigInteger n, BigInteger d) {
        BigInteger[] normalized = normalize(n, d);
        this.n = normalized[0];
        this.d = normalized[1];
    }

    Frac multiply(Frac other) {
        BigInteger newN = n.multiply(other.n);
        BigInteger newD = d.multiply(other.d);
        return new Frac(newN, newD);
    }

    private BigInteger[] normalize(BigInteger n, BigInteger d) {
        if (n.equals(BigInteger.ZERO)) {
            d = BigInteger.ONE;
        } else {
            BigInteger gcd = n.gcd(d);
            n = n.divide(gcd);
            d = d.divide(gcd);
            if (d.compareTo(BigInteger.ZERO) < 0) {
                n = n.multiply(MINUS_ONE);
                d = d.multiply(MINUS_ONE);
            }
        }
        return new BigInteger[]{n, d};
    }

    Frac reciprocal() {
        return new Frac(d, n);
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
        return n.equals(frac.n) && d.equals(frac.d);
    }
}

class FracLine {
    Frac a, b, c;

    FracLine(long x1, long y1, long x2, long y2) {
        a = new Frac(BigInteger.valueOf(y1 - y2), BigInteger.ONE);
        b = new Frac(BigInteger.valueOf(x2 - x1), BigInteger.ONE);
        c = new Frac(BigInteger.valueOf(x2 * y1 - x1 * y2), BigInteger.ONE);
        Frac reciprocal = a.n.equals(BigInteger.ZERO) ? b.reciprocal() : a.reciprocal();
        a = a.multiply(reciprocal);
        b = b.multiply(reciprocal);
        c = c.multiply(reciprocal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
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
    private final int[] id;
    private final int[] sz;

    public UnionFind(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            sz[rootQ] += sz[rootP];
            id[rootP] = rootQ;
        }
    }

    public int getSize(int p) {
        return sz[find(p)];
    }
}