import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
	PrintWriter out = new PrintWriter(System.out);
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tok = new StringTokenizer("");
    String next() throws IOException {
        if (!tok.hasMoreTokens()) { tok = new StringTokenizer(in.readLine()); }
        return tok.nextToken();
    }
    int ni() throws IOException { return Integer.parseInt(next()); }
    long nl() throws IOException { return Long.parseLong(next()); }
  
    void solve() throws IOException {
        int TC=ni();
        for (int t=1;t<=TC;t++) {
            int x=ni(),y=ni();
            char[]C=next().toCharArray();
            int p=1;
            //int ans=Integer.MAX_VALUE;
            
            while (p<=C.length) {
                if (C[p-1]=='N') y++;
                if (C[p-1]=='S') y--;
                if (C[p-1]=='E') x++;
                if (C[p-1]=='W') x--;
                if (Math.abs(x)+Math.abs(y)>p) p++;
                else break;
            }
            
            out.print("Case #"+t+": ");
            if (p>C.length) out.println("IMPOSSIBLE");
            else out.println(p);
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}