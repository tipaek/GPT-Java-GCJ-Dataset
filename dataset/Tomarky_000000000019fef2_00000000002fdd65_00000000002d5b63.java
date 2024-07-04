import java.io.*;
import java.util.*;

class Solution
{
    static void solve(int A, int B) throws Exception
    {
        // solution
        for (int x = -5; x <= 5; x++)
        {
            for (int y = -5; y <= 5; y++)
            {
                out.printf("%d %d\n", x, y);
                out.flush();
                String res = in.readLine();
                if ("CENTER".equals(res))
                {
                    return;
                }
            }
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