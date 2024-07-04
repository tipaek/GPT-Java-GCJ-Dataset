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
        while ((1L << bits) < Math.max(Math.abs(x0), Math.abs(y0)))
        {
            bits++;
        }
        boolean found = false;
        for (int b = bits - 1; b <= bits + 2; b++)
        {
            moves = new char[63];
            if (dfs(x0, y0, b))
            {
                found = true;
                break;
            }
        }
        if (!found)
        {
            out.println(IMPOSSIBLE);
            return;
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : moves) {
            if (ch != 0)
            {
                ans.append(ch);
            }
        }
        out.println(ans);
    }
    
    static char[] moves = null;
    static boolean dfs(long x, long y, int b)
    {
        if (b < 0)
        {
            return x == 0L && y == 0L;
        }
        long t = 1L << b;
        moves[b] = 'E';
        if (dfs(x - t, y, b - 1)) return true;
        moves[b] = 'W';
        if (dfs(x + t, y, b - 1)) return true;
        moves[b] = 'N';
        if (dfs(x, y - t, b - 1)) return true;
        moves[b] = 'S';
        if (dfs(x, y + t, b - 1)) return true;
        return false;
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