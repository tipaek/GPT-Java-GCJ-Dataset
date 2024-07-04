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
                    HashMap<FracLine, Integer> lineToRoot = new HashMap<>();
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
    static final BigInteger MINUS_ONE = new BigInteger("-1");
    BigInteger n, d;

    Frac(BigInteger n, BigInteger d) {
        BigInteger[] f = normalize(n, d);
        this.n = f[0];
        this.d = f[1];
    }

    Frac multiply(Frac f2) {
        BigInteger n2 = n.multiply(f2.n);
        BigInteger d2 = d.multiply(f2.d);
        return new Frac(n2, d2);
    }

    BigInteger[] normalize(BigInteger n, BigInteger d) {
        if (n.equals(BigInteger.ZERO)) {
            d = BigInteger.ONE;
        } else {
            BigInteger div = gcd(n, d);
            n = n.divide(div);
            d = d.divide(div);
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

    static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return a.compareTo(BigInteger.ZERO) < 0 ? a.multiply(MINUS_ONE) : a;
        }
        if (b.compareTo(BigInteger.ZERO) < 0) {
            b = b.multiply(MINUS_ONE);
        }
        return gcd(b, a.mod(b));
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frac frac = (Frac) o;
        return n.equals(frac.n) && d.equals(frac.d);
    }

    @Override
    public String toString() {
        return String.format("%s/%s", n, d);
    }
}

class FracLine {
    Frac a, b, c;

    FracLine(long x1, long y1, long x2, long y2) {
        BigInteger bx1 = BigInteger.valueOf(x1);
        BigInteger by1 = BigInteger.valueOf(y1);
        BigInteger bx2 = BigInteger.valueOf(x2);
        BigInteger by2 = BigInteger.valueOf(y2);
        a = new Frac(by1.subtract(by2), BigInteger.ONE);
        b = new Frac(bx2.subtract(bx1), BigInteger.ONE);
        c = new Frac(bx2.multiply(by1).subtract(bx1.multiply(by2)), BigInteger.ONE);
        Frac r = a.n.equals(BigInteger.ZERO) ? b.reciprocal() : a.reciprocal();
        a = a.multiply(r);
        b = b.multiply(r);
        c = c.multiply(r);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FracLine fracLine = (FracLine) o;
        return a.equals(fracLine.a) && b.equals(fracLine.b) && c.equals(fracLine.c);
    }

    @Override
    public String toString() {
        return String.format("%sX + %sY = %s", a, b, c);
    }
}

class UnionFind {
    int[] id, sz;

    public UnionFind(int n) {
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    int find(int p) {
        int root = p;
        while (root != id[root]) root = id[root];
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    int getSize(int p) {
        return sz[find(p)];
    }

    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP != rootQ) {
            sz[rootQ] += sz[rootP];
            id[rootP] = rootQ;
        }
    }
}