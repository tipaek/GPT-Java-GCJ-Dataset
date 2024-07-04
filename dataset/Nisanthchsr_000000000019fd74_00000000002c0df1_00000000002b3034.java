import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        int k=1;
        while(t-->0)
        {
            
            int n=scan.nextInt();
            ArrayList<String> l=new ArrayList<String>();
            while(n-->0)
            l.add(scan.next());
            String s=getSuitableString(n,l);
            System.out.println("Case #"+k+": "+s);
            k++;
        }
    }
    static String getSuitableString(int n,ArrayList<String> l)
    {
        String s1;
        int flag=0;
        //StringBuilder s=new StringBuilder(s1); 
        for(int i=0;i<n;i++)
        {
            if(l.get(i).charAt(0)!='*')
            flag=1;
        }
        if(flag!=1)
        {
            int len=l.get(0).length();
            s1=l.get(0);
            for(int j=0;j<l.size();j++)
           {
        	   if(l.get(j).length()>len)
        	   {
        		   len=l.get(j).length();
        		   s1=l.get(j);
        	   }
           }
            for(int i=0;i<n;i++)
            {
                if(!s1.contains(l.get(i)))
                return "*";
            }
            return s1;
        }
        return "*";
    }
}