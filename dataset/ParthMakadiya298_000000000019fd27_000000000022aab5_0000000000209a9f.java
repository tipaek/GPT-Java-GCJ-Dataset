import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{
        public static void main(String args[])
        {
            Scanner s=new Scanner(System.in);
            int testcase=s.nextInt();s.nextLine();
            String input[]=new String[testcase];
            String output[]=new String[testcase];
            for(int i=0;i<testcase;i++)
            {
                input[i]=s.nextLine();
            }
            for(int i=0;i<testcase;i++)
            {
                String temp=input[i];
                for(int j=0;j<temp.length();j++)
                {
                    if(temp.charAt(j)==0)
                    {
                        output[i]=output[i]+temp.charAt(j);
                    }
                    else if(temp.charAt(j)==1)
                    {
                        output[i]=output[i]+"("+temp.charAt(j)+")";
                    }
                }
            }
            for(int i=0;i<testcase;i++)
            {
                System.out.println("Case #1:"+ output[i]);
            }
        }
}