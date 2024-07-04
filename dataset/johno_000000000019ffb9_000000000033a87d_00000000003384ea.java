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
            long a=nl(),b=nl();
            long d=Math.abs(a-b);
            
            long l=1;
            long r=10000000000L;
            while (r-l>1) {
                long av=(l+r)/2;
                if ((av*(av+1))/2>d) r=av;
                else l=av;
            }
            
            long ans=l;
            long a2=0;
            
            if (a>=b) a-=(l*(l+1))/2;
            else b-=(l*(l+1))/2;
            
            if (a>=b) {
                l=0;
                r=10000000000L;
                while (r-l>1) {
                    long av=(l+r)/2;
                    if (av*(av+ans)>a) r=av;
                    else l=av;
                }
                a2+=l;
                a-=(l*(l+ans));
                
                l=0;
                r=10000000000L;
                while (r-l>1) {
                    long av=(l+r)/2;
                    if (av*(av+ans+1)>b) r=av;
                    else l=av;
                }
                a2+=l;
                b-=(l*(l+ans+1));
            }
            
            else {
                l=0;
                r=10000000000L;
                while (r-l>1) {
                    long av=(l+r)/2;
                    if (av*(av+ans)>b) r=av;
                    else l=av;
                }
                a2+=l;
                b-=(l*(l+ans));
                
                l=0;
                r=10000000000L;
                while (r-l>1) {
                    long av=(l+r)/2;
                    if (av*(av+ans+1)>a) r=av;
                    else l=av;
                }
                a2+=l;
                a-=(l*(l+ans+1));
            }
            
            out.println("Case #"+t+": "+(ans+a2)+" "+a+" "+b);
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}