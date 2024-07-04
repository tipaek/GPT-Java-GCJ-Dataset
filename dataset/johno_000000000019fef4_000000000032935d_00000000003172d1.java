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
            
            for (int x=0;x<n;x++) {
                for (int y=x+1;x<n;y++) {
                    long g=gcd(A[x],A[y]);
                    long s=A[x]/g+A[y]/g;
                    if (s>d) continue;
                    
                    int c=2;
                    for (int z=y+1;z<n;z++) {
                        if (A[z]%g>0) continue;
                        if (s+A[z]/g>d) break;
                        c++;
                        s+=A[z]/g;
                    }
                    ans=Math.min(ans,d-c);
                }
            }
            
            out.println("Case #"+t+": "+ans);
        }
        out.flush();
    }
    
    long gcd(long a,long b) { return (b==0?a:gcd(b,a%b)); }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}