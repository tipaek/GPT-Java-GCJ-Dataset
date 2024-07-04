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
    
    ArrayList<Integer>[]C,D;
  
    void solve() throws IOException {
        int TC=ni();
        for (int t=1;t<=TC;t++) {
            int c=ni(),d=ni();
            ArrayList<Integer>A=new ArrayList();
            ArrayList<Integer>B=new ArrayList();
            for (int x=2;x<=c;x++) {
                int u=ni();
                if (u>0) {
                    A.add(x);
                    A.add(u);
                }
                else {
                    B.add(x);
                    B.add(u*-1);
                }
            }
            
            C=new ArrayList[c+1];
            D=new ArrayList[c+1];
            int[]E=new int[d+1];
            int[]F=new int[d+1];
            int[]G=new int[d+1];
            
            for (int x=1;x<=c;x++) { C[x]=new ArrayList();  D[x]=new ArrayList(); }
            for (int x=1;x<=d;x++) {
                E[x]=ni();
                F[x]=ni();
                C[E[x]].add(F[x]);
                D[E[x]].add(x);
                C[F[x]].add(E[x]);
                D[F[x]].add(x);
            }
            
            if (A.size()==0) {
                int[]U=new int[c+1];
                Arrays.fill(U,-1);
                U[1]=0;
                int[][]V=new int[c-1][2];
                int p=0;
                for (int x=0;x<B.size();x+=2) {
                    V[p][1]=B.get(x);
                    V[p][0]=B.get(x+1);
                    p++;
                }
                
                Arrays.sort(V,(a,b)->Integer.compare(a[0],b[0]));
                
                int time=1;
                for (int x=0;x<c-1;x++) {
                    int u=V[x][1];
                    if (x>0 && V[x][0]>V[x-1][0]) time++;
                    U[u]=time;
                    //System.out.println(u);
                    for (int z=0;z<C[u].size();z++) {
                        
                        int v=C[u].get(z);
                        int conn=D[u].get(z);
                        if (U[v]>-1) G[conn]=Math.max(1,time-U[v]);
                    }
                }
                
                out.print("Case #"+t+": ");
                for (int x=1;x<=d;x++) out.print(G[x]+" ");
                out.println();
            }
            
            else {
                out.println("Case #"+t+": ");
            }
        }
        out.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}