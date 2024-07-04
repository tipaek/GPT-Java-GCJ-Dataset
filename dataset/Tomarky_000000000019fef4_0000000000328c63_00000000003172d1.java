import java.io.*;
import java.util.*;

class Solution
{
    static void solve() throws Exception
    {
        long[] nd = readLongs();
        int n = (int)nd[0];
        int d = (int)nd[1];
        long[] cuts = readLongs();
        Map<Long, Long> set = new TreeMap<>();
        long max = 0L;
        for (long c : cuts) {
            
            if (set.containsKey(c)) {
                set.put(c, set.get(c) + 1L);
            } else {
                set.put(c, 1L);
            }
            max= Math.max(max, c);
        }
        long ans = d;
        for (long key : set.keySet()) {
            long count = set.get(key);
            long cut = 0;
            if (count >= d) {
                out.println(cut);
                return;
            }
        outerloop:
            for (long p = 2L; p * key <= max; p++) {
                Long count_x = set.get(p * key);
                if (count_x == null) continue;
                for (long e = 0L; e < count_x; e++) {
                    cut += p - 1L;
                    count += p;
                    if (count >= d) {
                        break outerloop;
                    }
                }
            }
            if (count >= d) {
                ans = Math.min(ans, cut);
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

    static long[] readLongs() throws Exception
    {
        String[] tokens = in.readLine().split(" ");
        long[] ret = new long[tokens.length];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = Long.parseLong(tokens[i]);
        }
        return ret;
    }
}