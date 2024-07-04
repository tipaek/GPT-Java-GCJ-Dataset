

import java.util.Scanner;

public class Solution
{
    public static void main(String[] stp) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int t,b;
        t=scan.nextInt();b=scan.nextInt();
        while(t-- > 0)
        {
            StringBuilder sb=new StringBuilder();
            for(int i=1;i<=b;i++)
            {
                System.out.println(i);
                System.out.flush();
                int n=scan.nextInt();
                String s="";
                s+=""+n;
                sb.append(s);
            }
            System.out.println(sb.toString());
            System.out.flush();
            String ans;
            ans=scan.next();
        }
    }
}