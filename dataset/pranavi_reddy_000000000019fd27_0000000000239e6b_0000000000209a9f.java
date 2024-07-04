import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        int el=1;
        while(t!=0)
        {
            t--;
            String ans="";
            String s=sc.nextLine();
            int open=0;
            int mike;
            for(int i=0;i<s.length();i++)
            {
                int check=Integer.parseInt(""+s.charAt(i));
                if(open<check)
                {
                    mike=check-open;
                    open=check;
                    while(mike!=0)
                    {
                        ans=ans+"(";
                        mike--;
                    }
                }
                else if(open>check)
                {
                  mike=open-check;
                   open=check;
                   while(mike!=0)
                    {
                        ans=ans+")";
                        mike--;
                    }
                   
                }
                ans=ans+s.charAt(i);
            }
            while(open!=0)
            {
                ans=ans+")";
                open--;
            }
            System.out.println("Case #"+el+": "+ans);
            el++;
        }
    }
}