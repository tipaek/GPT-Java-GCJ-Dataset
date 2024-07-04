import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int t = obj.nextInt();
        int z=0;
        while(z<t)
        {
            String str = obj.next();
            int open=0;
            String ans="";
            for(int i=0;i<str.length();i++)
            {
                char c= str.charAt(i);   
                int a = (int)c;
                a=a-48;
                while(open-a>0)
                {
                    ans=ans+")";
                    open--;
                }
                while(a-open>0)
                {
                    ans=ans+"(";
                    open++;
                }
                ans=ans+c;
            
            }
            while(open>0)
            {
                ans=ans+")";
                open--;
            }
            System.out.println("Case #"+(z+1)+": "+ans);
            
            z++;
        }
    }
}