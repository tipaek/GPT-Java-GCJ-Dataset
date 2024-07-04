


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
            String r=test(input) ;
            System.out.println("Case #"+i+": "+r) ;
        }
    }
    public static String test(Scanner input) 
    {
        int n=input.nextInt();
        int k=input.nextInt();
        
        String r="POSSIBLE";
        
        if (k%n!=0)
        return "IMPOSSIBLE";
        
        int s=k/n; 
        
        for (int i=0;i<n; ++i)
        {
            r+="\n";
            for (int j=-i; j<n-i; ++j)
            {
                r+=(j+s+n-1)%n+1+" ";
            }
        }
        return r; 
    }
}