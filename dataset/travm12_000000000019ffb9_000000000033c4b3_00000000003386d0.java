
import java.util.*;
import java.io.*;

public class Solution {
    public static PrintWriter out;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt(), cc = 0;
        while (t-->0) {
            int n = sc.nextInt();
            long[][] vals = new long[2][n];
            for (int i = 0; i < n; i++) {
                vals[0][i] = sc.nextLong();
                vals[1][i] = sc.nextLong();
            }
            int ans = 1;
            for (int i = 0; i < n; i++){ 
                for (int j = i + 1; j < n; j++) {
                    long dx = vals[1][i] - vals[1][j];
                    long dy = vals[0][j] - vals[0][i];
                    HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
                    int singles = 0;
                    for (int k = 0; k < n; k++) {
                        long key = dx * vals[0][k] + dy * vals[1][k];
                        if (!hm.containsKey(key)) {
                            hm.put(key, 0);
                            singles++;
                        } else if (hm.get(key) == 1)
                            singles--;
                        hm.put(key, hm.get(key) + 1);
                    }
                    int tans = 0;
                    int odds = 0;
                    for (long x : hm.keySet()) {
                        int tmp = hm.get(x);
                        if (tmp > 1 && (tmp&1) == 1)
                            odds++;
                    }
                    singles += (odds & 1);
                    tans = (n - singles) + 2;
                    if (tans > n)
                        tans = n;
                    if (tans > ans)
                        ans = tans;
                }
            }
            out.printf("Case #%d: %d%n", ++cc, ans);
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