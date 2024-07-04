import java.util.Scanner;
import java.io.*;

public class Solution{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        int n;
        n=in.nextInt();
        for(int i=0;i<n+1;i++)
        {
            String s=in.next();
            String str="";
            char c=s.charAt(0);
            if(c=='1')
            str=str+"(1";
            if(c=='0')
            str=str+'0';
            int lth=s.length();
            if(lth>1)
            {
            for(int j=1;j<lth;j++)
            {
                if(s.charAt(j)=='0')
                {
                    if(s.charAt(j-1)=='1')
                    str=str+")0";
                    if(s.charAt(j-1)=='0')
                    str=str+'0';
                }
                if(s.charAt(j)=='1')
                {
                    if(s.charAt(j-1)=='0')
                    str=str+"(1";
                    if(s.charAt(j-1)=='1')
                    str=str+'1';
                }
                
                }
                
            } if(s.charAt(ln-1)=='1')
                str=str+")";
                System.out.println(str);
            }
         
        
        }
     }
     