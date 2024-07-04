import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

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

    private int solve() throws IOException {
        int d = intarr()[1];
        long[] a = longarr();
        return solve(d, a);
    }

    private int solve(int d, long[] a) {
        Map<Long, Integer> m = new HashMap<>();
        for(long x: a) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        int mx = 0;
        for(Map.Entry<Long, Integer> e: m.entrySet()) {
            mx = max(mx, e.getValue());
        }
        if(d == 2) {
            if(mx > 1) {
                return 0;
            } else {
                return 1;
            }
        } else if(d == 3) {
            if(mx > 2) {
                return 0;
            } else {
                for(Map.Entry<Long, Integer> e: m.entrySet()) {
                    if(m.containsKey(e.getKey()*2)) {
                        return 1;
                    }
                    if(e.getValue() == 2) {
                        for(Map.Entry<Long, Integer> e2: m.entrySet()) {
                            if(!e.getKey().equals(e2.getKey())) {
                                if(e2.getKey() > e.getKey()) {
                                    return 1;
                                }
                            }
                        }
                    }
                }
                return 2;
            }
        }
        return 0;
    }

    private int pint() throws IOException {
        return pint(rd.readLine());
    }

    private int pint(String s) {
        return Integer.parseInt(s);
    }

    private int[] intarr() throws IOException {
        return intarr(rd.readLine());
    }

    private int[] intarr(String s) {
        String[] q = split(s);
        int n = q.length;
        int[] a = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = Integer.parseInt(q[i]);
        }
        return a;
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
