import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution
{   public static void main(String[] args)
{
    Scanner in=new Scanner(System.in);
    int i,j,n,t,l,a,b,x;
    char m;
        t=in.nextInt();
        for(i=0;i<t;i++)
        {
            String s,s1;
            s1="";
            s=in.next();
           a=Integer.parseInt(String.valueOf(s.charAt(0)));
             b=Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
            for(x=0;x<a;x++)
                {
                    s1+="(";
                }
                s1+=s.charAt(0);
            for(j=0;j<s.length()-1;j++)
            {
                a=Integer.parseInt(String.valueOf(s.charAt(j)));
                b=Integer.parseInt(String.valueOf(s.charAt(j+1)));
               
                if(a>b)
                {
                    for(x=0;x<a-b;x++)
                    {
                        s1+=")";
                    }
                     s1+=s.charAt(j+1);
                }
                else if(a<b)
                {
                    for(x=0;x<b-a;x++)
                    {
                        s1+="(";
                    }
                     s1+=s.charAt(j+1);
                }
                else if(a==b)
                {
                    s1+=s.charAt(j+1);
                }
               
       
            }
             for(x=0;x<b;x++)
                {
                    s1+=")";
                }
           
            System.out.println("Case #"+(i+1)+": "+s1);
        }
}
}