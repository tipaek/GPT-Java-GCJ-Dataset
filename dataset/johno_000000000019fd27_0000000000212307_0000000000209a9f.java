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
            char[]C=next().toCharArray();
            int n=C.length;
            
            out.print("Case #"+t+": ");
            int count=0;
            for (int x=0;x<n;x++) {
                int p=(int)(C[x]-'0');
                while (count<p) { out.print("("); count++; }
                while (count>p) { out.print(")"); count--; }
                out.print(p);
            }
            while (count>0) { out.print(")"); count--; }
            out.println();
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}