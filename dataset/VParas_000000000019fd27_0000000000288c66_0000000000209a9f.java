

import java.util.Scanner;

public class Solution {
    public static void main(String arg[])
    {
        Scanner ob=new Scanner(System.in);
        int t =ob.nextInt();
        int count =1;
        while(t!=0)
        {
            StringBuilder ab=new StringBuilder();
            String as=ob.next();
            int open=0;
            int r=(int)as.charAt(0)-48;
            open+=r;
            for(int j=0;j<r;j++)
            {
                ab.append("(");
            }
            ab.append(as.charAt(0));
            for(int i=1;i<as.length();i++)
            {
                r=(int)as.charAt(i)-48;
                int diff=r;
                diff-=((int)as.charAt(i-1)-48);
              //  System.out.println(diff);
                if(diff>=0)
                {
                    open+=diff;
                    for(int j=0;j<diff;j++)
                    {
                        ab.append("(");
                    }
                }else
                {
                    open+=diff;
                    for(int j=0;j<Math.abs(diff);j++)
                    {
                        ab.append(")");
                    }
                }
                ab.append(as.charAt(i));

             //   System.out.println(ab.toString());
            }
            for(int j=0;j<open;j++)
            {
                ab.append(")");
            }
            System.out.println("Case #"+count+": "+ab.toString());
            count++;
            t--;
        }
    }
}
