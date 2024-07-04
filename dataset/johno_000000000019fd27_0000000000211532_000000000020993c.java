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
            boolean[][]C=new boolean[n+1][n+1];
            boolean[][]R=new boolean[n+1][n+1];
            boolean[]CA=new boolean[n+1];
            boolean[]RA=new boolean[n+1];
            int ansc=0;
            int ansr=0;
            int anst=0;
            
            for (int x=1;x<=n;x++) {
                for (int y=1;y<=n;y++) {
                    int p=ni();
                    if (x==y) anst+=p;
                    if (C[y][p]) { if (!CA[y]) { ansc++; CA[y]=true; } }
                    else C[y][p]=true;
                    if (R[x][p]) { if (!RA[x]) { ansr++; RA[x]=true; } }
                    else R[x][p]=true;
                }
            }
            
            out.println("Case #"+t+": "+anst+" "+ansr+" "+ansc);
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}