import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int lol=1;lol<=t;lol++)
        {
            double x=sc.nextInt();double y=sc.nextInt();
            System.out.println("Case #"+lol+": "+recurse(0,x,y,0,0,"",0));
        }
        sc.close();
    }
    public static String recurse(int l,double x, double y,double a, double b,String t,int r)
    {
        if(a==x&&b==y)
        {return t;}
        if(r>10)
        {return "IMPOSSIBLE";}
        String k="IMPOSSIBLE";
        String n=recurse(l+1,x,y,a,b+Math.pow(2,l),t+"N",r+1);
        String e=recurse(l+1,x,y,a+Math.pow(2,l),b,t+"E",r+1);
        String w=recurse(l+1,x,y,a-Math.pow(2,l),b,t+"W",r+1);
        String s=recurse(l+1,x,y,a,b-Math.pow(2,l),t+"S",r+1);
        if(!"IMPOSSIBLE".equals(n)&&k.length()>n.length())
        {k=n;}
        if(!"IMPOSSIBLE".equals(e)&&k.length()>e.length())
        {k=e;}
        if(!"IMPOSSIBLE".equals(w)&&k.length()>w.length())
        {k=w;}
        if(!"IMPOSSIBLE".equals(s)&&k.length()>s.length())
        {k=s;}
        return k;
    }
}