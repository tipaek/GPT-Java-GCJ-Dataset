import java.io.*;
import java.util.*;

class Solution
{
    static void solve() throws Exception
    {
        int[] NK = readInts();
        int N = NK[0], K = NK[1];
        int N2 = N * N;
        int[][] matrix = new int[N][N];
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>(N2);
        for (int i = 1; i <= N; i++)
        {
            stack.addLast(i * N2);
        }
        long[] rows = new long[N];
        long[] cols = new long[N];
        while (!stack.isEmpty())
        {
            int v = stack.pollLast();
            int a = v / N2;
            int p = v % N2;
            int r = p / N;
            int c = p % N;
            int b = matrix[r][c];
            matrix[r][c] = a;
            rows[r] &= -1 ^ (1 << b);
            rows[r] |= 1 << a;
            cols[c] &= -1 ^ (1 << b);
            cols[c] |= 1 << a;
            if (r == c)
            {
                sum += a - b;
            }
            int pp = p + 1;
            if (pp == N2)
            {
                if (sum != K)
                {
                    continue;
                }
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
                return;
            }
            int rr = pp / N;
            int cc = pp % N;
            b = matrix[rr][cc];
            matrix[rr][cc] = 0;
            if (a != b || r != rr)
            {
                rows[rr] &= -1 ^ (1 << b);
            }
            cols[cc] &= -1 ^ (1 << b);
            if (rr == cc)
            {
                sum -= b;
            }
            for (int i = 1; i <= N; i++)
            {
                if ((rows[rr] & (1 << i)) != 0)
                {
                    continue;
                }
                if ((cols[cc] & (1 << i)) != 0)
                {
                    continue;
                }
                stack.addLast(i * N2 + pp);
            }
        }
        out.println(IMPOSSIBLE);
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