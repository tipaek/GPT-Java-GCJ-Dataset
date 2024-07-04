import java.io.*;
import java.util.*;

class Solution
{
    static void solve() throws Exception
    {
        // solution
        int[] xy = readInts();
        long x0 = xy[0], y0 = xy[1];
        if (Math.abs(x0) % 2L != 0L && Math.abs(y0) % 2L != 0L)
        {
            out.println("IMPOSSIBLE");
            return;
        }
        int bits = 0;
        while ((1L << bits) < Math.min(Math.abs(x0), Math.abs(y0)))
        {
            bits++;
        }
        StringBuilder ans = new StringBuilder();
        long x = x0, y = y0;
        for (int b = bits; b >= 0; b--)
        {
            if (Math.abs(x) > Math.abs(y))
            {
                if (x < 0L)
                {
                    x += 1L << b;
                    ans.append('W');
                }
                else
                {
                    x -= 1L << b;
                    ans.append('E');
                }
            }
            else
            {
                if (y < 0L)
                {
                    y += 1L << b;
                    ans.append('S');
                }
                else
                {
                    y -= 1L << b;
                    ans.append('N');
                }
            }
            // out.printf("%d %d%n", x, y);
        }
        if (x != 0L || y != 0L)
        {
            x = x0;
            y = y0;
            ans.delete(0, ans.length());
            for (int b = bits + 1; b >= 0; b--)
            {
                if (Math.abs(x) > Math.abs(y))
                {
                    if (x < 0L)
                    {
                        x += 1L << b;
                        ans.append('W');
                    }
                    else
                    {
                        x -= 1L << b;
                        ans.append('E');
                    }
                }
                else
                {
                    if (y < 0L)
                    {
                        y += 1L << b;
                        ans.append('S');
                    }
                    else
                    {
                        y -= 1L << b;
                        ans.append('N');
                    }
                }
                // out.printf("%d %d%n", x, y);
            }
        }
        if (x != 0L || y != 0L)
        {
            out.println(IMPOSSIBLE);
            return;
        }
        out.println(ans.reverse());
    }

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static BufferedReader in;
    static PrintStream out = System.out;
    static PrintStream err = System.err;

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