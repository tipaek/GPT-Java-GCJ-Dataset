import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i1=1;i1<=t;i1++)
        {
            String s1=sc.next();
            String ans="";
            int pre=0;
            int close=0;
            for(int i2=0;i2<s1.length();i2++)
            {
                int n1=Integer.parseInt(Character.toString(s1.charAt(i2)));
                if(n1>pre)
                {
                    int n2=n1-pre;
                    for(int i3=0;i3<n2;i3++)
                        ans=ans+"(";
                    close=close+n2;
                    ans=ans+s1.charAt(i2);
                }
                else if(n1<pre)
                {
                    int n2=pre-n1;
                    for(int i3=0;i3<n2;i3++)
                        ans=ans+")";
                    close=close-n2;
                    ans=ans+s1.charAt(i2);
                }
                else
                    ans=ans+s1.charAt(i2);
                pre=n1;
                
            }
            for(int i2=0;i2<close;i2++)
                ans=ans+")";
            
            
            System.out.println("Case #"+i1+": "+ans);
        }
    }
}