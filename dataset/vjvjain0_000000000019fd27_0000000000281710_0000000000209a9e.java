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
        int b = in.nextInt();
        while (test-- > 0) {
            char[] s = in.next().toCharArray();
            char[] c = new char[b];
            char[] r = new char[b];
            char[] rc = new char[b];
            for(int i = 0; i < b; i++) {
                c[i] = s[i] == '0' ? '1' : '0';
                r[i] = s[b - i - 1];
                rc[i] = r[i] == '0' ? '1' : '0';
            }
            char[] q = new char[10];
            for(int i = 1; i <= 10; i++) {
                out.println(i);
                out.flush();
                q[i - 1] = in.next().charAt(0);
            }
            out.println(q);
            out.flush();
            if(in.next().charAt(0) == 'N') {
                break;
            }
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
