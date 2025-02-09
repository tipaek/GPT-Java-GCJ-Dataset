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
            int n=ni(),d=ni();
            long[]A=new long[n];
            for (int x=0;x<n;x++) A[x]=nl();
            Arrays.sort(A);
            long ans=d-1;
            
            long[]B=new long[n+1];
            for (int x=n-1;x>=0;x--) B[x]=A[x]+B[x+1];
            
            int q=0;
            
            for (long x=1;x<=600000;x++) {
                int p=q;
                while (p<n && A[p]<x) { p++; q++; }
                if (p==n) break;
                
                int c=0;
                long s=0;
                long na=d;
                while (p<n) {
                    if (s+A[p]/x>d) break;
                    if (A[p]%x==0) {
                        c++;
                        s+=A[p]/x;
                        if (d%s==0) na=d-c;
                    }
                    p++;
                }
                ans=Math.min(ans,d-c);
                ans=Math.min(ans,na);
            }
            
            out.println("Case #"+t+": "+ans);
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}