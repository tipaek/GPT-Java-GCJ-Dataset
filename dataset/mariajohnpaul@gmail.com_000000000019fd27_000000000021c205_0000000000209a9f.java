import java.util.*;
public class Solution{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;t++)
        {
            String inp = sc.next();
            StringBuilder sb = new StringBuilder();
            char prev = '0';
            int count = 0;
            for(int i=0; i<inp.length();i++)
            {
                if(inp.charAt(i)!=prev)
                {
                    //required open
                    int re = (inp.charAt(i)-'0')-count;
                    if(re>0)
                    {
                        while(re-->0)sb.append("(");
                        sb.append(inp.charAt(i));
                        count=inp.charAt(i)-'0';
                    }else{
                        while(re++<0)sb.append(")");
                        sb.append(inp.charAt(i));
                        count = inp.charAt(i)-'0';
                    }
                }else{
                    sb.append(inp.charAt(i));
                }
                prev= inp.charAt(i);
            }
            if(count>0)while(count-->0)sb.append(")");
            System.out.println("Case #"+t+": "+sb.toString());

        }
    }
}