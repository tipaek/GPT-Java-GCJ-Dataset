import java.io.*;
import java.util.*;

public class B
{
    static char [] s ;
    static final int INF = (int)1e9 ;
    static int dp[][] ;
    static StringBuilder sb;
    static int solve(int idx , int open)
    {
        if(idx == s.length)
            return open == 0 ? 0 : INF;
        if(open < 0)
            return INF ;
        if(dp[idx][open] != -1)
            return dp[idx][open] ;
        int ans = INF ;
        if(s[idx] == '#')
        {
            // open
            ans = Math.min(ans , 1 + solve(idx + 1 , open + 1)) ;
            // close
            ans = Math.min(ans , 1 + solve(idx + 1 , open - 1)) ;
            // leave
            ans = Math.min(ans , solve(idx + 1 , open)) ;
        }
        else if(s[idx] - '0' == open)
            ans = Math.min(ans , solve(idx + 1 , open)) ;
        return dp[idx][open] = ans ;
    }
    static void trace(int idx , int open)
    {
        if(idx == s.length || open < 0) return;
        int ans = solve(idx , open) ;
        if(s[idx] == '#')
        {
            if(ans == 1 + solve(idx + 1 , open + 1))
            {
                sb.append("(");
                trace(idx + 1 , open + 1);
            }
            else if(ans == 1 + solve(idx + 1 , open - 1))
            {
                sb.append(")") ;
                trace(idx + 1 , open - 1);
            }
            else if(ans == solve(idx + 1 , open))
            {
                trace(idx + 1 , open);
            }
        }
        else if(s[idx] - '0' == open && ans == solve(idx+  1 , open))
        {
            sb.append(s[idx]) ;
            trace(idx + 1 , open);
        }
    }
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out) ;
        int TC = sc.nextInt() ;
        for(int c = 1 ; c <= TC ; c++)
        {
            char [] T = sc.next().toCharArray() ;
            s = new char [T.length << 1 | 1] ;
            for(int i = 0 ; i < s.length ; i++)
                if(i % 2 == 0)
                    s[i] = '#' ;
                else
                    s[i] = T[i >> 1] ;
            dp = new int [s.length + 1][s.length + 1] ;
            for(int i  = 0 ;i <= s.length ; i++)
                Arrays.fill(dp[i] , -1);
            sb = new StringBuilder() ;
            trace(0 , 0);
            out.printf("Case #%d: %s\n" , c ,sb.toString());
        }
        out.flush();
        out.close();
    }
    static class Scanner
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        StringTokenizer st ;

        String next() throws Exception
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine()) ;
            return st.nextToken() ;
        }
        int nextInt() throws Exception
        {
            return Integer.parseInt(next()) ;
        }
        long nextLong() throws Exception
        {
            return Long.parseLong(next()) ;
        }
        double nextDouble() throws Exception
        {
            return Double.parseDouble(next()) ;
        }
    }

}

