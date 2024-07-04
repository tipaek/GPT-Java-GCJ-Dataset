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
		int st=1;
		
		while(t>0)
		{
		    int n=sc.nextInt();
		    int[] s=new int[n];
		    int[] e=new int[n];
		    int[] s1=new int[n];
		    int[] e1=new int[n];

		    
		    for(int i=0;i<n;i++)
		    {
		        s[i]=sc.nextInt();
		        s1[i]=s[i];
		        e[i]=sc.nextInt();
		        e1[i]=e[i];
		    }
		    
		    Arrays.sort(s1);
		    
		    char[] arr=new char[n];
		    
		    int c=0,ja=0;
		    
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            if(s[j]==s1[i])
		            {
		                e1[i]=e[j];
		            }
		        }
		    }
		    
		    arr[0]='C';
		    c=e1[0];
		    
		    int f=1;
		    for(int i=1;i<n;i++)
		    {
		        if(s1[i]>=c)
		        {
		            arr[i]='C';
		            c=e1[i];
		        }
		        else
		        {
		            if(s1[i]>=ja)
		            {
		                arr[i]='J';
		                ja=e1[i];
		            }
		            else
		            {
		                f=0;
		                break;
		            }
		        }
		    }
		    
		    if(f==0)
		    {
		        System.out.print("Case #"+st+": IMPOSSIBLE");
		    }
		    else
		    {
		        System.out.print("Case #"+st+": ");
		        
		        for(int i=0;i<n;i++)
		        {
		            for(int j=0;j<n;j++)
		            {
		                if(s1[j]==s[i] && e1[j]==e[i])
		                {
		                    System.out.print(arr[j]);
		                }
		            }
		        }
		    }
		    
		   System.out.println();
		   
		   st++;
		   t--;
		    
		}
	}
}
