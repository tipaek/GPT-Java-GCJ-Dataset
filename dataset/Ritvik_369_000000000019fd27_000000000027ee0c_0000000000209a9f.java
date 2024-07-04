import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])throws IOException
    {
        Scanner r=new Scanner(System.in);
        int t=r.nextInt();
        for(int z=1;z<=t;z++)
        {
            String s=r.next();
            String ans="";
            int par=0,d=0;
            for(int i=0;i<s.length();i++)
            {
                int val=s.charAt(i)-48;
                if(par==val)
                {
                    ans+=s.charAt(i);
                }
                else if(val>par)
                {
                    d=val-par;
                    for(int j=1;j<=d;j++)
                    {
                        ans+="(";
                    }
                    par+=d;
                    ans+=s.charAt(i);
                }
                else
                {
                    d=par-val;
                    for(int j=1;j<=d;j++)
                    {
                        ans+=")";
                    }
                    par-=d;
                    ans+=s.charAt(i);
                }
            }
            if(par>0)
            {
                for(int i=1;i<=par;i++)
                {
                    ans+=")";
                }
            }
            System.out.println("Case #"+z+":"+" "+ans);
        }
    }
}