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
		    String a[][]=new String[n][2];
		    int p=0;
		    int m1=0,m2=0,p1=-1,p2=-1;
		    for(int i=0;i<n;i++)
		    {
		        String s=sc.next();
		        s=" "+s+" ";
		        p=0;
		        a[i][0]="";
		        a[i][1]="";
		        for(int j=0;j<s.length();j++)
		        {
		            if(s.charAt(j)!='*')
		            {
		                a[i][p]=a[i][p]+s.charAt(j);
		            }
		            else
		            {
		                //System.out.println(a[i][p]);
		            p++;
		            }
		        }
		        if(a[i][0].length()>m1)
		        {
		            m1=a[i][0].length();
		            p1=i;
		        }
		        if(a[i][1].length()>m2)
		        {
		            m2=a[i][1].length();
		            p2=i;
		        }
		    }
		    String s1=a[p1][0];
		    String s2=a[p2][1];
		   // System.out.println(s1+" "+s2);
		    int f=0,b=0;
		    int c=0;
		    for(int i=0;i<n;i++)
		    {
		        f=0;b=0;
		        for(int j=1;j<=s1.length();j++)
		        {
		            String s3=s1.substring(0,j);
		            if(s3.equals(a[i][0]))
		            {
		                f=1;
		            }
		        }
		        for(int j=0;j<s2.length();j++)
		        {
		            String s3=s2.substring(j,s2.length());
		            if(s3.equals(a[i][1]))
		            {
		                b=1;
		            }
		        }
		        
		        if(f==1 && b==1)
		        c++;
		    }
		    if(c==n)
		    System.out.println("Case #"+d+": "+s1.substring(1,s1.length())+s2.substring(0,s2.length()-1));
		    else
		    System.out.println("Case #"+d+": "+"*");
		    d++;
		    
		}
	}
}
