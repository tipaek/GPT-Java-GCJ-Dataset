import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,count=0,c=1,i,n;
        char ch=' ';
        t=Integer.parseInt(br.readLine());
        while(c<=t)
        {
            String str="";
            count=0;
           String s=br.readLine();
           for(i=0;i<s.length();i++)
           {
               ch=s.charAt(i);
               n=(int)ch-48;
                if(count<n)
               {
                   while(count<n)
                   {
                    str=str+"(";
                    count++;
                   }
               }
               else if(count>n)
               {
                   while(count>n)
                   {
                   str=str+")";
                   count--;
                   }
               }
               str=str+ch;
               /*if(n=='0')
               {
               while(count>0)
                str=str+")";
               }*/
           }
           while(count>0)
           {
               str=str+")";
               count--;
           }
            System.out.println("Case #"+c+": "+str);
            c++;
        }
    }
}