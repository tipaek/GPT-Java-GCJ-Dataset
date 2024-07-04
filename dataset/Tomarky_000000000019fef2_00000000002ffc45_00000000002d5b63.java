import java.io.*;
import java.util.*;

class Solution
{
    static void solve(int A, int B) throws Exception
    {
        int x = 0, y = 0, r = A;
        String res;
        for (int i = 0; i < 300 / 4; i++)
        {
            out.printf("%d %d\n", x + r, y);
            out.flush();
            res = in.readLine();
            if ("WRONG".equals(res)) System.exit(0);
            if ("CENTER".equals(res)) return;
            if ("HIT".equals(res)) x++; else x--;
            
            out.printf("%d %d\n", x, y);
            out.flush();
            res = in.readLine();
            if ("WRONG".equals(res)) System.exit(0);
            if ("CENTER".equals(res)) return;
            
            out.printf("%d %d\n", x, y + r);
            out.flush();
            res = in.readLine();
            if ("WRONG".equals(res)) System.exit(0);
            if ("CENTER".equals(res)) return;
            if ("HIT".equals(res)) y++; else y--;
            
            out.printf("%d %d\n", x, y);
            out.flush();
            res = in.readLine();
            if ("WRONG".equals(res)) System.exit(0);
            if ("CENTER".equals(res)) return;
        }
    }

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static BufferedReader in;
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception
    {
        in = new BufferedReader(new InputStreamReader(System.in));

        int[] TAB = readInts();
        int T = TAB[0], A = TAB[1], B = TAB[2];
        for (int i = 1; i <= T; i++)
        {
            // out.printf("Case #%d: ", i);
            solve(A, B);
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