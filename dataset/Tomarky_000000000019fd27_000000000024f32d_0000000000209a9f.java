import java.io.*;
import java.util.*;

class Solution
{
    static void solve() throws Exception
    {
        String S = in.readLine();
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (int i = 0; i < S.length(); i++)
        {
            int cur = (int)S.charAt(i) - '0';
            while (prev > cur)
            {
                sb.append(')');
                prev--;
            }
            while (prev < cur)
            {
                sb.append('(');
                prev++;
            }
            sb.append(cur);
        }
        while (prev > 0)
        {
            sb.append(')');
            prev--;
        }
        out.println(sb.toString());
    }

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