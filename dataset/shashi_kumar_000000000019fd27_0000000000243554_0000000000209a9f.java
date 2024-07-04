import java.util.*;
public class Solution
{
    public static StringBuilder add(char ch,int ln)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ln;i++)
            sb.append(ch);
        return sb;
    }
    
    public static void main(String arg[])
    {
        Scanner obj=new Scanner(System.in);
        int test=obj.nextInt();
        for(int t=1;t<=test;t++)
        {
            
            StringBuilder s=new StringBuilder(obj.next());
            StringBuilder res=new StringBuilder();
            int f=s.charAt(0)-'0';
            int flag=0;
            int len=s.length();
            res.append(add('(',f));
            flag=f;
            res.append(s.charAt(0));
            //System.out.println(res);
            for(int i=1;i<len;i++)
            {
                int a=s.charAt(i-1)-'0';
                int b=s.charAt(i)-'0';
                int k=b-a;
                if(k<0)
                {
                    res.append(add(')',-1*k));
                }
                else if(k>0)
                {
                    res.append(add('(',k));
                }
                res.append(b+"");
                flag+=k;
            }
            res.append(add(')',flag));
            System.out.println(res);
        }
        
    }
}