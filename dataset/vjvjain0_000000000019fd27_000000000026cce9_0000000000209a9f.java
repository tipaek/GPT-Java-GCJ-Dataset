import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            char[] s = in.next().toCharArray();
            int open = 0;
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < s.length; i++) {
                while (open > s[i] - '0') {
                    sb.append(')');
                    open--;
                }
                while (open < s[i] - '0') {
                    sb.append('(');
                    open++;
                }
                sb.append(s[i]);
            }
            while (open > 0) {
                sb.append(')');
                open--;
            }
            out.println(String.format("Case #%d: %s", tcase, sb));
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
