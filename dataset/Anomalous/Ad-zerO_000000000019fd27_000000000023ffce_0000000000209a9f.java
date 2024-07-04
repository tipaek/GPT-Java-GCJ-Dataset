import java.util.*;
import java.io.*;

public class Solution {
    
    public static int fun(int p, int n, int[][] a, int[][] dp) {
        if (p == 0 || n < 0)
            return 0;
        if (dp[p][n] > 0)
            return dp[p][n];
        
        int maxVal = Math.max(fun(p, n - 1, a, dp), 0);
        for (int i = 0; i < a[n].length; i++) {
            if (p - i - 1 >= 0)
                maxVal = Math.max(a[n][i] + fun(p - i - 1, n - 1, a, dp), maxVal);
            else
                break;
        }
        return dp[p][n] = maxVal;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int q = sc.nextInt();
        sc.nextLine();
        
        for (int p = 1; p <= q; p++) {
            String s = sc.nextLine();
            StringBuilder out = new StringBuilder();
            int openBrackets = 0;
            
            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                while (openBrackets > digit) {
                    out.append(")");
                    openBrackets--;
                }
                while (openBrackets < digit) {
                    out.append("(");
                    openBrackets++;
                }
                out.append(s.charAt(i));
            }
            while (openBrackets > 0) {
                out.append(")");
                openBrackets--;
            }
            System.out.println("Case #" + p + ": " + out);
        }
    }

    public static Comparator<Pair> getComparator() {
        return new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int comp = o2.a.compareTo(o1.a);
                if (comp == 0)
                    return o2.in.compareTo(o1.in);
                return comp;
            }
        };
    }
}

class Pair {
    Integer a;
    Integer in;

    Pair(int a, int in) {
        this.a = a;
        this.in = in;
    }
}

class SegmentTree {
    int[] s;
    int n;

    SegmentTree(int[] a) {
        n = a.length;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int size = 2 * (int) Math.pow(2, height) - 1;
        s = new int[size];
        createSegmentTree(a, 0, 0, n - 1);
    }

    int createSegmentTree(int[] a, int root, int l, int r) {
        if (l == r)
            s[root] = a[l];
        else {
            int mid = (l + r) / 2;
            s[root] = Math.min(createSegmentTree(a, 2 * root + 1, l, mid), 
                               createSegmentTree(a, 2 * root + 2, mid + 1, r));
        }
        return s[root];
    }

    int getValue(int gl, int gr) {
        return getValueUtil(0, 0, n - 1, gl, gr);
    }

    int getValueUtil(int root, int l, int r, int gl, int gr) {
        if (l >= gl && r <= gr)
            return s[root];
        if (l > gr || r < gl)
            return Integer.MAX_VALUE;
        
        int mid = (l + r) / 2;
        return Math.min(getValueUtil(2 * root + 1, l, mid, gl, gr), 
                        getValueUtil(2 * root + 2, mid + 1, r, gl, gr));
    }

    void update(int p, int k) {
        updateUtil(p, k, 0, 0, n - 1);
    }

    int updateUtil(int p, int k, int root, int l, int r) {
        if (l == r && l == k) {
            return s[root] = p;
        } else if (l > k || r < k) {
            return s[root];
        } else {
            int mid = (l + r) / 2;
            return s[root] = Math.min(updateUtil(p, k, 2 * root + 1, l, mid), 
                                      updateUtil(p, k, 2 * root + 2, mid + 1, r));
        }
    }
}