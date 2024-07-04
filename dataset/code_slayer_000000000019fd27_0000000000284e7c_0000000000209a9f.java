import java.util.*;

class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int x=1;
        while(T>0)
        {
            String s=sc.next();
            String s1=s;
            s1=s1.replaceAll("0"," ");	
            String[]str=s1.split("\\s+");
            StringBuffer sb=new StringBuffer();
            int j=0;
            int i=0;
            while(i<s.length())
            {
                if(s.charAt(i)=='0')
                {
                    sb.append(s.charAt(i));
                    i++;
                }
                else
                {
                    sb.append(fun(str[j]));
                    j++;
                    while(i<s.length() && s.charAt(i)!='0')
                    i++;
                }
            }
                    
            String y=sb.toString();
            
            System.out.println("Case #"+x+": "+y);
            T--;
            x++;
        }
    }
    
    static String fun(String s)
    {
        char c =s.charAt(0);
        int val=c-'0';
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<val;i++)
            {
                sb.append('(');
            }
            sb.append(c);
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==c)
                sb.append(c);
            else
            {
                int v=c-'0';
                for(int j=1;j<v;j++)
                    sb.append(')');
                c=s.charAt(i);
                v=c-'0';
                for(int j=1;j<v;j++)
                    sb.append('(');
                sb.append(c);    
            }
        }
        int va=c-'0';
        for(int i=1;i<va;i++)
            sb.append(')');
        String str= "("+ sb.toString() +")";
        return str;
    }
}
