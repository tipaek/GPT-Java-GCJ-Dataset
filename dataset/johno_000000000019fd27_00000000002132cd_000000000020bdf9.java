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
            int n=ni();
            int[][]A=new int[n][3];
            for (int x=0;x<n;x++) { A[x][0]=ni(); A[x][1]=ni(); A[x][2]=x; }
            Arrays.sort(A,(a,b)->a[0]-b[0]);
            
            int[]B=new int[n];
            int end1=0;
            int end2=0;
            boolean f=true;
            
            for (int x=0;x<n;x++) {
                if (A[x][0]>=end1) {
                    B[A[x][2]]=1;
                    end1=A[x][1];
                    continue;
                }
                if (A[x][0]>=end2) {
                    B[A[x][2]]=2;
                    end2=A[x][1];
                    continue;
                }
                f=false;
                break;
            }
            
            
            out.print("Case #"+t+": ");
            if (f) {
                for (int x=0;x<n;x++) {
                    if (B[x]==1) out.print("C");
                    else out.print("J");
                }
                out.println();
            }
            else out.println("IMPOSSIBLE");
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}