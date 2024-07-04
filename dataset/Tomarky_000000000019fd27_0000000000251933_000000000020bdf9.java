import java.io.*;
import java.util.*;

class Solution
{
    static void solve() throws Exception
    {
        int N = readInt();
        int[][] activities = new int[N][3];
        for (int i = 0; i < N; i++)
        {
            int[] se = readInts();
            activities[i][0] = i;
            activities[i][1] = se[0];
            activities[i][2] = se[1];
        }
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

        char[] ans = new char[N];

        int jamie_end = 0;
        int cameron_end = 0;
        for (int[] activity : activities)
        {
            if (cameron_end <= activity[1])
            {
                cameron_end = activity[2];
                ans[activity[0]] = 'C';
            }
            else if (jamie_end <= activity[1])
            {
                jamie_end = activity[2];
                ans[activity[0]] = 'J';
            }
            else
            {
                out.println(IMPOSSIBLE);
                return;
            }
        }

        out.println(new String(ans));
    }

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