
import java.util.*;
import java.io.*;

public class Solution {
    public static PrintWriter out;
    public static int n;
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt(), cc = 0;
        while (t-->0) {
            n = sc.nextInt();
            int tr = sc.nextInt();
            out.printf("Case #%d: ", ++cc);
            if (n + 1 == tr || (n * n - 1) == tr ||
                (n==3 && tr % 3 != 0)) {
                out.println("IMPOSSIBLE");
                continue;
            }
            out.println("POSSIBLE");
            int[][] ans = new int[n][n];
            if (tr%n == 0) {
                int[][] res = simple(tr / n);
                print(res);
                continue;
            }
            int st = -1;
            int mi = -1;
            int en = -1;
            for (int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++) {
                    for (int k = j + 1; k <= n; k++) {
                        if (i == j || k == i)
                            continue;
                        if (i * (n-2) + j + k == tr) {
                            st = i;
                            mi = k;
                            en = j;
                        } 
                    }
                }
            if (st != -1) {
                int[][] res = simple(st);
                swap(res, 0, 1);
                map(res, res[0][0], mi);
                map(res, res[1][1], en);
                print(res);
                continue;
            }
            for (int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++) {
                    if (i == j)
                        continue;
                    if (i * (n-2) + j + j == tr) {
                        st = i;
                        en = j;
                    }
                }
            int[][] res = hard(st, en);
            print(res);
        }

        out.close();
    }

    public static int[][] hard(int a, int b) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n - 2; i++) {
            res[i][i] = a;
            res[i][i+1] = b;
        }
        res[n-3][n-2] = 0;
        res[n-3][0] = b;
        res[n-2][n-2] = b;
        res[n-2][n-1] = a;
        res[n-1][n-1] = b;
        res[n-1][n-2] = a;

        for (int i = 1; i <= n; i++) {
            if (i == a || i == b)
                continue;
            Matching m = new Matching(n * 2);
            for (int j =0; j < n; j++)
                for (int k = 0; k < n; k++)
                    if (res[j][k] == 0)
                        m.add(j, k + n);
            m.run();
            for (int j = 0; j < n; j++)
                res[j][m.match[j] - n] = i;
        }

        return res;
    }

    public static void print(int[][] a){
        for(int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                out.printf("%d%s", a[i][j], j == n - 1 ? "\n" : " ");
    }
    public static void map(int[][] res, int a1, int a2) {
        if (a1 == a2)
            return;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (res[i][j] == a1 || res[i][j] == a2)
                    res[i][j] ^= (a1 ^ a2);
    }
    public static void swap(int[][] res, int c1, int c2) {
        for (int i = 0; i < n; i++) {
            res[i][c2] ^= res[i][c1];
            res[i][c1] ^= res[i][c2];
            res[i][c2] ^= res[i][c1];
        }
    }
    public static int[][] simple(int st) {
        int cur = st, i, j, k;
        int[][] ret = new int[n][n];
        for (i = 0; i < n; i++) {
            k = cur;
            for(j = 0; j < n; j++) {
                ret[i][j] = k++;
                if (k == n + 1)
                    k = 1;
            }
            cur += n - 1;
            if (cur > n)
                cur -= n;
        }
        return ret;
    }

public static class Matching {
  Set<Integer>[] g;
  int n, m = 0;
  int[] match, parent;
  Matching(int N) {
    g = new Set[n=N];
    for(int i=0; i<n; i++) g[i] = new HashSet<Integer>();
    Arrays.fill(parent = new int[n], -1);
    Arrays.fill(match = new int[n], -1);
  }
  void add(int x, int y) {
    g[x].add(y); g[y].add(x);
  }
  int run() {
    while(augment(getPath(g))) m++;
    return m;
  }
  ArrayDeque<Integer> getPath(Set<Integer>[] g) {
    int[] d = new int[n], root = new int[n];
    ArrayDeque<Integer> q = new ArrayDeque<Integer>();
    for(int i=0; i<n; i++) 
      if(match[i] == -1) q.add(root[i] = i);
      else root[i]=d[i]=n+1;
    while(!q.isEmpty()) {
      int cur = q.poll();
      for(int x : d[cur]%2 == 0 ? g[cur] : Arrays.asList(match[cur])) {
        if(x == cur) continue;
        if(d[x] > d[cur]+1) {
          d[x] = d[cur]+1;
          root[x] = root[parent[x] = cur];
          q.add(x);
        }
        else if(d[cur] == d[x] && ((d[cur]%2 == 0) ^ (match[cur]==x))) {
          if(root[cur] == root[x]) {
            List<Integer> b = new ArrayList<Integer>(getPath(x, cur));
            Set<Integer> bset = new HashSet<Integer>(b); // blossom
            cur = parent[b.get(0)];

            Set<Integer>[] g2 = new Set[n];
            for(int i=0; i<n; i++) g2[i] = new HashSet<Integer>();
            for(int i=0; i<n; i++) for(int j : g[i]) 
              g2[bset.contains(i)?cur:i].add(bset.contains(j)?cur:j);

            ArrayDeque<Integer> path = getPath(g2);
            if(path.isEmpty()) return path;

            ArrayDeque<Integer> ret = new ArrayDeque<Integer>();
            ArrayDeque<Integer> tmp = new ArrayDeque<Integer>();
            int z = path.pop(), ind=0;
            ret.add(z);
            for(int prev = z; !path.isEmpty(); ret.add(prev=z)) 
              if(!g[prev].contains(z = path.pop())) {
                for(int i=0; i<b.size(); i++)
                  if(g[prev==cur?z:prev].contains(b.get(i)))
                    ind = i;
                if(ind%2==0) while(ind < b.size()) tmp.add(b.get(ind++));
                else while(ind >= 0) tmp.add(b.get(ind--));

                while(!tmp.isEmpty())
                  ret.add(prev==cur ? tmp.pollLast() : tmp.pollFirst());  
              }
            return ret;
          }
          else return getPath(cur, x);
        }
      }
    }
    return new ArrayDeque<Integer>();
  }
  ArrayDeque<Integer> getPath(int s, int t) {
    ArrayDeque<Integer> ret = new ArrayDeque<Integer>();
    for(int x = s, y = t; x != y; x = parent[x], y = parent[y]) {
      ret.push(x); ret.add(y);
    }
    return ret;
  }
  boolean augment(ArrayDeque<Integer> path) {
    if(path.isEmpty()) return false;
    while(!path.isEmpty()) {
      int x = path.pop(), y = path.pop();
      match[match[x] = y] = x;
    }
    return true;
  }
}
}