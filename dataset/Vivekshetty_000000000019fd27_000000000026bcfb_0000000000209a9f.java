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
            String sol="";
            char c=s.charAt(0);
            if(c=='1')
            sol=sol+"(1";
            if(c=='0')
            sol=sol+'0';
            int ln=s.length();
            if(ln>1)
            {
            for(int j=1;j<ln;j++)
            {
                if(s.charAt(j)=='0')
                {
                    if(s.charAt(j-1)=='1')
                    sol=sol+")0";
                    if(s.charAt(j-1)=='0')
                    sol=sol+'0';
                }
                if(s.charAt(j)=='1')
                {
                    if(s.charAt(j-1)=='0')
                    sol=sol+"(1";
                    if(s.charAt(j-1)=='1')
                    sol=sol+'1';
                }
                
                }
                
            } if(s.charAt(ln-1)=='1')
                sol=sol+")";
                System.out.println(sol);
            }
         
        
        }
     }