import java.io.*;
import java.util.*;
import java.awt.*;
public class Solution
{
    BufferedReader in;
    PrintWriter ob;
    StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
    void run() throws IOException {
        in=new BufferedReader(new InputStreamReader(System.in));
        ob=new PrintWriter(System.out);
        int t = ni();
        for(int tt=1 ; tt<=t ; tt++)
            solve(tt);
        ob.flush();
    }
    void solve(int testcase) throws IOException {
        int n = ni();
        int d = ni();
        int ans = Integer.MAX_VALUE;
        long a[] = nla(0,n);
        for(int i=0 ; i<n ; i++) {
            ans = Math.min( ans , calcuate( i , d , n , a ) );
        }
        ob.println("Case #"+testcase+": "+ans);
    }

    int calcuate(int index , int d , int n , long a[]) {
        int res = d-1;
        long value = a[index];
     
        for (int i=1; i<=d/2; i++){
            int cuts = 0, pieces = 0;
            for (int j=0; j<n; j++){
                    if (a[j]%value == 0) {
                        long ok = (i*a[j])/value ;
                        long next = ok + pieces;
                        if ( d <= next ){
                            if (pieces + (i*a[j])/value >= d) {
                                cuts += ok-1;
                            }
                            else {
                                cuts += (d-pieces);
                            }
                            res = Math.min(res, cuts);
                            break;
                        }
                    cuts += (i*(a[j]/value));
                    cuts -= 1;
                    pieces += i*a[j]/value;
                }
            }
     
            for (int j=0; j<n ; j++){
                if (a[j]%value > 0 && a[j] > value){
                    long ok = (i*a[j])/value ;
                    long next = ok + pieces;    
                    if ( d <= next ){
                        res = Math.min(res, (d-pieces)+cuts);
                        break;
                    }
                    cuts += i*(a[j]/value);
                    pieces += i*a[j]/value;
                }
            }
        }
        return res;
    }
 
    String ns() throws IOException {
        return nextToken();
    }
    long nl() throws IOException {
        return Long.parseLong(nextToken());
    }
    int ni() throws IOException {
        return Integer.parseInt(nextToken());
    }
    double nd() throws IOException {
        return Double.parseDouble(nextToken());
    } 
    String nextToken() throws IOException {
        if(st==null || !st.hasMoreTokens())
            st=new StringTokenizer(in.readLine());
        return st.nextToken();
    }
    int[] nia(int start,int b) throws IOException {
        int a[]=new int[b];
        for(int i=start;i<b;i++)
            a[i]=ni();
        return a;
    }
    long[] nla(int start,int n) throws IOException {
        long a[]=new long[n];
        for (int i=start; i<n ;i++ ) {
            a[i]=nl();
        }
        return a;
    }
    void tr(Object... o) { 
        System.out.println(Arrays.deepToString(o)); 
    }

}
