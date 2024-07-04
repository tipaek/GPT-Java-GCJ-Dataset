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
            char c=s.charAt(0);
            char b='(';
            StringBuffer sb=new StringBuffer();
            if(c=='0')
               sb.append(c);
            else
             {
                sb.append('(');
                sb.append(c);
                b=')';
             }
             for(int i=1;i<s.length();i++)
             {
                if(s.charAt(i)==c)
                    sb.append(c);
                else
                {
                    sb.append(b);
                    sb.append(s.charAt(i));
                    c=s.charAt(i);
                    if(b==')')
                       b='(';
                    else
                       b=')';
                }
             }
             if(c=='1')
               sb.append(')');
            String y=sb.toString();
            
            System.out.println("Case #"+x+": "+y);
            T--;
            x++;
        }
    }
}