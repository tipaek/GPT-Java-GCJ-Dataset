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
            int[]X=new int[n];
            int[]Y=new int[n];
            for (int x=0;x<n;x++) {
                X[x]=ni()+1000000000;
                Y[x]=ni()+1000000000;
            }
            
            if (n==1) {
                out.println("Case #"+t+": "+1);
                continue;
            }
            
            int pairs=(n*(n-1))/2;
            int[][]G=new int[pairs][4];
            int p=0;
            
            for (int a=0;a<n;a++) {
                for (int b=a+1;b<n;b++) {
                    int grady=Y[a]-Y[b];
                    int gradx=X[a]-X[b];
                    if (grady<0 && gradx<0) { grady*=-1; gradx*=-1; }
                    if (grady<0) { grady*=-1; gradx*=-1; }
                    
                    int gradg=1;
                    if (grady==0 || gradx==0) {
                        if (grady==0) gradx=1;
                        else grady=1;
                    }
                    else {
                        gradg=gcd(Math.abs(grady),Math.abs(gradx));
                    }
                    
                    G[p][0]=grady/gradg;
                    G[p][1]=gradx/gradg;
                    G[p][2]=a;
                    G[p][3]=b;
                    p++;
                }
            }
            
            Arrays.sort(G,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
            
            int curr=1;
            int max=1;
            int maxp=0;
            HashSet<Integer>J=new HashSet();
            J.add(G[0][2]);
            J.add(G[0][3]);
            HashSet<Integer>H=new HashSet();
            H.add(G[0][2]);
            H.add(G[0][3]);
            
            //out.println(G[0][0]+" "+G[0][1]+" "+G[0][2]+" "+G[0][3]);
            
            for (int x=1;x<pairs;x++) {
                
                //out.println(G[x][0]+" "+G[x][1]+" "+G[x][2]+" "+G[x][3]);
                if (G[x][0]==G[x-1][0] && G[x][1]==G[x-1][1]) {
                    J.add(G[x][2]);
                    J.add(G[x][3]);
                }
                else {
                    if (J.size()>H.size()) {
                        H.clear();
                        for (Integer z:J) H.add(z);
                    }
                    J.clear();
                    J.add(G[x][2]);
                    J.add(G[x][3]);
                }
            }
            
            int ans=H.size();
            if (ans%2==0) ans+=2;
            else ans++;
            
            out.println("Case #"+t+": "+Math.min(ans,n));
        }
        out.flush();
    }
    
    int gcd(int a,int b) { return (b==0?a:gcd(b,a%b)); }
    
    public static void main(String[] args) throws IOException {
        Solution s=new Solution();
        s.solve();
    }
}