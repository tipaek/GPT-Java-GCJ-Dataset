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
            String st="";
            char c=s.charAt(0);
            if(c=='1')
            st=st+"(1";
            if(c=='0')
            st=st+'0';
            int l=s.length();
            if(l>1)
            {
            for(int k=1;k<l;k++)
            {
                if(s.charAt(k)=='0')
                {
                    if(s.charAt(k-1)=='1')
                    st=st+")0";
                    if(s.charAt(k-1)=='0')
                    st=st+'0';
                }
                if(s.charAt(k)=='1')
                {
                    if(s.charAt(k-1)=='0')
                    st=st+"(1";
                    if(s.charAt(k-1)=='1')
                    st=st+'1';
                }
                
                }
                
            } if(s.charAt(l-1)=='1')
                st=st+")";
                System.out.println(st);
            }
         
        
        }
     }