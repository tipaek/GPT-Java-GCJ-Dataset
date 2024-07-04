import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=1;i<=test;i++)
        {
            String s=sc.next()+"0";
            StringBuffer sb=new StringBuffer();
            if(s.charAt(0)==0)
                sb.append("0");
            else
            {
                int x=Integer.parseInt(String.valueOf(s.charAt(0)));
                int count=x;
                while(count!=0)
                {
                    sb.append("(");
                    count--;
                }
            }
            for(int j=0;j<s.length()-1;j++)
            {
                sb.append(s.charAt(j));
               int z=Integer.parseInt(String.valueOf(s.charAt(j)));
               int y=Integer.parseInt(String.valueOf(s.charAt(j+1)));
               int diff=y-z;
               if(diff>=0)
               {
                   while(diff!=0)
                   {
                       sb.append("(");
                       diff--;
                   }
               }
               else
               {
                   while(diff!=0)
                   {
                       sb.append(")");
                       diff++;
                   }
               }
            }
            System.out.println("Case #"+i+""+": "+sb);
        }
    }
}

