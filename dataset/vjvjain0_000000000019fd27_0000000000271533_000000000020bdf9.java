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
            pair[] arr = new pair[n + n];
            for(int i = 0, j = 0; i < n; i++) {
                arr[j++] = new pair(in.nextInt(), true, i);
                arr[j++] = new pair(in.nextInt(), false, i);
            }
            Arrays.sort(arr, (a, b) -> Integer.compare(a.val, b.val));
            char[] s = new char[n];
            boolean c = false, j = false, ans = true;
            for(int i = 0; i < n + n; i++) {
                if(!arr[i].f) {
                    if(s[arr[i].idx] == 'C') {
                        c = false;
                    }
                    else {
                        j = false;
                    }
                }
                else {
                    if(!c) {
                        s[arr[i].idx] = 'C';
                        c = true;
                    }
                    else if(!j) {
                        s[arr[i].idx] = 'J';
                        j = true;
                    }
                    else {
                        ans = false;
                        break;
                    }
                }
            }
            if(!ans) {
                out.println(String.format("Case #%d: IMPOSSIBLE", tcase));
            }
            else {
                out.println(String.format("Case #%d: %s", tcase, new String(s)));
            }
        }
        out.flush();
    }

    static class pair {
        int val, idx;
        boolean f;

        pair(int val, boolean f, int idx) {
            this.val = val;
            this.f = f;
            this.idx = idx;
        }
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
