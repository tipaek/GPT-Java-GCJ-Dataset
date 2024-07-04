import java.util.*;
import java.io.*;
public class Patterns
{
    public static void main(String[] args)
    {
        Scanner ob = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = ob.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i)
        {
            int n = ob.nextInt();
            String s1="",s[]=new String[n];
            int max=0;
            for(int j=0;j<n;j++)
            {
                s[j]=ob.next();
                if(max<s[j].length())
                {
                    max=s[j].length();
                    s1=s[j];
                }
            }
            int w=0;
            for(int q=0;q<n;q++)
            {
                for(int k=1;k<(s1.length()-1);k++)
                {
                    if(s1.substring(k,s1.length()).equals(s[q].substring(1,s[q].length())))
                    {
                        w++;
                        break;
                    }
                }
            }
            if(w==n)
                System.out.println(s1.substring(1,s1.length()));
            else
                System.out.println("*");
        }
    }
}