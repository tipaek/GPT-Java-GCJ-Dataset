import java.util.*;
import java.io.*;

class Solution
{
    public static int hasDupR(int [][]x)
    {
        boolean br = false;
        int res = 0;
        for(int i=0; i<x.length;i++)
        {
            for(int j=0;j<x.length;j++)
            {
                int num = x[i][j];
                for(int k=j+1; k<x.length; k++)
                {
                    if(num == x[i][k])
                        br=true;
                }
            }
            if(br)
            {
                res++;
                br=false;
            }
        }
        return res;
    }

    public static int hasDupC(int [][]x)
    {
        boolean br = false;
        int res = 0;
        for(int i=0; i<x.length;i++)
        {
            for(int j=0;j<x.length;j++)
            {
                int num = x[j][i];
                for(int k=j+1; k<x.length; k++)
                {
                    if(num == x[k][i])
                        br=true;
                }
            }
            if(br)
            {
                res++;
                br=false;
            }
        }
        return res;
    }

    public static void main (String[] args) throws IOException
    {
        try
        {
            Scanner ob=new Scanner(System.in);
            int t = ob.nextInt();
            while(t!=0)
            {
                int n = ob.nextInt();
                int a[][] = new int[n][n];
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                        a[i][j]=ob.nextInt();
                }
                int sumd=0;
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        if(i==j)
                            sumd=sumd+a[i][j];
                    }
                }

                int rr = hasDupR(a);
                int rc = hasDupC(a);

                System.out.println("Case #"+t+": "+sumd+" "+rr+" "+rc);
                --t;
            }
        }
        catch(Exception e){
            System.out.println("weird");
        }
    }
}
