import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=scan.nextInt();
        for(int tCount=1;tCount<=t;tCount++)
        {
            int n=scan.nextInt();
            if(n<=500)
            {
                System.out.println("Case #"+tCount+":");
                for(int i=1;i<=n;i++)
                    System.out.println(i+" 1");
            }
            else if(n==501)
            {
                System.out.println("Case #"+tCount+":");
                System.out.println("1 1\n2 1\n3 1\n3 2");//5 total
                for(int i=3;i<=498;i++)
                    System.out.println(i+" "+i);
            }
        }
    }
    
    static long pascal(int r, int k)
    {
        r--;
        k--;
        double result=1;
        for(int i=0;i<k;i++)
        {
            result*=r-i;
            result/=i+1;
        }
        return Math.round(result);
    }
    
}
