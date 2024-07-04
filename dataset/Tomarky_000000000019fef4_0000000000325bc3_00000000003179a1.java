import java.io.*;
import java.util.*;

class Solution
{
    static class Tuple {
        long q;
        String r;
        Tuple(long q, String r) {
            this.q = q;
            this.r = r;
        }
    }

    static void solve() throws Exception
    {
        int u = readInt();
        if (u > 2) {
            solve2(u);
            return;
        }
        Tuple[] tuples = new Tuple[10000];
        boolean[] useChar = new boolean[256];
        for (int i = 0; i < 10000; i++) {
            String[] qr = in.readLine().split(" ");
            long q = Long.parseLong(qr[0]);
            String r = qr[1];
            for (int e = 0; e < r.length(); e++) {
                useChar[r.charAt(e)] = true;
            }
            tuples[i] = new Tuple(q, r);
        }
        long[] numbers = new long[useChar.length];
        for (int i = 0; i < useChar.length; i++) {
            if (useChar[i]) {
                numbers[i] = -1L;
            }
        }
        Arrays.sort(tuples, (a, b) -> {
           if (a.q != b.q) return Long.compare(a.q, b.q);
           return a.r.compareTo(b.r);
        });
        int found = 0;
        boolean[] founds = new boolean[10];
        for (int k = 0; k < 10; k++) {
            for (Tuple tuple : tuples) {
                if (tuple.q == 1L) {
                    numbers[tuple.r.charAt(0)] = 1L;
                    if (found == 0) found = 1;
                    founds[1] = true;
                    continue;
                }
                long start = (long)Math.pow(10.0, tuple.r.length() - 1);
                long end = start * 10L;
                for (long x = start; x < end; x++) {
                    long e = x;
                    boolean valid = true;
                    boolean[] used = new boolean[useChar.length];
                    for (int i = tuple.r.length()-1; i >= 0; i--) {
                        long n = numbers[tuple.r.charAt(i)];
                        used[tuple.r.charAt(i)] = true;
                        if (n >= 0L) {
                            if (n != (e % 10L)) {
                                valid = false;
                                break;
                            }
                        } else if (founds[(int)e % 10]) {
                            valid = false;
                            break;
                        }
                        e /= 10L;
                    }
                    if (!valid) continue;
                    int count = 0;
                    int found_count = 0;
                    for (int i = 0; i < used.length; i++) {
                        if (used[i]) {
                            if (numbers[i] < 0L) count++;
                            else found_count++;
                        }
                    }
                    if (count != 1 || found_count == 0) continue;
                    // out.println("valid: " + tuple.r + " = " + x);
                    found++;
                    e = x;
                    for (int i = tuple.r.length()-1; i >= 0;i --) {
                        numbers[tuple.r.charAt(i)] = e % 10L;
                        founds[(int)(e % 10L)] = true;
                        e /= 10L;
                    }
                    break;
                }
            }
            if (found == 10) break;
        }
        String ans = "";
        for (long d = 0L; d < 10L; d++) {
            for (int i = 0; i < useChar.length; i++) {
                if (useChar[i] && numbers[i] == d) {
                    // out.println(" d" + d + ", " + (char)i);
                    ans += (char)i;
                    break;
                }
            }
        }
        out.println(ans);
    }
    
    static void solve2(int u) throws Exception
    {
        Tuple[][] tuples = new Tuple[u + 1][10000];
        int[] counts = new int[u + 1]; 
        boolean[] useChar = new boolean[256];
        for (int i = 0; i < 10000; i++) {
            String[] qr = in.readLine().split(" ");
            long q = Long.parseLong(qr[0]);
            String r = qr[1];
            for (int e = 0; e < r.length(); e++) {
                useChar[r.charAt(e)] = true;
            }
            int len = r.length();
            tuples[len][counts[len]++] = new Tuple(q, r);
        }
        int[] numbers = new int[useChar.length];
        for (int i = 0; i < useChar.length; i++) {
            if (useChar[i]) numbers[i] = -1;
        }
        for (int sz = 1; sz < 10; sz++) {
            Tuple[] tps = tuples[sz];
            int count = counts[sz];
            for (int i = 0; i < count; i++) {
                Tuple tuple = tps[i];
                for (int p = 0; p < tuple.r.length(); p++) {
                    int ch = tuple.r.charAt(p);
                    if (numbers[ch] < 0) {
                        numbers[ch] = sz;
                    }
                }
            }
        }
        for (int sz = 10; sz <= u; sz++) {
            Tuple[] tps = tuples[sz];
            int count = counts[sz];
            for (int i = 0; i < count; i++) {
                Tuple tuple = tps[i];
                for (int p = 0; p < tuple.r.length(); p++) {
                    int ch = tuple.r.charAt(p);
                    if (numbers[ch] < 0) {
                        numbers[ch] = 0;
                    }
                }
            }
        }
        String ans = "";
        for (long d = 0L; d < 10L; d++) {
            for (int i = 0; i < useChar.length; i++) {
                if (useChar[i] && numbers[i] == d) {
                    // out.println(" d" + d + ", " + (char)i);
                    ans += (char)i;
                    break;
                }
            }
        }
        out.println(ans);
    }

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static BufferedReader in;
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception
    {
        in = new BufferedReader(new InputStreamReader(System.in));

        int T = readInt();
        for (int i = 1; i <= T; i++)
        {
            out.printf("Case #%d: ", i);
            solve();
        }
    }

    static int readInt() throws Exception
    {
        return Integer.parseInt(in.readLine());
    }

    static int[] readInts() throws Exception
    {
        String[] tokens = in.readLine().split(" ");
        int[] ret = new int[tokens.length];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = Integer.parseInt(tokens[i]);
        }
        return ret;
    }
}