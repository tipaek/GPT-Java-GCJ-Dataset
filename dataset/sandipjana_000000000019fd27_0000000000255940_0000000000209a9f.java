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
        char s[] = ns().toCharArray();
        int n = s.length;
        int rem = 0;
        int forward = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0 ; i < n ; i++) {

            //add s[i] open brackets
            for(int j=1 ; j <= s[i]-'0' - forward ; j++) 
                ans.append('(');
            
            ans.append(s[i]);

            // now check for next char
            while( i+1<n && s[i+1] == s[i] ) {
                ans.append(s[i]);
                ++i;
            }

            rem = s[i]-'0';
            while( i+1<n && s[i+1] < s[i] && s[i+1] != '0' ) {

                int needed = (s[i]-'0') - (s[i+1]-'0');
                while( needed-- > 0 ) {
                    ans.append( ')' );
                }

                ans.append( s[i+1] );
                rem -= (s[i]-'0') - (s[i+1]-'0');
                i++;
            } 

            if(( i == n-1 ) || ( i<n && s[i+1]=='0' )) {
                while( rem-- > 0 )
                    ans.append(')');
            } else if( s[i] != '0' ){
                forward = (s[i]-'0');
            }

        }
        ob.println("Case #"+testcase+": "+ans.toString());
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
