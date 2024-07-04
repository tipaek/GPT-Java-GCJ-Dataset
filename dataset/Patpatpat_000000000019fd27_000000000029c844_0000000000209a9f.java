import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    public Solution() throws IOException {}

    private void run() throws IOException {
        solve();
        out.close();
    }

    private void solve() throws IOException {
        int t = nextInt();
        for (int it = 0; it < t; it++) {
            String s = next();
            StringBuilder sb = new StringBuilder();

            boolean isOpened = false;
            int depth = 0;
            Integer prevVal = null;
            for (int i = 0 ; i < s.length(); i++) {
                int val = Character.getNumericValue(s.charAt(i));
                if(isOpened && prevVal != val) {
                    while(depth > 0) {
                        sb.append(")");
                        depth--;
                    }
                    isOpened = false;
                }

                while (depth < val) {
                    sb.append("(");
                    depth++;
                    isOpened=true;
                }
                prevVal = val;
                sb.append(val);
            }

            while(depth > 0) {
                sb.append(")");
                depth--;
            }

            System.out.println("Case #" + (it+1) + ": " + sb.toString());
        }
    }



    String next() throws IOException  {
        while (st == null || !st.hasMoreTokens())  {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException  {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException  {
        return Long.parseLong(next());
    }


}
