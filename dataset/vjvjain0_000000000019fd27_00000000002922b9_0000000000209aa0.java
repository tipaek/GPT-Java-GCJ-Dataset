import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
    static final int mod = (int)1e9+7;
    public static void main(String[] args) throws Exception
    {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int test = in.nextInt();
        int tcase = 0;
        while (test-- > 0) {
            tcase++;
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] ans = new int[n][n];
            if(generate(ans, 0, 0, n, k)) {
                out.println(String.format("Case #%d: POSSIBLE", tcase));
                Arrays.stream(ans).forEach(arr -> {
                    Arrays.stream(arr).forEach(value -> out.print(value + " "));
                    out.println();
                });
            }
            else {
                out.println(String.format("Case #%d: IMPOSSIBLE", tcase));
            }
        }
        out.flush();
    }

    static boolean generate(int[][] mat, int a, int b, int n, int k) {
        if(a == n) {
            return validate(mat, n, k);
        }
        for(int i = 1; i <= n; i++) {
            boolean f = true;
            for(int j = 0; j < a; j++) {
                if(mat[j][b] == i) {
                    f = false;
                    break;
                }
            }
            for(int j = 0; j < b; j++) {
                if(mat[a][j] == i) {
                    f = false;
                    break;
                }
            }
            if(!f) {
                continue;
            }
            mat[a][b] = i;
            if(b == n - 1) {
                f = generate(mat, a + 1, 0, n, k);
            }
            else {
               f = generate(mat, a, b + 1, n, k);
            }
            if(f) {
                return f;
            }
        }

        return false;
    }

    static boolean validate(int[][] mat, int n, int k) {
        int trace = 0;
        for(int i = 0; i < n; i++) {
            trace += mat[i][i];
        }

        return trace == k;
    }
}

class FastReader
{
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() throws IOException
    {
        if(st == null || !st.hasMoreElements())
        {
            st = new StringTokenizer(br.readLine());
        }

        return st.nextToken();
    }

    public int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    public String nextLine() throws IOException
    {
        return br.readLine();
    }
}
