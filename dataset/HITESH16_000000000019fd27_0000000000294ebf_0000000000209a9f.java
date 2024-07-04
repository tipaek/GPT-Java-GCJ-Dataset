import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static StringTokenizer st;
    
    static String next()
        {
            while(st==null || !st.hasMoreElements()) 
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
    public static void main(String[] args) throws java.lang.Exception
    {
        // Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(next());
        for(int i=1;i<=t;i++)
        {
            String ss = next();
            int len = ss.length();
            int k=-1,op=0;
            char[] ans = new char[18*len];
            for(int j=0;j<len;j++)
            {
                char nhi = ss.charAt(j);
                int chai = nhi-48;
                int check = chai - op;
                if(check>0)
                {
                    while(check-->0)
                    {
                        k++;
                        ans[k]='(';
                        op++;
                    }
                }
                else if(check<0)
                {
                    for(int chal=check;chal<0;chal++)
                    {
                        k++;
                        ans[k]=')';
                        op--;
                    }
                }
                
                k++;
                ans[k]=nhi;
                
            }
            
            while(op-->0)
            {
                k++;
                ans[k]=')';
            }
            
            String total = String.valueOf(ans);
            pw.println("Case #"+i+": "+total);
        }
        pw.close();
    }
}