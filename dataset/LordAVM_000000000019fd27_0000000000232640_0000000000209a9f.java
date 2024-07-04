import java.io.*;
import java.util.*;
class cjprac
{
    public static void main(String args [])throws IOException
    {
        Scanner sc= new Scanner(System.in);
        int t_case=sc.nextInt();
        System.out.print("");
        String s;
        for(int i=1;i<=t_case+1;i++)
        {
            s=sc.nextLine();
            int l=s.length();
            String ans="";
            for(int ii=0;ii<l;ii++)
            {
                if(ii==0)
                {
                    int t1=(int)s.charAt(ii)-(int)'0';
                    for(int i1=1;i1<=t1;i1++)
                    {
                        ans=ans+"(";
                    }
                }
                ans=ans+s.charAt(ii);
                if(ii==(l-1))
                {
                    int t2=(int)s.charAt(ii)-(int)'0';
                    for(int i1=1;i1<=t2;i1++)
                    {
                        ans=ans+")";
                    }
                }
                else
                {
                    int t3=(int)s.charAt(ii+1)-(int)s.charAt(ii);
                    int t4;
                    if(t3>=0)
                    {
                        for(t4=1;t4<=t3;t4++)
                        ans=ans+"(";
                    }
                    else
                    {
                        for(t4=1;t4<=(t3*(-1));t4++)
                        {
                            ans=ans+")";
                        }
                    }
                }
            }
            if(i>1)
            System.out.println("Case #"+(i-1)+": "+ans);
        }
    }
}