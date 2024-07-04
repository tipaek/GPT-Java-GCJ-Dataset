import java.util.*;

public class Solution 
{
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int ii=0; ii<t; ii++)
        {
            String s = in.next();
            String o="";
            int r=1;
            for(int i=0; i<s.length(); i++)
            {
                int xx = Integer.parseInt(s.charAt(i)+"");
                if(i!= 0 && xx <= Integer.parseInt(s.charAt(i-1)+""))
                {
                    if(xx!=0)
                    {
                        o=AddPN(Integer.parseInt(s.charAt(i-1)+"")-xx, o, xx);
                    }
                    else
                        o+="0";
                }
                else if(xx!=0 && CountPn(o)!=0)
                {
                    o=AddPr(Integer.parseInt(s.charAt(i-1)+"")-xx, o, xx, xx-CountPn(o));
                }
                else
                {
                    o += AddP(xx, xx);
                    r=1;
                }
            }
            System.out.println("Case #"+(ii+1)+": "+o);
        }
    }
    public static String AddPr(int x, String s, int n, int xx)
    {
        String o="";
        int p = CountP(s);
        o=s.substring(0, p+1);
        o+=AddP(n,xx);
        o+=s.substring(p+1, s.length());
        return o;
    }
    public static String AddPN(int x, String s, int n)
    {
        String o="";
        int p = CountP(s);
        o=s.substring(0, p+x+1);
        o+=n;
        o+=s.substring(p+x+1, s.length());
        return o;
    }
    public static int CountP(String s)
    {
        int x=0;
        for(int i=s.length()-1; i>=0; i--)
        {
            if(s.charAt(i)!= ')')
            {
                x= i;
                break;
            }
        }
        return x;
    }
    public static int CountPn(String s)
    {
        int x=0;
        for(int i=s.length()-1; i>=0; i--)
        {
            if(s.charAt(i)== ')')
            {
                x++;
            }
            else
            {
                break;
            }
        }
        return x;
    }
    public static String AddP(int x, int n)
    {
        if(x==0)
        {
            return "0";
        }
        String s="";
        for(int i=0; i<n; i++)
        {
            s+="(";
        }
        s+=x;
        for(int i=0; i<n; i++)
        {
            s+=")";
        }
        return s;
    }
}