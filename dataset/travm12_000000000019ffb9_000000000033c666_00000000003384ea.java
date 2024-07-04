
import java.util.*;
import java.io.*;

public class Solution {
    public static PrintWriter out;

    public static long[] goSlow(long l, long r) {
        long rr = r;
        long ll = l;
        int i = 1;
        while (rr >= i || ll >= i) {
            if (rr > ll) {
                rr -= i;
                i++;
            } else {
                ll -= i;
                i++;
            }
        }
        return new long[]{ll, rr, i - 1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt(), cc = 0;
        Random rand = new Random();
        while (t-->0) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            //long l = rand.nextInt(1000);
            //long r = rand.nextInt(1000);
            //long[] slow = goSlow(l, r);
            long or = r;
            long ol = l;
            boolean swap = false;
            if (r < l) {
                r ^= l;
                l ^= r;
                r ^= l;
                swap = true;
            }
            long delta = r - l;
            long st = getCust(delta);
            long rSt = st + 1;
            long lSt = st + 2;
            r -= (st*(st+1))>>1;
            if (r == l && !swap) {
                swap = !swap;
            }
            
            long rAdd = (comp2(rSt, r)<<1)-1;
            if (rAdd < 0) rAdd = 0;
            long lAdd = comp2(lSt, l)<<1;
            long trueAdd = rAdd;
            //out.println(rAdd +" " +lAdd +" " +st);
            if (trueAdd < lAdd)
                trueAdd = lAdd;
            l -= comp(lSt, lAdd>>1);
            r -= comp(rSt, (rAdd+1)>>1);
            if (swap) {
                r ^= l;
                l ^= r;
                r ^= l;
            }
            long ans = st + trueAdd;
            //if (slow[2] != ans || slow[0] != l || slow[1] != r) {
            //    out.println(ol +" "+ or);
            //}
            out.printf("Case #%d: %d %d %d%n", ++cc, ans, l,  r);
        }
        out.close();
    }

    public static long comp(long st, long dur) {
        long off = (st>>1) * (st>>1);
        long total = ((st>>1)+dur)*((st>>1)+dur);
        if ((1&st) == 0) {
            off = (st>>1) * ((st>>1) - 1);
            total = ((st>>1)+dur)*((st>>1)+dur-1);
        }
        return total - off;
    }

    public static long comp2(long st, long amt) {
        long lo = 0;
        long hi = 1;
        long ans = 0;
        //out.println(st +" " +amt);
        while (comp(st, hi) <= amt) {
            ans = hi;
            lo = hi + 1;
            hi *= 2;
        }
        while (lo <= hi) {
            long m = (lo + hi) >> 1;
            if (comp(st, m) <= amt) {
                ans = m;
                lo = m + 1;
            }
            else {
                hi = m - 1;
            }
        }
        //out.println(ans);
        return ans;
    }

    public static long getCust(long delta) {
        long ans = 0;
        long hi = 1;
        long lo = 0;
        while (((hi * (hi + 1)) >> 1) <= delta) {
            ans = hi;
            lo = hi + 1;
            hi *= 2;
        }
        while (hi >= lo) {
            long m = (lo + hi) >> 1;
            if (((m * (m + 1)) >> 1) <= delta) {
                ans = m;
                lo = m + 1;
            }
            else {
                hi = m - 1;
            }
        }
        return ans;
    }

    public static boolean check(String ans, String sub) {
        if (sub.equals(ans)) return true;
        int n = sub.length();
        int n2 = ans.length();
        int pos = 0;
        for (int i = 0; i < n; i++){
            int j = i;
            if (sub.charAt(i) == '*') continue;
            while (j < n && sub.charAt(j) != '*')
                j++;
            int nn = j - i;
            while (pos < n2 && !ans.substring(pos).startsWith(sub.substring(i,j)))
                pos++;
            if (pos == n2)
                return false;
            pos += nn;
            i = j - 1;
        }
        return true;
    }
    public static String getPref(String a) {
        if (a.length() == 0 || a.charAt(0) == '*')
            return "";
        return a.charAt(0) + getPref(a.substring(1));
    }
    public static String getSuff(String a) {
        int n = a.length() - 1;
        if (a.length() == 0 || a.charAt(n) == '*')
            return "";
        return getSuff(a.substring(0,n)) + a.charAt(n);
    }
}