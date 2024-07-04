

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main (String s[])
    {
    Scanner input=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T=input.nextInt();
    for (int i=1;i<=T;++i)
    {
        String result=test(input);
        System.out.println("Case #"+i+": "+result) ;
    }
    }
    
    public static String test(Scanner input) 
    {
        int n=input.nextInt();
        
        int m[][]=new int[n][n];
        for (int i=0;i<n; ++i)
        {
            //String s=input.next();
            //String v[]=s.split(" ");
            for (int j=0;j<n;j++)
            {
                m[i][j]=input.nextInt();//Integer.parseInt(v[j]);
            }
        }
        
        int trace=0,row=0, col=0;
        int rv=0,cv=0;
        for (int i=0;i<n; ++i)
        {
            trace+=m[i][i];
            boolean r[]=new boolean[n];
            boolean c[]=new boolean[n];
            
            for (int j=0;j<n;++j)
            {
                rv=m[i][j]-1;
                
                
                if (!r[rv])
                {
                    r[rv]=true; 
                }
                else
                {
                    row++;
                    break; 
                }
            }
            for (int j=0;j<n; ++j)
            {
                cv=m[j][i]-1;
                if (!c[cv])
                {
                    c[cv]=true;
                }
                else
                {
                    col++;
                    break; 
                }
            }
            
            
        }
        
        
        return trace+" "+row+" "+col;
        
    }
    
    
}