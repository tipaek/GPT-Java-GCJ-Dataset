


import java.util.*;
import java.io.*;



public class Solution
{
    public static void main(String[] s)                                            
    {
        Scanner input=new Scanner(new BufferedReader(new InputStreamReader(System.in)));                           
        int T=input.nextInt();
        for (int i=1;i<=T; i++)
        {
            String r[]=test(input) ;
            System.out.println("Case #"+i+": "+r[0]) ;
            for (int j=1;j<r.length; j++)
            System.out.println(r[j]);
            
        }
    }
    public static String[] test(Scanner input) 
    {
        int n=input.nextInt();
        int k=input.nextInt();
        
        String r[]=new String[n+1];
        r[0]="POSSIBLE";
        
        if (k%n!=0)
        {
            r=new String[1];
            r[0]="IMPOSSIBLE";
            return r; 
        }
        
        int s=k/n; 
        
        for (int i=0;i<n; ++i)
        {
            r[i+1]="";
            for (int j=-i; j<n-i; ++j)
            {
                r[i+1]+=(j+s+n-1)%n+1+" ";
            }
        }
        return r; 
    }
}