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
    
    int[]A;
    int[]C;
    int b,targ;
    
    void solve() throws IOException {
        int TC=ni();
        b=ni();
        for (int t=1;t<=TC;t++) {
            boolean foundsb=false;
            boolean founddb=false;
            A=new int[b+1];
            C=new int[b/2+1];
            int sbp=-1;
            int dbp=-1;
            targ=b/2;
            int p=1;
            
            outer:
            while (true) {
                int c=0;
                
                int fluc=0;
                if (foundsb || founddb) {
                    if (foundsb) {
                        op(sbp);
                        if (ip()!=A[sbp]) fluc++;
                    }
                    else { op(100); ip(); }
                    
                    if (founddb) {
                        op(dbp);
                        if (fluc>0) {
                            if (ip()==A[dbp]) fluc+=2;
                        }
                        else {
                            if (ip()!=A[dbp]) fluc+=2;
                        }
                    }
                    else { op(100); ip(); }
                    c+=2;
                }
                
                //out.print("--"); op(fluc);
                qf(fluc);
                
                while (c<10) {
                    op(p);
                    A[p]=ip();
                    op(b-p+1);
                    A[b-p+1]=ip();
                    if (A[p]==A[b-p+1]) {
                        C[p]=1;
                        if (!foundsb) { foundsb=true; sbp=p; }
                    }
                    else {
                        C[p]=2;
                        if (!founddb) { founddb=true; dbp=p; }
                    }
                    
                    //out.print("--"); op(C[p]);
                    
                    p++;
                    if (p>targ) break outer;
                    c+=2;
                }
            }
            
            for (int x=1;x<=b;x++) out.print(A[x]);
            out.println();
            out.flush();
            ip();
        }
        out.flush();
    }
    
    void qf(int f) {
        if (f==0) return;
        for (int x=1;x<=targ;x++) {
            int y=b-x+1;
            if (C[x]==0) continue;
            if (C[x]==1 && (f==1 || f==3)) {
                A[x]=(A[x]-1)*-1;
                A[y]=(A[y]-1)*-1;
            }
            if (C[x]==2 && (f==1 || f==2)) {
                A[x]=(A[x]-1)*-1;
                A[y]=(A[y]-1)*-1;
            }
        }
    }
    
    void op(int a) throws IOException {
        out.println(a);
        out.flush();
    }
    
    int ip() throws IOException {
        String s=next();
        char c=s.charAt(0);
        if (c=='Y') return 10;
        if (c=='0') return 0;
        if (c=='1') return 1;
        System.exit(-1);
        return 0;
    }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}