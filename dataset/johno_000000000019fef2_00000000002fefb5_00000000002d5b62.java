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
    
            //out.println(total+" "+upper+" "+diff);
            
            int currx=0;
            int curry=0;
            int targx=Math.abs(x);
            int targy=Math.abs(y);
            int[]B=new int[n];
            p=0;
            
            int tmp=upper;
            while (upper>0) {
                if ((upper&diff)>0) { upper=upper>>1; p++; continue; }
                if (targx-currx>targy-curry) {
                    currx+=upper;
                    B[p]=1;
                }
                else { 
                    curry+=upper;
                    B[p]=2;
                }
                p++;
                upper=upper>>1;
            }
            
            upper=tmp;
            p=0;
            while (upper>0) {
                if ((upper&diff)==0) { upper=upper>>1; p++; continue; }
                if (currx-targx>curry-targy) {
                    currx-=upper;
                    B[p]=-1;
                }
                else {
                    curry-=upper;
                    B[p]=-2;
                }
                p++;
                upper=upper>>1;
            }
            
            
            out.print("Case #"+t+": ");
            for (int i=n-1;i>=0;i--) {
                if (B[i]==1) {
                    if (x>0) out.print("E");
                    else out.print("W");
                }
                if (B[i]==-1) {
                    if (x>0) out.print("W");
                    else out.print("E");
                }
                if (B[i]==2) {
                    if (x>0) out.print("N");
                    else out.print("S");
                }
                if (B[i]==-2) {
                    if (x>0) out.print("S");
                    else out.print("N");
                }
                //if (B[1]==0) out.print("Error");
            }
            out.println();
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}