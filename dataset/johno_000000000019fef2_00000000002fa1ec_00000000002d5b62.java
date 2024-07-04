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
            int total=Math.abs(x)+Math.abs(y);
            if (total%2==0) { out.println("Case #"+t+": IMPOSSIBLE"); continue; }
            
            int n=0;
            int p=total;
            while (p>0) { p=p>>1; n++; }
            
            int upper=1;
            for (int i=0;i<n;i++) upper*=2;
            
            int diff=upper-1-total;
            diff/=2;
            upper/=2;
            
            StringBuilder A=new StringBuilder("");
            //out.println(total+" "+upper+" "+diff);
            if (x%2==0) {
                int xleft=Math.abs(x);
                while (upper>0) {
                    if ((upper & diff)>0) {
                        if (y>0) A.append("S");
                        else A.append("N");
                    }
                    else {
                        if (xleft>=upper) {
                            xleft-=upper;
                            if (x>0) A.append("E");
                            else A.append("W");
                        }
                        else {
                            if (y>0) A.append("N");
                            else A.append("S");
                        }
                    }
                    upper=upper>>1;
                }
            }
            
            else {
                int yleft=Math.abs(y);
                while (upper>0) {
                    if ((upper & diff)>0) {
                        if (x>0) A.append("W");
                        else A.append("E");
                    }
                    else {
                        if (yleft>=upper) {
                            yleft-=upper;
                            if (y>0) A.append("N");
                            else A.append("S");
                        }
                        else {
                            if (x>0) A.append("E");
                            else A.append("W");
                        }
                    }
                    upper=upper>>1;
                }
            }
            
            out.println("Case #"+t+": "+A.reverse().toString());
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}