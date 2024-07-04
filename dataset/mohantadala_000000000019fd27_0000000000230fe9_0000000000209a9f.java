import java.util.*;
import java.io.*;
import java.lang.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.next());
        
        for(int i=0;i<t;i++)
        {int count=0;
         int eq=0;
            String s=sc.next();
            String ans="";
            String temp="";
            for(int x=0;x<Integer.parseInt(String.valueOf(s.charAt(0)));x++)
            ans+="(";
            ans+=s.charAt(0);
            count+=Integer.parseInt(String.valueOf(s.charAt(0)));
            for(int k=1;k<s.length();k++)
            {
                if(Integer.parseInt(String.valueOf(s.charAt(k)))==Integer.parseInt(String.valueOf(s.charAt(k-1))))
                {
                    ans+=s.charAt(k);
                }
                else if(Integer.parseInt(String.valueOf(s.charAt(k)))<Integer.parseInt(String.valueOf(s.charAt(k-1))))
                {
                    for(int x=0;x<Integer.parseInt(String.valueOf(s.charAt(k-1)))-Integer.parseInt(String.valueOf(s.charAt(k)));x++)
                    ans+=")";
                    ans+=s.charAt(k);
                    count-=Integer.parseInt(String.valueOf(s.charAt(k-1)))-Integer.parseInt(String.valueOf(s.charAt(k)));
                }
                else if(Integer.parseInt(String.valueOf(s.charAt(k)))>Integer.parseInt(String.valueOf(s.charAt(k-1))))
                {
                    for(int x=0;x<Integer.parseInt(String.valueOf(s.charAt(k)))-Integer.parseInt(String.valueOf(s.charAt(k-1)));x++)
                    ans+="(";
                    count+=Integer.parseInt(String.valueOf(s.charAt(k)))-Integer.parseInt(String.valueOf(s.charAt(k-1)));
                    ans+=s.charAt(k);
                }
                
                
            }
            for(int h=0;h<count;h++)
            ans+=")";
            
            System.out.println("Case #"+(i+1)+": "+ans);
        }
    }
}