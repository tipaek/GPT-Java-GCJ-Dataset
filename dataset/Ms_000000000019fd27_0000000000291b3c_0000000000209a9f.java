import java.util.*;

public class Solution 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for(int k=0; k<t; k++)
        {
            String s = sc.next();
            String s1="";
            int r=1;
            for(int i=0; i<s.length(); i++)
            {
                int a = Integer.parseInt(s.charAt(i)+"");
                if(i!= 0 && a <= Integer.parseInt(s.charAt(i-1)+""))
                {
                    if(a!=0)
                    {
                        s1=append(Integer.parseInt(s.charAt(i-1)+"")-a, s1, a);
                    }
                    else
                        s1+="0";
                }
                else if(a!=0 && counter(s1)!=0)
                {
                    s1=Addp(Integer.parseInt(s.charAt(i-1)+"")-a, s1, a, a-counter(s1));
                }
                else
                {
                    s1+= Add(a, a);
                    r=1;
                }
            }
            System.out.println("Case #"+(k+1)+": "+s1);
        }
    }
    public static String Addp(int x, String s, int n, int a)
    {
        String s1="";
        int p = CountP(s);
        s1=s.substring(0, p+1);
        s1+=Add(n,a);
        s1+=s.substring(p+1, s.length());
        return s1;
    }
    public static String append(int x, String s, int n)
    {
        String s1="";
        int p = CountP(s);
        s1=s.substring(0, p+x+1);
        s1+=n;
        s1+=s.substring(p+x+1, s.length());
        return s1;
    }
    public static int CountP(String s2)
    {
        int x=0;
        for(int i=s2.length()-1; i>=0; i--)
        {
            if(s2.charAt(i)!= ')')
            {
                x= i;
                break;
            }
        }
        return x;
    }
    public static int counter(String s2)
    {
        int x=0;
        for(int i=s2.length()-1; i>=0; i--)
        {
            if(s2.charAt(i)== ')')
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
    public static String Add(int x, int n)
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