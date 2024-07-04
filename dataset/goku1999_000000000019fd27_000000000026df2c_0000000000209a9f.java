import java.util.*;
import java.io.*;
public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();  
        for (int i = 1; i <= t; ++i) 
        {
            String ans="";
            String s=sc.next();
            String r="";
            for(int x=0;x<s.length();x++)
            {
                char ch=s.charAt(x);
                if(ch=='0')
                {
                    if(r.length()!=0)
                    {
                        ans=ans+solve(r);
                    }
                    ans=ans+"0";
                    r="";
                }
                else
                {
                    r=r+ch;
                }
            }
            if(r.length()!=0)
            {
                ans=ans+solve(r);
            }
            System.out.println("Case #"+i+": "+ans);
        }
    }

    public static String solve(String s)
    {
        return "("+s+")";
    }
}