import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = s.nextInt();
        int U = T;
        while(T>0)
        {
            
            String str = s.next();
            int c = 0;
            String ans = "";
            for(int i = 0;i<str.length();++i)
            {
                int dig = (int)(str.charAt(i) - '0');
                if(c == dig)
                {
                    ans = ans + str.charAt(i);
                }
                else if(c < dig)
                {
                    while(c!=dig)
                    {
                        ans = ans + '(';
                        c++;
                    }
                    ans = ans + str.charAt(i);
                }
                else
                {
                    while(c!=dig)
                    {
                        ans = ans + ')';
                        c--;
                    }
                    ans = ans + str.charAt(i);
                }
            }
            
            while(c!=0)
            {
                ans = ans + ')';
                c--;
            }
            
            System.out.println("Case #" + (U-T+1) + ": " + ans);
            T--;
        }
    }
}