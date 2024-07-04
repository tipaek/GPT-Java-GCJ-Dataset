import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        int k=1;
        while(t-->0)
        {
            int n=in.nextInt();
            String s[]=new String[n+1];
            in.nextLine();
            for(int i=0;i<n;i++)
            {
                s[i]= in.next();
            }
            int l=s[0].length(),c=0,d=0;
            for(int i=1;i<n;i++)
            {
                if(s[i].length()>l)
                {
                    c=i;
                    l=s[i].length();
                }
            }
            l=0;
            for(int i=1;i<=s[c].length();i++)
            {
                String st= s[c].substring(0,i);
                for(int j=0;j<n;j++)
                {
                    if(st.equals(s[j]))
                    l++;
                }
            }
            for(int i=(s[c].length()-1);i>=0;i--)
            {
                String st= s[c].substring(i,s[c].length());
                st="*"+st;
                for(int j=0;j<n;j++)
                {
                    if(st.equals(s[j]))
                    l++;
                }
            }
            l=l-1;
            if(l==n)
            System.out.println("Case #"+k+": "+s[c]);
            else
            System.out.println("Case #"+k+": *");
            k++;
        }

    }
}