import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])throws java.lang.Exception
    {
        Scanner in=new Scanner(System.in);
        String s="",st="",p="",t="";int l,i,d,m=0,j,q,r,k,T;
        try{
        T=in.nextInt();
        if(T>=1&&T<=100)
        {
            for(k=1;k<=T;k++)
            {
                st="";
                s=in.next();
        l=s.length();
        if(l>=1&&l<=100)
        {
            for(i=0;i<l;i++)
        {
            p=s.substring(i,i+1);
            d=Integer.parseInt(p);
            if(i>0)
            {
            t=s.substring(i-1,i);
            m=Integer.parseInt(t);
        }
            if(i==0)
            {
                if(d!=0)
                {
                for(j=1;j<=d;j++)
                st+='(';
            }
            }
            else
            {
                if(m>d)
                {
                    r=m-d;
                    for(q=1;q<=r;q++)
                    st+=')';
                }
                else
                {
                    r=d-m;
                    for(q=1;q<=r;q++)
                    st+='(';
                }
            }
            st+=p;
        }
          p=s.substring(l-1,l);
            d=Integer.parseInt(p);
        for(i=1;i<=d;i++)
        st+=')';
        System.out.println("Case #"+k+": "+st);
        }
            }
        }
    }catch(Exception e)
    {
        return;
    }
    }
}