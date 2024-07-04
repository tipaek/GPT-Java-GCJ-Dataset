import java.util.*;
import java.io.*;
public class Solution 
{
  public static void main(String[] args) 
  {
      int j,k,s,e;
      boolean f,f1,f2;
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) 
    {
        boolean she[]=new boolean[1441];
        boolean jhe[]=new boolean[1441];
        f=true;
        String ans="C";
        int n = in.nextInt();
        s = in.nextInt();
        e= in.nextInt();
        for(j=s;j<=e;j++)
        {
            she[j]=true;
        }
        for(j=2;j<=n;j++)
        {
            f1=f2=true;
            s = in.nextInt();
            e= in.nextInt();
            if(f)
            {
            for(k=s+1;k<e;k++)
            {
                if(she[k]==true)
                {
                    f1=false;
                    break;
                }
            }
            if(f1)
            {
                for(k=s;k<=e;k++)
                {
                    she[k]=true;
                }
                ans+="C";
            }
            else
            {
                for(k=s+1;k<e;k++)
                {
                    if(jhe[k]==true)
                    {
                        f2=false;
                        break;
                    }
                }
                if(f2)
                {
                    for(k=s;k<=e;k++)
                    {
                        jhe[k]=true;
                    }
                    ans+="J";
                }
            }
            if(f1==false&&f2==false)
            {
                ans="IMPOSSIBLE";
                f=false;
            }
        }
        }
      System.out.println("Case #" + i + ": " + ans);
    }
  }
}