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
        Arrays.fill(ans, '0');
        
        int same_pos = -1;
        int diff_pos = -1;
        
        int limit = 150;
        
        int lp = 0;
        int rp = B - 1;
        for (int i = 0; i < 10; i++)
        {
            limit--;
            int q = i % 2 == 0 ? lp++ : rp--;
            ans[q] = query(q + 1).charAt(0);
            if (i % 2 == 1)
            {
                if (ans[lp - 1] == ans[q])
                {
                    same_pos = lp - 1;
                }
                else
                {
                    diff_pos = lp - 1;
                }
            }
        }
                
        while (lp < rp && limit > 0)
        {
            if (same_pos >= 0)
            {
                limit--;
                char bit = query(same_pos + 1).charAt(0);
                if (bit != ans[same_pos])
                {
                    // flip
                    for (int i = 0; i < B; i++)
                    {
                        ans[i] = (char)(1 ^ (int)ans[i]);
                    }
                }
            }
            if (diff_pos >= 0)
            {
                limit--;
                char bit = query(diff_pos + 1).charAt(0);
                if (bit != ans[diff_pos])
                {
                    // reverse
                    int ll = 0, rr = B - 1;
                    while (ll < rr)
                    {
                        char tmp = ans[ll];
                        ans[ll] = ans[rr];
                        ans[rr] = tmp;
                        ll++;
                        rr--;
                    }
                }
            }
            for (int i = 0; i < 8 && limit > 0; i++)
            {
                limit--;
                int q = i % 2 == 0 ? lp++ : rp--;
                ans[q] = query(q + 1).charAt(0);
                if (i % 2 == 1)
                {
                    if (ans[lp - 1] == ans[q] && same_pos < 0)
                    {
                        same_pos = lp - 1;
                    }
                    else if (diff_pos < 0)
                    {
                        diff_pos = lp - 1;
                    }
                }
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