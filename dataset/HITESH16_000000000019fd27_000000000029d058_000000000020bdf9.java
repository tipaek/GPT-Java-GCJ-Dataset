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
            int n = Integer.parseInt(next());
            int[] activity = new int[2*1441];
            char[] ans = new char[n];
            int max=0;
            pw.print("Case #"+i+": ");
            for(int j=1;j<=n;j++)
            {
                int si = Integer.parseInt(next());
                int ei = Integer.parseInt(next());
                
                int h1=0,h2=0,h3=0,h4=0;
                for(int k=si;k<ei;k++)
                {
                    if(activity[k]==3)
                    {
                        h4=1;
                        break;
                    }
                    else if(activity[k]==0)
                    {
                        h1=1;
                    }
                    else if(activity[k]==1)
                    {
                        h2=1;
                    }
                    else
                    {
                        h3=1;
                    }
                    
                }
                if(h4==1)
                {
                    max=1;
                    pw.print("IMPOSSIBLE");
                    break;
                }
                else if(h2==1 && h3==1)
                {
                    max=1;
                    pw.print("IMPOSSIBLE");
                    break;
                }
                else if(h2==1)
                {
                    // pw.print("J");
                    ans[j-1] ='J';
                    for(int k=si;k<ei;k++)
                    {
                        activity[k]+=2;
                    }
                }
                else
                {
                    //pw.print("C");
                    ans[j-1] ='C';
                    for(int k=si;k<ei;k++)
                    {
                        if(activity[k]==0)
                        {
                            activity[k]=1;
                        }
                        else
                        {
                            activity[k]=3;
                        }
                    }
                }
            }
            if(max==0)
            {
                for(int j=0;j<n;j++)
                {
                    pw.print(ans[j]);
                }
            }
            pw.println();
        }
        pw.close();
    }
}
        