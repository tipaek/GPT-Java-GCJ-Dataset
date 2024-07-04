import java.io.*;
import java.util.*;

class Solution
{
    static String query(int q) throws Exception
    {
        return query("" + q);
    }

    static String query(String q) throws Exception
    {
        out.print(q);
        out.print('\n');
        out.flush();
        return in.readLine();
    }

    static void solve(int B) throws Exception
    {
        char[] ans = new char[B];

        int limit = 150;

        for (int lp = 0, rp = B - 1; lp < rp; )
        {
            for (int i = 0; i < 10; i++)
            {
                limit--;
                int q = i % 2 == 0 ? lp++ : rp--;
                ans[q] = query(q + 1).charAt(0);
            }
        }

        int same_pos = -1;
        int diff_pos = -1;
        for (int lp = 0, rp = B - 1; lp < rp; lp++, rp--)
        {
            if (ans[lp] == ans[rp])
            {
                same_pos = lp;
            }
            else
            {
                diff_pos = lp;
            }
        }

        if (B == 20)
        {
            char[] tmp = new char[10];
            for (int lp = 0; lp < 10; lp++)
            {
                tmp[lp] = query(lp + 1).charAt(0);
            }
            for (int lp = 0; lp < 10; lp++)
            {
                if (ans[lp] != ans[B - 1 - lp])
                {
                    continue;
                }
                if (ans[lp] == tmp[lp])
                {
                    continue;
                }
                // flip
                for (int ll = (lp / 5) * 5, rr = ll + 5; ll < rr; ll++)
                {
                    ans[ll] = (char)(1 ^ (int)ans[ll]);
                    ans[B - 1 - ll] = (char)(1 ^ (int)ans[B - 1 - ll]);
                }
            }
            for (int lp = 0; lp < 10; lp++)
            {
                if (ans[lp] == ans[B - 1 - lp])
                {
                    continue;
                }
                if (ans[lp] == tmp[lp])
                {
                    continue;
                }
                // reverse
                for (int ll = (lp / 5) * 5, rr = ll + 5; ll < rr; ll++)
                {
                    char ch = ans[ll];
                    ans[ll] = ans[B - 1 - ll];
                    ans[B - 1 - ll] = ch;
                }
            }
        }

        if (B == 100)
        {
            for (int lp = 0, rp = B - 1; lp < rp; )
            {
                int sp = -1;
                for (int i = 0; i < 5; i++)
                {
                    if (ans[lp] == ans[rp])
                    {
                        sp = lp;
                    }
                    lp++;
                    rp--;
                }
                char bit = query(Math.max(1, sp + 1)).charAt(0);

            }

        }

        if ("N".equals(query(new String(ans))))
        {
            System.exit(0);
        }
    }

    static final String IMPOSSIBLE = "IMPOSSIBLE";
    static BufferedReader in;
    static PrintStream out = System.out;

    public static void main(String[] args) throws Exception
    {
        in = new BufferedReader(new InputStreamReader(System.in));

        int[] TB = readInts();
        int T = TB[0];
        int B = TB[1];
        for (int i = 1; i <= T; i++)
        {
            // out.printf("Case #%d: ", i);
            solve(B);
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