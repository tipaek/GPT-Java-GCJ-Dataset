
import java.util.*;
import java.io.*;

public class Solution {
    public static boolean DEBUG = false;
    public static PrintWriter out;


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out2 = null;
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt(), cc = 0;
        Random rand = new Random(11234);
        while (t-->0) {
            int n, e;
            if (DEBUG) {
                n = 100;
                e = 0;
                out2 = new PrintWriter(new FileWriter(new File("broken.in")));
                out2.println(1);
                out2.println(100 + " " + 0);
            } else {
                n = sc.nextInt();
                e = sc.nextInt();
            }

            int[] dist = new int[n];
            int oo = 987654321;
            Arrays.fill(dist, oo);
            dist[0] = 0;
            int[] index = new int[n];
            int lastTime = 0;
            int[] vals = null;
            if (DEBUG)  {
                vals = new int[n];
                for (int i = 0; i < n; i++)
                    vals[i] = rand.nextInt(2000) + 1;
                vals[0] = 0;
                System.out.println(cc);
            }
            for (int i = 1; i < n; i++) {
                int a = 0;

                
                if (DEBUG) {
                    a = vals[i];
                    if (rand.nextBoolean()) {
                        a = 0;
                        for (int j = 0; j < n; j++)
                            if (vals[j] < vals[i])
                                a--;
                    }
                    out2.println(a);
                } else {
                    a = sc.nextInt();
                }

                if (a < 0) {
                    index[i] = -a;
                } else {
                    dist[i] = a;
                }
            }
            if (DEBUG)
                out2.close();
            int i = 1;
            int last = 0;
            while (i != n) {
                int ii = i;
                int cur = last + 1;
                for (int j = 0; j < n; j++) {
                    if (index[j] <= ii && dist[j] == oo) {
                        dist[j] = cur;
                        i++;
                    } else if (dist[j] == cur) {
                        i++;
                    }
                }
                if (i == ii) {
                    int min = oo;
                    for (int j = 0; j < n; j++) {
                        if (min > dist[j] && dist[j] >= cur)
                            min = dist[j];
                    }
                    for (int j = 0; j < n; j++) {
                        if (dist[j] == min)
                            i++;
                    }
                    cur = min;
                    if (min == oo) {
                        System.out.println(Arrays.toString(vals));
                        System.out.println(Arrays.toString(dist));
                        throw new Exception("Failure");
                    }
                }
                last = cur;
            }
            out.printf("Case #%d:", ++cc);
            for (i = 0; i < e; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                int ans = dist[a] - dist[b];
                if (ans < 0)
                    ans = -ans;
                if (ans == 0)
                    ans = 1;
                out.printf(" %d", ans);
            }
            out.printf("%n");

        }
        out.close();
    }

    public static class Pair implements Comparable<Pair> {
        int order, index;
        Pair(int oo, int ii) {
            order = oo;
            index = ii;
        }
        public int compareTo(Pair o) {
            return order - o.order;
        }
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