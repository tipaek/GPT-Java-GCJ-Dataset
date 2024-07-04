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
            
            for (int x=0;x<n;x++) {
                long p=A[x];
                long exslices=1;
                long excuts=0;
                long genslices=0;

                for (int y=x+1;y<n;y++) {
                    if (A[y]%p==0) {
                        long newslices=A[y]/p;
                        if (exslices+newslices>d) {
                            genslices+=newslices;
                        }
                        else {
                            exslices+=newslices;
                            excuts+=newslices-1;
                        }
                    }
                    else {
                        genslices+=A[y]/p;
                    }
                }
                
                if (genslices>=d-exslices)
                    ans=Math.min(ans,excuts+d-exslices);
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