



import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String s[])                                                 
    {
        Scanner input=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=input.nextInt();
        for (int i=1;i<=T; i++)
        {
           String result=test(input);
           System.out.println("Case #"+i+": "+result);
        }
    }
    
    public static String test(Scanner input) 
    {
        boolean c[]=new boolean[1441];
        boolean j[]=new boolean[1441];
        
        String result="";
        
        boolean r; 
        
        int n=input.nextInt();
        int w[][]=new int[n][2];
        
        for (int i=0;i<n; i++)
        {
            w[i][0]=input.nextInt();
            w[i][1]=input. nextInt();
        }
        
        for (int i=0;i<n; i++)
        {
            int t1=w[i][0];
            int t2=w[i][1];
            if(!c[t1])
            {
                r=fill(c, t1,t2);
                if (r)
                {
                    result+="C";
                    continue;
                }
            }
            
            if (!j[t1])
            {
                r=fill(j, t1,t2);
                if (r)
                {
                    result +="J";
                    continue; 
                }
            }
            return "IMPOSSIBLE";
        }
        
        return result; 
    }
    
    
    
    public static boolean fill(boolean p[],int a, int b)
    {
        for (int i=a; i<=b; ++i)
        {
            if (!p[i])
            {
                p[i]=true;
            }
            else
            {
                for (int j=a; j<i; j++)
                {
                    p[j]=false; 
                }
                return false; 
            }
        }
        return true; 
    }
    
}