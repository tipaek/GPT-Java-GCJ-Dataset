import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static class P {
        int i, j, v;
        boolean el;
        P u, r, l, d;

        public P(int i, int j, int v) {
            this.i = i;
            this.j = j;
            this.v = v;
        }

        void lost() {
            int neigh = 0;
            int s = 0;
            for (P p : new P[]{u, r, l, d}) {
                if (p != null) {
                    s += p.v;
                    neigh++;
                }
            }
            el = (s > neigh * v);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            ArrayList<P> p = new ArrayList<>(n * m);
            P[][] pa = new P[n][];
            for (int i1 = 0; i1 < n; i1++) {
                pa[i1] = new P[m];
                String[] line = sc.nextLine().split(" ");
                for (int i2 = 0; i2 < m; i2++) {
                    P pp = new P(i1, i2, Integer.parseInt(line[i2]));
                    pa[i1][i2] = pp;
                    p.add(pp);

                    if (i2 > 0) {
                        pp.l = pa[i1][i2 - 1];
                        pa[i1][i2 - 1].r = pp;
                    }
                    if (i1 > 0) {
                        pp.u = pa[i1 - 1][i2];
                        pa[i1 - 1][i2].d = pp;
                    }
                }
            }

            BigInteger answ = BigInteger.ZERO;
            boolean changed = true;
            while (changed) {
                for (P pp : p) {
                    answ = answ.add(BigInteger.valueOf(pp.v));
                }
                changed = false;

                ArrayList<P> newP = new ArrayList<>(p.size());
                for (P pp : p) {
                    pp.lost();
                }
                for (P pp : p) {
                    if (pp.el) {
                        changed = true;
                        if (pp.r != null) pp.r.l = pp.l;
                        if (pp.d != null) pp.d.u = pp.u;
                        if (pp.u != null) pp.u.d = pp.d;
                        if (pp.l != null) pp.l.r = pp.r;
                    } else {
                        newP.add(pp);
                    }
                }
                p = newP;
            }

            System.out.printf("Case #%d: %s%n", i + 1, answ.toString());
        }
    }
}
