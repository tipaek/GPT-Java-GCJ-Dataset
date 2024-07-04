import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution
{
    static boolean checkPrefix(String x, String y)
    {
        //System.out.println()
        if(x.length()<=y.length())
        {
            for(int i=0;i<x.length();i++)
            {
                if(x.charAt(i)!=y.charAt(i))
                {
                    return false;
                }
            }
        }
        else
        {
            for(int i=0;i<y.length();i++)
            {
                if(x.charAt(i)!=y.charAt(i))
                {
                    return false;
                }
            }
        }
        return true;

    }
    static boolean checkSuffix(String x, String y)
    {
        //System.out.println(x+" , "+y);
        if(x.length()<=y.length())
        {
            for(int i=x.length()-1;i>=0;i--)
            {
                if(x.charAt(i)!=y.charAt(i+y.length()-x.length()))
                {
                    return false;
                }
            }
        }
        else
        {
            for(int i=y.length()-1;i>=0;i--)
            {
                if(x.charAt(i+x.length()-y.length())!=y.charAt(i))
                {
                    //System.out.println("fuck");
                    return false;
                }
            }
        }
        return true;

    }
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        int test=1;
        while(t>0)
        {
            t--;
            System.out.println("Case #"+test+": ");
            test++;
            int n=in.nextInt();
            System.out.println(1+" "+1);
            if(n>=2)
                System.out.println(2+" "+1);
            if(n>=3)
                System.out.println(2+" "+2);
            int cnt=3;
            if(n>=4)
            {
                int i=3;
                while(cnt<n)
                {
                    System.out.println(i+" "+i);
                    i++;
                    cnt++;
                }
            }
        }
    }

}
