import java.io.*;
import java.util.*;
import java.awt.*;
public class Solution
{
    BufferedReader in;
    PrintWriter ob;
    StringTokenizer st;

    int ans = Integer.MAX_VALUE;;
    int m;
    char s[];
 
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
        
        int x = ni();
        int y = ni();

        s = ns().toCharArray();
        m = s.length;

        ans = Integer.MAX_VALUE;
        
        rec( 0 , 0 , x , y , m , 0);
        
        if( ans != Integer.MAX_VALUE )
            ob.println("Case #"+testcase+": "+ans);
        else
            ob.println("Case #"+testcase+": IMPOSSIBLE");
        
    }

    void rec( int i , int j , int destx , int desty , int remM , int moves ) {
        if( dist( i , destx , j , desty ) > remM )
            return;

        if( i == destx && j == desty ) {
            ans = Math.min( ans , moves );
            return;
        }

        if( moves == m )
            return;

        destx = destx + getX( moves );
        desty = desty + getY( moves );

        rec( i+1 , j , destx , desty , remM-1 , moves+1 );
        rec( i , j+1 , destx , desty , remM-1 , moves+1 );
        rec( i-1 , j , destx , desty , remM-1 , moves+1 );
        rec( i , j-1 , destx , desty , remM-1 , moves+1 );
        rec( i , j   , destx , desty , remM-1 , moves+1 );
    }

    int dist( int x1 , int x2 , int y1 , int y2 ) {
        int d = Math.abs( x1 - x2 ) + Math.abs( y1 - y2 );
        return d/2;
    }

    int getX(int index) {
        if( s[index] == 'E' )
            return 1;
        else if( s[index] == 'W' )
            return -1;
        else
            return 0;
    }

    int getY(int index) {
        if( s[index] == 'N' )
            return 1;
        else if( s[index] == 'S' )
            return -1;
        else
            return 0;
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
