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
        int a[][] = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) 
                a[i][j] = ni();
        }
    
        long sum = 0;
        for(int i=1 ; i<=n ; i++)
            sum+=a[i][i];

        int row = 0;
        int col = 0;
        for(int i=1 ; i<=n ; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=1 ; j<=n ; j++) {
                set.add( a[i][j] );
            }
            if( set.size() < n )
                ++row;
        }

        for(int j=1 ; j<=n ; j++) {
            Set<Integer> set = new HashSet<>();
            for(int i=1 ; i<=n ; i++) {
                set.add( a[i][j] );
            }
            if( set.size() < n )
                ++col;
        }

        ob.println("Case #"+testcase+": "+sum+" "+row+" "+col);
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
}
