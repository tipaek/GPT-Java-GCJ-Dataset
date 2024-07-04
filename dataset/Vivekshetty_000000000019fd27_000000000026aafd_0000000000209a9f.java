import java.util.Scanner;
import java.io.*;

public class Solution{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0;i<n ;i++)
        {
            String s = in.next();
            String sol = "";
            char t = s.charAt(0);
            if(t == '1')
            {
                sol = sol + "(1";
            }
            else
            {
                sol = sol +"0";
            }
        }
        
        int l = s.length();
        if(l>1)
        {
            for(int j = 1;j<=l;j++)
            {
                if(s.charAt(j)=='0' && s.charAt(j-1) == '1')
                {
                    sol = sol + ")0";
                }
                else if(s.charAt(j)=='1' && s.charAt(j-1) == '1')
                {
                    sol = sol + "1";
                }
                else if(s.charAt(j)=='1' && s.charAt(j-1) == '0')
                {
                    sol = sol + "(1";
                }
                else
                {
                    sol = sol + "0";
                }
            }
        }
        System.out.println(sol);
    }
}
        
        
        
        