import java.io.*;
import java.util.*;

class Solution
{
    static long gen_key(long x, long y) {
        return (y + 3000L) * 10000L + (x + 3000L);
    }

    static long get_x(long pos) {
        return (pos % 10000L) - 3000L;
    }

    static long get_y(long pos) {
        return (pos / 10000L) - 3000L;
    }

    static void solve() throws Exception
    {
        String[] xym = in.readLine().split(" ");
        long x = (long)parseInt(xym[0]);
        long y = (long)parseInt(xym[1]);
        String m = xym[2];

        Map<Long, Integer> peppurr = new HashMap<>();
        Set<Long> visited = new HashSet<>();
        Set<Long> current = new HashSet<>();
        Set<Long> next = new HashSet<>();
        current.add(gen_key(0, 0));
        visited.add(gen_key(0, 0));
        for (int i = 0; i < m.length(); i++) {
            switch  (m.charAt(i)) {
            case 'S': y--; break;
            case 'N': y++; break;
            case 'W': x--; break;
            case 'E': x++; break;
            }
            long key = gen_key(x, y);
            peppurr.put(key, i);
            if (visited.contains(key)) {
                out.println(i + 1);
                return;
            }
            next.clear();
            for (long pos : current) {
                long mx = get_x(pos);
                long my = get_y(pos);
                long mkey = gen_key(mx + 1L, my);
                if (mkey == key) {
                    out.println(i + 1);
                    return;
                }
                visited.add(mkey);
                next.add(mkey);
                mkey = gen_key(mx - 1L, my);
                if (mkey == key) {
                    out.println(i + 1);
                    return;
                }
                visited.add(mkey);
                next.add(mkey);
                mkey = gen_key(mx, my + 1L);
                if (mkey == key) {
                    out.println(i + 1);
                    return;
                }
                visited.add(mkey);
                next.add(mkey);
                mkey = gen_key(mx, my - 1L);
                if (mkey == key) {
                    out.println(i + 1);
                    return;
                }
                visited.add(mkey);
                next.add(mkey);
            }
            Set<Long> temp = current;
            current = next;
            next = temp;
        }


        out.println(IMPOSSIBLE);
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

    static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}