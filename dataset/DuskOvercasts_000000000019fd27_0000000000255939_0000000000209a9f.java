import java.util.*;
class Solution
{
    static String put(String str,int open,int close)
    {
        for(int i=0;i<open;i++)
        str=str+"(";
        for(int i=0;i<close;i++)
        str=str+")";
        return str;
    }
    public static void main(String[]args)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            sc.nextLine();
            for(int q=1;q<=t;q++)
            {
                String s=sc.nextLine();
                String ss="";
                int l=s.length();
                int prev=Integer.parseInt(Character.toString(s.charAt(0)));
                ss=put(ss,prev,0);
                ss=ss+s.charAt(0);
                int cl=0;
                cl+=prev;
               for(int i=1;i<l;i++)
                {
                    int nxt=Integer.parseInt(Character.toString(s.charAt(i)));
                    int diff=nxt-prev;
                    if(diff>0)
                    {
                        ss=put(ss,diff,0);
                        cl+=diff;
                    }
                    else
                    {
                        diff=Math.abs(diff);
                        ss=put(ss,0,diff);
                        cl-=diff;
                    }
                    ss=ss+s.charAt(i);
                    prev=nxt;
                }
                ss=put(ss,0,cl);
                System.out.println("Case #"+q+": "+ss);
            }
        }
        catch(Exception e)
        {
            return;
        }
    }
}