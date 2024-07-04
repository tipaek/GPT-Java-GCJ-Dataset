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
        int a[][] = new int[n][3];
        for (int i=0 ; i<n ; i++) {
            a[i][0] = ni();
            a[i][1] = ni();
            a[i][2] = i;
        }
        Arrays.sort( a , new Comparator<int[]>(){
            public int compare( int a[] , int b[] ) {
                return Integer.compare( a[0] , b[0] );
            }
        });

        boolean taken[] = new boolean[n];
        taken[0] = true;
        int end = a[0][1];
        for(int i=1 ; i<n ; i++) {
            if( a[i][0] >= end ) {
                end = a[i][1];
                taken[i] = true;
            }
        }

        boolean isAnswerPossible = true;
        end = Integer.MIN_VALUE;
        for(int i=0 ; i<n ; i++) {
            if( !taken[i] ) {
                if( end == Integer.MIN_VALUE ) {
                    end = a[i][1];
                } else if( a[i][0] >= end ) {
                    end = a[i][1];
                } else {
                    isAnswerPossible = false;
                    break;
                }
            }
        }
        if( !isAnswerPossible )
            ob.println("Case #"+testcase+": IMPOSSIBLE");
        else {

            char s[] = new char[n];
            for(int i=0 ; i<n ; i++) {
                if( taken[i] )
                    s[ a[i][2] ] = 'J';
                else
                    s[ a[i][2] ] = 'C';
            }

            ob.println("Case #"+testcase+": "+new String(s));
        }
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
