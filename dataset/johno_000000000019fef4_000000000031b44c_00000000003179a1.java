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
            int u=ni();
            int[]F=new int[26];
            Arrays.fill(F,-1);
            int [][]A=new int[10][2];
            int p=0;
            
            for (int x=0;x<10000;x++) {
                String s=next();
                char[]C=next().toCharArray();
                for (int y=0;y<C.length;y++) {
                    int nc=(int)(C[y]-'A');
                    if (F[nc]==-1) {
                        F[nc]=p;
                        A[p][1]=nc;
                        A[p][0]=1;
                        p++;
                    }
                    else A[F[nc]][0]++;
                }
            }
            
            Arrays.sort(A,(a,b)->Integer.compare(b[0],a[0]));
            
            
            out.print("Case #"+t+": ");
            out.print((char)(A[9][1]+65));
            for (int x=0;x<9;x++) out.print((char)(A[x][1]+65));
            out.println();
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}