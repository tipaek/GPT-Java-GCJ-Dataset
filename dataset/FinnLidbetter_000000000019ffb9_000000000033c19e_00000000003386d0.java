/**
 * @author Finn Lidbetter
 */
import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.math.*;

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
          //System.out.printf("Using pair (%d, %d), (%d, %d)\n", pts[i].x, pts[i].y, pts[j].x, pts[j].y);
          int onesUsed = 0;
          int nHoles = 0;
          for (int k=0; k<n; k++) {
            if (uf.find(k)==k) {
              if (uf.getSize(k)>1) {
                nHoles += uf.getSize(k);
                //System.out.printf("\tAdding %d collinear with (%d, %d)\n", uf.getSize(k), pts[k].x, pts[k].y);
              } else {
                if (onesUsed<2) {
                  //System.out.printf("\tAdding 1 for (%d, %d)\n", pts[k].x, pts[k].y);
                  nHoles++;
                  onesUsed++;
                }
              }
            }
          }
          //System.out.printf("Got %d\n", nHoles);
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
  static BigInteger MINUS_ONE = new BigInteger("-1");
  BigInteger n, d;
  /*
  Frac(long nn, long dd) { 
    BigInteger[] f = normalise(new BigInteger(""+nn), new BigInteger(""+dd)); 
    n = f[0]; 
    d = f[1]; 
  }
  */
  Frac(BigInteger nn, BigInteger dd) {
    BigInteger[] f = normalise(nn,dd); 
    n = f[0]; 
    d = f[1]; 
  }
  /*
  Frac add(Frac f2) { 
    long n2 = n*f2.d + f2.n*d, d2 = d*f2.d; 
    return new Frac(n2,d2); 
  }
  */
  Frac multiply(Frac f2) { 
    BigInteger n2 = n.multiply(f2.n);
    BigInteger d2 = d.multiply(f2.d); 
    return new Frac(n2,d2); 
  }
  BigInteger[] normalise(BigInteger nn, BigInteger dd) {
    BigInteger n2 = nn, d2 = dd;
    if (n2.compareTo(BigInteger.ZERO)==0) 
      d2 = BigInteger.ONE;
    else {
      BigInteger div = gcd(n2, d2); 
      n2 = n2.divide(div); 
      d2 = d2.divide(div);
      if (d2.compareTo(BigInteger.ZERO)<0) { 
        n2 = n2.multiply(MINUS_ONE);
        d2 = d2.multiply(MINUS_ONE);
        //n2*=-1; 
        //d2*=-1; 
      } 
    }
    BigInteger[] f = {n2,d2}; return f; }
  Frac reciprocal() { 
    return new Frac(d,n); 
  }
  static BigInteger gcd(BigInteger a, BigInteger b) {
    if (b.compareTo(BigInteger.ZERO)==0) {
      if (a.compareTo(BigInteger.ZERO)<0) 
        return a.multiply(MINUS_ONE);
      return a;
    }
    if (b.compareTo(BigInteger.ZERO) < 0) {
      b = b.multiply(MINUS_ONE);
    }
    return gcd(b, a.mod(b));
  }
  public int hashCode() {
    return Objects.hash(n,d);
  }
  public boolean equals(Object o) {
    Frac f2 = (Frac) o;
    return n.compareTo(f2.n)==0 && d.compareTo(f2.d)==0;
  }
}
class FracLine {
  Frac a, b, c;
  FracLine(long x1, long y1, long x2, long y2) {
    a = new Frac(new BigInteger(""+(y1-y2)), BigInteger.ONE); 
    b = new Frac(new BigInteger(""+(x2-x1)), BigInteger.ONE); 
    c = new Frac(new BigInteger(""+(x2*y1 - x1*y2)), BigInteger.ONE); 
    Frac r = null;
    if (a.n.compareTo(BigInteger.ZERO)!=0) 
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
      FracLine l2 = (FracLine) o;
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

