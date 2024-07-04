import java.util.*;
import java.io.*;
class Solution
{
    public static Scanner sc = new Scanner(System.in);
    public static String man(String s)
    {
        if(s.length()==1)
        {
            if(s.charAt(0)=='1')
            return "(1)";
            else
            return "0";
        }
        String result="";
        if(s.charAt(0)=='1')
        {
            if(s.charAt(1)=='1')
            result = result + "(1";
            else
            result  = result +"(1)";
        }
        else
        {
            if(s.charAt(1)=='1')
            {
                result  = result+"0(";
            }
            else
            result = result+"0";
        }
        for(int i=1;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='1')
            {
                if(s.charAt(i+1)=='0')
                result = result + "1)";
                else
                result = result + "1";
            }
            else if(s.charAt(i)=='0')
            {
                if(s.charAt(i+1)=='1')
                result = result  + "0(";
                else
                result  = result + "0";
            }
        }
        if(s.charAt(s.length()-1)=='1')
        {
            result = result + "1)";
        }
        else
        {
            result = result + "0";
        }
        return result;
    }
    public static void main(String args[])
    {
        int t = sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            String a = sc.next();
            a = man(a);
            System.out.println("Case #"+i+": "+a);
        }
    }
}