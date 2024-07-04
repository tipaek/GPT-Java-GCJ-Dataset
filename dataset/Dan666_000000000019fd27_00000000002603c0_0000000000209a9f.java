import java.util.*;
public class Solution
{
    
    public static void main(String arg[])
    {
        for(int i=1;i<t;i++)
        {
            String s=new Scanner(System.in).nextLine();
            String n="";
            int co=0;
            for(int c=0,j=c+1;j<s.length();c++,j++)
            {
                if(s.charAt(c)=='1')
                {
                    co++;
                    if(co==1)
                    {
                        n+="(";
                    }
                    else if(co>1&&s.charAt(j)!='1')
                    {
                        n+=")";
                    }
                    else if(co>1&&s.charAt(j)=='1')
                    {
                        n+=s.substring(c,j);
                    }
                    else if(c==0&&s.charAt(c)!=s.charAt(j))
                    {
                        n+="(1)";
                    }
                }
                else if(s.charAt(c)=='0')
                {
                    n+=String.valueOf(s.charAt(c));
                    if(s.charAt(j)=='0')
                    n+=String.valueOf(s.charAt(j));
                }
            }
            System.out.format("Case :%d# %s",i,n);
        }
    }
    
}