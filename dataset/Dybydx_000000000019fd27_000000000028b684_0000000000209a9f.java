import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int x=1;
        while(t-->0)
        {
            String s=sc.next();
            char a=s.charAt(0);
            String ans="";
            int count=0;
            int num = Integer.parseInt(String.valueOf(a));
            count=num;
            for(int i=0;i<count;i++)
            {
                ans=ans+"(";
            }
            ans=ans+a;
            for(int i=1;i<s.length();i++)
            {
                char c=s.charAt(i);
                char c1=s.charAt(i-1);
                int num1 = Integer.parseInt(String.valueOf(c1));
                int num2 = Integer.parseInt(String.valueOf(c));
                count=num1-num2;
                if(count<0)
                {
                    for(int j=0;j<-(count);j++)
                    {
                        ans=ans+"(";
                    }
                    ans=ans+c;
                }
                else
                {

                    for(int j=0;j<count;j++)
                    {
                        ans=ans+")";
                    }
                    ans=ans+c;
                }
            }
            a=s.charAt(s.length()-1);
            num = Integer.parseInt(String.valueOf(a));

            for(int j=0;j<num;j++)
            {
                ans=ans+")";
            }
            System.out.println("Case #"+x+": "+ans);
            x++;

        }
    }
}