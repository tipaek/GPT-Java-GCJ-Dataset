import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int ti=1;ti<=test;ti++)
        {
            String n = sc.next();
            int cb=0; String ans="";
            for(int i=0;i<n.length();i++)
            {
                String tmp = ""; char a = n.charAt(i); tmp=tmp+a;
                int cn = Integer.parseInt(tmp);
                int req = cb-cn;
                if(req<0)
                {
                    for(int j=req;j<0;j++)
                     ans=ans+"(";
                    ans=ans+cn;
                }
                else if(req>0)
                {
                    for(int j=1;j<=req;j++)
                     ans=ans+")";
                    ans=ans+cn;
                }
                else
                   ans=ans+cn;
                cb=cn;
            }
            if(cb>0)
            for(int i=cb;i>0;i--)
             ans=ans+")";
            System.out.println("Case #"+ti+": "+ans);
        }
        sc.close();
    }
}