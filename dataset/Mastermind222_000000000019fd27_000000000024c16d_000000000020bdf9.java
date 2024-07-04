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
		int t1=sc.nextInt();
		int d=1;
		while(t1-->0)
		{
		    int n=sc.nextInt();
		    int s[]=new int[n];
		    int e[]=new int[n];
		    int j[]=new int[n];
		    int c[]=new int[n];
		    int jc=0,cc=0;
		  String ans="";
		    int f=1;
		    s[0]=sc.nextInt();
		    e[0]=sc.nextInt();
		    int max=s[0];
		    for(int i=1;i<n;i++)
		    {
		        s[i]=sc.nextInt();
		        e[i]=sc.nextInt();
		    }
		    int s1[]=s.clone();
		    int e1[]=e.clone();
		    Arrays.sort(s);
		    for(int i=0;i<n;i++)
		    {
		        for(int k=i;k<n;k++)
		        {
		            if(s[i]==s1[k])
		            {
		                int temp;
		                temp=e[i];
		                e[i]=e[k];
		                e[k]=temp;
		                temp=s1[i];
		                s1[i]=s1[k];
		                s1[k]=temp;
		            }
		        }
		    }
		    for(int i=0;i<n;i++)
		    {
		        //System.out.println(s[i]+" "+e[i]);
		        if(f==1)
		        {
		            if(jc==0 || s[i]>=j[jc-1])
		            {
		            j[jc]=e[i];
		            jc++;
		            //ans=ans+"J";
		            }
		            else if(cc==0 || s[i]>=c[cc-1])
		            {
		            c[cc]=e[i];
		            cc++;
		            //ans=ans+"C";
		            }
		            else
		            {
		            ans="IMPOSSIBLE";
		            f=0;
		            }
		        }
		    }
		   // for(int i=0;i<n;i++)
		   // System.out.println(j[i]+" "+c[i]);
		    if(f==1)
		    {
		        int f1=0;
		        for(int i=0;i<n;i++)
		        {
		            f1=0;
		            for(int k=0;k<jc;k++)
		            {
		                if(e1[i]==j[k])
		                {
		                    ans=ans+"J";
		                    f1=1;
		                    break;
		                }
		            }
		            if(f1==0)
		            {
		                for(int k=0;k<cc;k++)
		            {
		                if(e1[i]==c[k])
		                {
		                    ans=ans+"C";
		                    f1=0;
		                    break;
		                }
		            }
		            }
		                
		            }
		    }
		    
		    
		    System.out.println("Case #"+d+": "+ans);
		    d++;
		}
	}
}
