import java.io.*;
import java.util.*;

class Solution
{
    static int gen_key(int x, int y) {
        return (y << 12) | x;
    }

    static int get_x(int pos) {
        return pos & ((1 << 12) - 1);
    }

    static int get_y(int pos) {
        return pos >> 12;
    }

    static void solve() throws Exception
    {
        String[] xym = in.readLine().split(" ");
        int x = parseInt(xym[0]) + 1000;
        int y = parseInt(xym[1]) + 1000;
        String m = xym[2];

        boolean[] visited = new boolean[4000 * 4000];
        int[] current = new int[4000 * 4000];
        int[] next = new int[4000 * 4000];
        int current_count = 0;
        int next_count = 0;
        visited[gen_key(1000, 1000)] = true;
        current[current_count++] = gen_key(1000, 1000);
        for (int i = 0; i < m.length(); i++) {
            switch  (m.charAt(i)) {
            case 'S': y--; break;
            case 'N': y++; break;
            case 'W': x--; break;
            case 'E': x++; break;
            }
            int key = gen_key(x, y);
            if (visited[key]) {
                out.println(i + 1);
                return;
            }
            next_count = 0;
            for (int e = 0; e < current_count; e++) {
                int pos = current[e];
                int mx = get_x(pos);
                int my = get_y(pos);
                int mkey = gen_key(mx + 1, my);
                if (mkey == key) {
                    out.println(i + 1);
                    return;
                }
                if (!visited[mkey]) {
                    visited[mkey] = true;
                    next[next_count++] = mkey;
                }
                mkey = gen_key(mx - 1, my);
                if (mkey == key) {
                    out.println(i + 1);
                    return;
                }
                if (!visited[mkey]) {
                    visited[mkey] = true;
                    next[next_count++] = mkey;
                }
                mkey = gen_key(mx, my + 1);
                if (mkey == key) {
                    out.println(i + 1);
                    return;
                }
                if (!visited[mkey]) {
                    visited[mkey] = true;
                    next[next_count++] = mkey;
                }
                mkey = gen_key(mx, my - 1);
                if (mkey == key) {
                    out.println(i + 1);
                    return;
                }
                if (!visited[mkey]) {
                    visited[mkey] = true;
                    next[next_count++] = mkey;
                }
            }
            int[] temp = current;
            current = next;
            next = temp;
            current_count = next_count;
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