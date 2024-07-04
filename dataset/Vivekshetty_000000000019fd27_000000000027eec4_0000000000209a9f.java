import java.util.Scanner;
import java.io.*;

public class Solution{
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        int n;
        n=in.nextInt();
        for(int i=0;i<n;i++)
        {
            String s=in.next();
            String ste="";
            char x=s.charAt(0);
            if(x=='1')
            st=st+"(1";
            if(x=='0')
            ste=ste+'0';
            int lth=s.length();
            if(lth>1)
            {
            for(int k=1;k<lth;k++)
            {
                if(s.charAt(k)=='0')
                {
                    if(s.charAt(k-1)=='1')
                    ste=ste+")0";
                    if(s.charAt(k-1)=='0')
                    ste=ste+'0';
                }
                if(s.charAt(k)=='1')
                {
                    if(s.charAt(k-1)=='0')
                    ste=ste+"(1";
                    if(s.charAt(k-1)=='1')
                    ste=ste+'1';
                }
                
                }
                
            } if(s.charAt(lth-1)=='1')
                ste=ste+")";
                System.out.println("Case #"+(i+1)+": "+ste);
            }
         
        
        }
     }
