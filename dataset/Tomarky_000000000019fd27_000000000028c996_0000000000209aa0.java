import java.io.*;
import java.util.*;

class Solution
{
    static int[][] matrix;
    static long[] rows;
    static long[] cols;
    static int N, K, sum;
    static boolean dfs_dec(int r, int c)
    {
        if (r == N)
        {
            return sum == K;
        }
        int rr = r, cc = c + 1;
        if (cc == N)
        {
            rr++;
            cc = 0;
        }
        int rem = N - (c < r ? r : r + 1);
        for (int i = N; i > 0; i--)
        {
            long f = 1L << i;
            if ((rows[r] & f) != 0L)
            {
                continue;
            }
            if ((cols[c] & f) != 0L)
            {
                continue;
            }
            if (r == c)
            {
                if (sum + i + rem > K)
                {
                    continue;
                }
                sum += i;
            }
            rows[r] ^= f;
            cols[c] ^= f;
            matrix[r][c] = i;
            if (dfs_dec(rr, cc))
            {
                return true;
            }
            if (r == c)
            {
                sum -= i;
            }
            rows[r] ^= f;
            cols[c] ^= f;
        }
        return false;
    }

    static boolean dfs_inc(int r, int c)
    {
        if (r == N)
        {
            return sum == K;
        }
        int rr = r, cc = c + 1;
        if (cc == N)
        {
            rr++;
            cc = 0;
        }
        int rem = N - (c < r ? r : r + 1);
        for (int i = 1; i <= N; i++)
        {
            long f = 1L << i;
            if ((rows[r] & f) != 0L)
            {
                continue;
            }
            if ((cols[c] & f) != 0L)
            {
                continue;
            }
            if (r == c)
            {
                if (sum + i + rem > K)
                {
                    continue;
                }
                sum += i;
            }
            rows[r] ^= f;
            cols[c] ^= f;
            matrix[r][c] = i;
            if (dfs_inc(rr, cc))
            {
                return true;
            }
            if (r == c)
            {
                sum -= i;
            }
            rows[r] ^= f;
            cols[c] ^= f;
        }
        return false;
    }

    static void solve() throws Exception
    {
        int[] NK = readInts();
        N = NK[0];
        K = NK[1];
        if (K == N + 1 || K == N * N - 1)
        {
            out.println(IMPOSSIBLE);
            return;
        }
        sum = 0;
        rows = new long[N];
        cols = new long[N];
        matrix = new int[N][N];
        if ((K > 2 * N && dfs_dec(0, 0)) || (K <= 2 * N && dfs_inc(0, 0)))
        {
            out.println(POSSIBLE);
            for (int row = 0; row < N; row++)
            {
                for (int col = 0; col < N; col++)
                {
                    if (col > 0)
                    {
                        out.print(' ');
                    }
                    out.print(matrix[row][col]);
                }
                out.println();
            }
        }
        else
        {
            out.println(IMPOSSIBLE);
        }
    }

    static final String POSSIBLE = "POSSIBLE";
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
}