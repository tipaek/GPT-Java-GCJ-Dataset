import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        String a=sc.next();    
        while(t-- > 0)
        {
            char b;
            String ans="";
            for(int i=0;i<10;i++)
                ans += "0";
            for(int i=1;i<=10;i++)
            {
                System.out.println(i);
                b = sc.next().charAt(0);
                ans[i-1] = b;
            }
            System.out.println(ans);
            char fi;
            fi=sc.next().charAt(0);
            if(fi == 'Y')
                continue;
            else
                return 0;
        }
    }
}
            