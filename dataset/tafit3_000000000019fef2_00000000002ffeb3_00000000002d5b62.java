import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.copyOfRange;

public class Solution {
    BufferedReader rd;

    Solution() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        compute();
    }

    private void compute() throws IOException {
        int n = pint();
        for(int i=1;i<=n;i++) {
            out("Case #" + i + ": " + solve());
        }
    }

    private String solve() throws IOException {
        long[] a = longarr();
        return solve2(a[0], a[1]);
    }

    private String solve2(long x, long y) {
        return translate(solve3(x,y));
    }

    private int[] solve3(long x, long y) {
        int[] res = new int[31];
        for(int i=1;i<=31;i++) {
            long cx = x;
            long cy = y;
            long step = 1L<<(i-1);
            for(int k=0;k<i;k++) {
                int p = i-1-k;
                if(Math.abs(cx) > Math.abs(cy)) {
                    if(cx > 0) {
                        res[p] = 2;
                        cx -= step;
                    } else {
                        res[p] = 3;
                        cx += step;
                    }
                } else {
                    if(cy > 0) {
                        res[p] = 0;
                        cy -= step;
                    } else {
                        res[p] = 1;
                        cy += step;
                    }
                }
                step >>= 1;
            }
            if(cx == 0 && cy == 0) {
                return copyOfRange(res, 0, i);
            }
        }
        return null;
    }

    private static final char[] dir = "NSEW".toCharArray();

    private String translate(int[] v) {
        if(v == null) {
            return "IMPOSSIBLE";
        }
        StringBuilder buf = new StringBuilder();
        for (int i: v) {
            buf.append(dir[i]);
        }
        return buf.toString();
    }

    private int pint() throws IOException {
        return pint(rd.readLine());
    }

    private int pint(String s) {
        return Integer.parseInt(s);
    }

    private long[] longarr() throws IOException {
        return longarr(rd.readLine());
    }

    private long[] longarr(String s) {
        String[] q = split(s);
        int n = q.length;
        long[] a = new long[n];
        for(int i=0;i<n;i++) {
            a[i] = Long.parseLong(q[i]);
        }
        return a;
    }

    public String[] split(String s) {
        if(s == null) {
            return new String[0];
        }
        int n = s.length();
        int start = -1;
        int end = 0;
        int sp = 0;
        boolean lastWhitespace = true;
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if(isWhitespace(c)) {
                lastWhitespace = true;
            } else {
                if(lastWhitespace) {
                    sp++;
                }
                if(start == -1) {
                    start = i;
                }
                end = i;
                lastWhitespace = false;
            }
        }
        if(start == -1) {
            return new String[0];
        }
        String[] res = new String[sp];
        int last = start;
        int x = 0;
        lastWhitespace = true;
        for(int i=start;i<=end;i++) {
            char c = s.charAt(i);
            boolean w = isWhitespace(c);
            if(w && !lastWhitespace) {
                res[x++] = s.substring(last,i);
            } else if(!w && lastWhitespace) {
                last = i;
            }
            lastWhitespace = w;
        }
        res[x] = s.substring(last,end+1);
        return res;
    }

    private boolean isWhitespace(char c) {
        return c==' ' || c=='\t';
    }

    private static void out(Object x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }
}
