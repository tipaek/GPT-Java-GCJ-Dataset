import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        while(t-->0)
        {
            int n=scan.nextInt();
            ArrayList<String> l=new ArrayList<String>();
            while(n-->0)
            l.add(scan.next());
            String s=getSuitableString(n,l);
            System.out.println(s);
        }
    }
    static String getSuitableString(int n,ArrayList<String> l)
    {
        String s1;
        int flag=0;
        StringBuilder s=new StringBuilder(s1); 
        for(int i=0;i<n;i++)
        {
            if(l.get(i).charAt(0)!='*')
            flag=1;
        }
        if(flag!=1)
        {
            int len=l.get(0).length();
            s=l.get(0);
            for(int i=1;i<n;i++)
            {
                if(len<l.get(i).length())
                {
                    len=l.get(i).length();
                    s=l.get(i);
                }
            }
            for(int i=0;i<n;i++)
            {
                if(s.indexof(l.get(i)==-1))
                return '*';
            }
            return s.toString();
        }
    }
}