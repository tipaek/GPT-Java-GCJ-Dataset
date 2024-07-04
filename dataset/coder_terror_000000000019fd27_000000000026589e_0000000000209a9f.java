import java.util.*;
public class Solution
{
    static int mod = (int) 1e9 + 7;
    static int Infinity=Integer.MAX_VALUE;
    static int negInfinity=Integer.MIN_VALUE;
    public static void main(String args[])
    {
        try
        {
            Scanner sc= new Scanner(System.in);
            int k,p,q;
            int t=sc.nextInt();
            char ch;
            String s1;
            sc.nextLine();
            for(int i=1;i<=t;i++)
            {
               String s=sc.nextLine();
                int l=s.length();
                int j=p=0;
                s1="";
                while(j<l && s.charAt(j)=='0')
                {
                    s1=s1+"0";
                    j++;
                }
                for(k=j;k<l;k++)
                {
                    ch=s.charAt(k);
                    q=(int)ch-48;
                    while(p<q)
                    {
                        s1=s1+"(";
                        p++;
                    }
                    while(p>q)
                    {
                        s1=s1+")";
                        p--;
                    }
                    s1=s1+ch;
                }
                while(p>0)
                {
                    s1=s1+")";
                    p--;
                }
                System.out.println("Case #"+i+": "+s1); 
            }
        }
        catch(Exception e)
        {
            return;
        }
    }

    
}