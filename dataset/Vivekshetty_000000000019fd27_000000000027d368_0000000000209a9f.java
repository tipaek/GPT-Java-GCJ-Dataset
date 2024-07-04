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
            char x=s.charAt(0);
            if(x=='1')
            str=str+"(1";
            if(x=='0')
            str=str+'0';
            int ln=s.length();
            if(ln>1)
            {
            for(int k=1;k<l;k++)
            {
                if(s.charAt(k)=='0')
                {
                    if(s.charAt(k-1)=='1')
                    str=str+")0";
                    if(s.charAt(k-1)=='0')
                    str=str+'0';
                }
                if(s.charAt(k)=='1')
                {
                    if(s.charAt(k-1)=='0')
                    str=str+"(1";
                    if(s.charAt(k-1)=='1')
                    str=str+'1';
                }
                
                }
                
            } if(s.charAt(ln-1)=='1')
                str=str+")";
                System.out.println(str);
            }
         
        
        }
     }