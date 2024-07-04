/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
 public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int d=1;
		while(t-->0)
		{
		    int n=sc.nextInt();
		    String a[]=new String[n];
		    int max=0,pos=-1;
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.next();
		        if(a[i].length()>max)
		        {
		            max=a[i].length();
		            pos=i;
		        }
		    }
		    String s=a[pos];
		    //System.out.println(s);
		    int f=0,c=0;
		    for(int i=0;i<n;i++)
		    {
		        f=0;
		        for(int j=1;j<s.length();j++)
		        {
		               String s1=s.substring(j,s.length());
		              // System.out.println(s1);
		              // System.out.println(a[i].substring(1,a[i].length()));
		                if(s1.equals(a[i].substring(1,a[i].length())))
		                {
		                    f++;
		                    break;
		                }
		            
		        }
		        if(f==1)
		        c++;
		    }
		    if(c==n)
		    System.out.println("Case #"+d+": "+s.substring(1,s.length()));
		    else
		    System.out.println("Case #"+d+": "+"*");
		    d++;
		}
	}
}
