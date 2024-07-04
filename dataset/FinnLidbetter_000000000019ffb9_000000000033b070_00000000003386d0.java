/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
  
    int nTests = Integer.parseInt(br.readLine());
    for (int test=0; test<nTests; test++) {
      int n = Integer.parseInt(br.readLine());
      Pt[] pts = new Pt[n];
      for (int i=0; i<n; i++) {
        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        pts[i] = new Pt(x,y);
      }
      int bestHoles = 1;
      for (int i=0; i<n; i++) {
        for (int j=0; j<i; j++) {
          long dx = pts[j].x - pts[i].x;
          long dy = pts[j].y - pts[i].y;
          UnionFind uf = new UnionFind(n);
          HashMap<FracLine, Integer> lineToRoot = new HashMap<>();
          for (int k=0; k<n; k++) {
            FracLine f = new FracLine(pts[k].x, pts[k].y, pts[k].x + dx, pts[k].y + dy);
            if (lineToRoot.containsKey(f)) {
              uf.union(k, lineToRoot.get(f));
            } else {
              lineToRoot.put(f, k);
            }
          }
          int onesUsed = 0;
          int nHoles = 0;
          for (int k=0; k<n; k++) {
            if (uf.find(k)==k) {
              if (uf.getSize(k)>1) {
                nHoles += uf.getSize(k);
              } else {
                if (onesUsed<2) {
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
      
      
      sb.append(String.format("Case #%d: %d\n", test+1, bestHoles));
    }
    System.out.print(sb);
  }
  
  static boolean collinear(Pt p1, Pt p2, Pt p3) {
    return ((p2.x-p1.x)*(p3.y-p1.y) - (p2.y-p1.y)*(p3.x-p1.x)) == 0;
  }
}
class Pt {
  long x,y;
  public Pt(long xx, long yy) {
    x = xx;
    y = yy;
  }
}
class Frac {
  long n, d;
  Frac(long nn, long dd) { 
    long[] f = normalise(nn,dd); 
    n = f[0]; 
    d = f[1]; 
  }
  Frac add(Frac f2) { 
    long n2 = n*f2.d + f2.n*d, d2 = d*f2.d; 
    return new Frac(n2,d2); 
  }
  Frac multiply(Frac f2) { 
    long n2 = n*f2.n, d2 = d*f2.d; 
    return new Frac(n2,d2); 
  }
  long[] normalise(long nn, long dd) {
    long n2 = nn, d2 = dd;
    if (n2==0) d2 = 1;
    else {
      long div = gcd(n2, d2); n2 /= div; d2 /= div;
      if (d2<0) { 
        n2*=-1; d2*=-1; 
      } 
    }
    long[] f = {n2,d2}; return f; }
  Frac reciprocal() { 
    return new Frac(d,n); 
  }
  static long gcd(long a, long b) {
    return b == 0 ? (a<0?-a:a) : gcd(b, a % b); 
  }
  public int hashCode() {
    return Objects.hash(n,d);
  }
  public boolean equals(Object o) {
    Frac f2 = (Frac) o;
    return n==f2.n && d==f2.d;
  }
}
class FracLine {
  Frac a, b, c;
  FracLine(long x1, long y1, long x2, long y2) {
    a = new Frac(y1-y2,1); 
    b = new Frac(x2-x1,1); 
    c = new Frac(x2*y1 - x1*y2, 1); 
    Frac r = null;
    if (a.n!=0) 
      r = a.reciprocal(); 
    else 
      r = b.reciprocal();
    a = a.multiply(r); 
    b = b.multiply(r); 
    c = c.multiply(r); 
  }
  public int hashCode() {
    return Objects.hash(a.n, a.d, b.n, b.d, c.n, c.d);
  }
  public boolean equals(Object o) {
      FracLine l2 = (FracLine)o;
      return a.equals(l2.a) && b.equals(l2.b) && c.equals(l2.c);
  }
}
class UnionFind {
  int[] id, sz;
  public UnionFind(int n) {
    id = new int[n]; sz = new int[n];
    for (int i = 0; i < n; i++) { id[i] = i; sz[i] = 1; } }
  int find(int p) {
    int rt = p;
    while (rt != id[rt]) rt = id[rt];
    while (p != rt) { int next = id[p]; id[p] = rt; p = next; }
    return rt; }
  boolean connected(int p, int q) { return find(p) == find(q); }
  int getSize(int p) { return sz[find(p)]; }
  int countSets() {
    int nSets = 0;
    for (int i = 0; i < id.length; i++) if (id[i] == i) nSets++;
    return nSets; }
  void union(int p, int q) {
    int r1 = find(p), r2 = find(q);
    if (r1 == r2) return;
    sz[r2] += sz[r1]; id[r1] = r2; 
  } 
}

