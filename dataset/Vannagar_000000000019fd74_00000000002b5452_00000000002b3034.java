import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=1;x<=t;x++)
        {
            int n=sc.nextInt();sc.nextLine(); String a=""; boolean b=false;
            System.out.print("Case #"+x+": ");
            String[] r=new String[n];
            for(int y=0;y<n;y++)
            {
                r[y]=sc.nextLine();
            }
            String f="";
            for(int y=0;y<n;y++)
            {
                if(f.indexOf(r[y].substring(0,r[y].indexOf("*")))==-1&&r[y].indexOf(f)>=0)
                {f=r[y].substring(0,r[y].indexOf("*"));}
                else if(f.indexOf(r[y].substring(0,r[y].indexOf("*")))>=0)
                {continue;}
                else
                {a="*";b=true;break;}
            }
            if(b)
            {System.out.println(a);continue;}
            String g="";
            for(int y=0;y<n;y++)
            {
                if(f.indexOf(r[y].substring(r[y].indexOf("*")+1))==-1&&r[y].indexOf(f)>=0)
                {g=r[y].substring(r[y].indexOf("*")+1);}
                else if(f.indexOf(r[y].substring(r[y].indexOf("*")+1))>=0)
                {continue;}
                else
                {a="*";b=true;break;}
            }
            if(b)
            {System.out.println(a);continue;}
            System.out.println(f+g);
        }
    }
}