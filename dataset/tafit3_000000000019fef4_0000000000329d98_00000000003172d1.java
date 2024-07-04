import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.min;
import static java.util.Arrays.sort;

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
        sort(a);
        Map<Long, Integer> m = new HashMap<>();
        for(long x: a) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        int best = d-1;
        for(long x: a) {
            best = min(best, solve(d, a, x));
        }
        return best;
    }

    private int solve(int d, long[] a, long chop) {
        List<Long> multiples = new ArrayList<>();
        List<Long> nonMultiples = new ArrayList<>();
        for(long x: a) {
            if(x >= chop && (x % chop == 0)) {
                multiples.add(x);
            } else {
                nonMultiples.add(x);
            }
        }
        int res = d-1;
        for(int i=1;i<=d;i++) {
            long rem = d;
            long cuts = 0;
            for(Long x: multiples) {
                long u = (x / chop)*i;
                if(u <= rem) {
                    rem -= u;
                    cuts += u-1;
                } else {
                    cuts += rem;
                    rem = 0;
                    break;
                }
            }
            if(rem > 0) {
                for (Long x : nonMultiples) {
                    long u = (x*i) / chop;
                    if(u <= rem) {
                        rem -= u;
                        cuts += u;
                    } else {
                        cuts += rem;
                        rem = 0;
                    }
                }
            }
            if(rem == 0) {
                res = min(res, (int) cuts);
            }
        }
        return res;
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
