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
        int x = ni();
        int y = ni();

        int d = Math.abs(x)+Math.abs(y);

        if( d%2 == 0 ) {
            ob.println("Case #"+testcase+": IMPOSSIBLE");            
        } else {
            String bin = Integer.toBinaryString(d);
            int bits = bin.length();

            long maxValue = (long)Math.pow(2L , bits) -1;
            long subtract = (maxValue - d)/2;

            String reducedBits = Long.toBinaryString(subtract);

            int absx = Math.abs(x);
            int absy = Math.abs(y);
            String ans = "";
            if(  absx < absy  ) {

                for(int b = 0 ; b < bits ; b++) {
                    if( (subtract&(1L<<b)) > 0 )
                        ans+="S";
                    else if( (absx&(1L<<b)) > 0 )
                        ans+="E";
                    else
                        ans+="N";
                }
                //tr(ans);

            } else {

                for(int b = 0 ; b < bits ; b++) {
                    if( (subtract&(1L<<b)) > 0 )
                        ans+="W";
                    else if( (absy&(1L<<b)) > 0 )
                        ans+="N";
                    else
                        ans+="E";
                }
                //tr(ans); 
            }

            if( x >= 0 && y >= 0  )
                ob.println("Case #"+testcase+": "+ans);
            else if( x<=0 && y>=0 ) {
                ans = ans.replaceAll("E" , "W");
                ob.println("Case #"+testcase+": "+ans);
            } else if( x>=0 && y<=0 ) {
                String ans1 = "";
                for( char ch : ans.toCharArray() ) {
                    if( ch == 'S' )
                        ans1+="N";
                    else if( ch == 'W' )
                        ans1+="E";
                    else if( ch == 'N' )
                        ans1+="S";
                    else
                        ans1+="W";
                }
                ob.println("Case #"+testcase+": "+ans1);
            } else {
                String ans1 = "";
                for( char ch : ans.toCharArray() ) {
                    if( ch == 'S' )
                        ans1+="N";
                    else if( ch == 'W' )
                        ans1+="E";
                    else if( ch == 'N' )
                        ans1+="S";
                    else
                        ans1+="W";
                }
                ob.println("Case #"+testcase+": "+ans1);
            }
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
    void tr(Object... o) { 
        System.out.println(Arrays.deepToString(o)); 
    }

}
