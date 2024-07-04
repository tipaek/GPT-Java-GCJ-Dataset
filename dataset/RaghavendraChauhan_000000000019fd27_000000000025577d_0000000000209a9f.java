import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        int p=t;
       String a[]=new String[t];
        sc.nextLine();
        while(p-->0)
        {
           String str=sc.nextLine();
        String s="";
        int n=str.length();
        for(int i=0;i<n;i++)
        {
        char ch=str.charAt(i);
        if(ch=='0')
        {s=s+'0';continue;}
        else
        {
            s=s+'('+'1';
            if(i<n-1)
            for(int j=i+1;j<n;j++)
            if(str.charAt(j)=='0'){i=j;s=s+")"+"0";break;}
            else
            {
                s=s+"1";
            }
        }}
        if(str.lastIndexOf('1')==n-1)
        s=s+")";
        a[t-p-1]=s;
        }
        
        
   for(int i=1;i<=t;i++)
      System.out.println("Case #"+i+": "+a[i-1]);
}}
