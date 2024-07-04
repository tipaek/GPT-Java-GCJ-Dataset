import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();sc.nextLine();
        for(int y=1;y<=t;y++)
        {
            String s=sc.nextLine();
            String a="";
            for(int x=0;x<s.length();x++)
            {
                if(!s.substring(x,x+1).equals("(")&&!s.substring(x,x+1).equals(")"))
                {a+=s.substring(x,x+1);}
            }
            String k="";int o=0;
            for(int x=0;x<a.length();x++)
            {
                int w=Integer.parseInt(a.substring(x,x+1));
                int q=w-o;o=w;
                if(q>=0)
                {
                    for(int e=0;e<q;e++)
                    {k+="(";}
                }
                else
                {
                    for(int e=0;e<-1*q;e++)
                    {k+=")";}
                }
                k+=w;
            }
            for(int x=0;x<o;x++){k+=")";}
            System.out.println("Case #"+y+": "+k);
        }
    }
}