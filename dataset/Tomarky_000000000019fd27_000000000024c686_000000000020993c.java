import java.io.*;
import java.util.*;

public class Main
{
    static void solve() throws Exception
    {
        int N = readInt();
        int trace = 0;
        int[][] row_counts = new int[N][N];
        int[][] col_counts = new int[N][N];
        for (int row = 0; row < N; row++)
        {
            int[] line = readInts();
            trace += line[row];
            for (int col = 0; col < N; col++)
            {
                row_counts[row][line[col] - 1]++;
                col_counts[col][line[col] - 1]++;
            }
        }
        int rep_rows = 0;
        int rep_cols = 0;
        for (int i = 0; i < N; i++)
        {
            for (int c : row_counts[i])
            {
                if (c == 0)
                {
                    rep_rows++;
                    break;
                }
            }
            for (int c : col_counts[i])
            {
                if (c == 0)
                {
                    rep_cols++;
                    break;
                }
            }
        }
        out.printf("%d %d %d%n", trace, rep_rows, rep_cols);
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