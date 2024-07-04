import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
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
            int[][] mat = new int[n][n];
            int k = 0, r = 0, c = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    mat[i][j] = in.nextInt();
                    if(i == j) {
                        k += mat[i][j];
                    }
                }
            }
            for(int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for(int i = 0; i < n; i++) {
                    if(set.contains(mat[i][j])) {
                        c++;
                        break;
                    }
                    set.add(mat[i][j]);
                }
            }
            for(int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for(int j = 0; j < n; j++) {
                    if(set.contains(mat[i][j])) {
                        r++;
                        break;
                    }
                    set.add(mat[i][j]);
                }
            }
            out.println(String.format("Case #%d: %d %d %d", tcase, k, r, c));
        }
        out.flush();
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
