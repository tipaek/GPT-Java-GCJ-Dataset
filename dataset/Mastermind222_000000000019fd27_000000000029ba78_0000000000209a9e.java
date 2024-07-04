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
		int b=sc.nextInt();
	while(t-->0)
	{
	    
	   if(b==10)
	   {
	    int q=1;
	    int a[]=new int[10];
	    int  pos=1;
	    while(q<=150)
	    {
	       System.out.println(pos);
	       int n=sc.nextInt();
	       a[pos-1]=n;
	       pos++;
	       if(pos>10)
	       pos=1;
	       q++;
	    }
	    for(int i=0;i<10;i++)
	    System.out.print(a[i]);
	    System.out.println();
	    String s=sc.next();
	    String s1="Y";
	    if(s.equals(s1))
	    continue;
	    else
	    break;
	    
	}
	else if(b==20)
	{
	    int q=1;
	    int c[]=new int[10];
	    int a[]=new int[20];
	    int fp=1;
	    int bp=20;
	    while(q<=20)
	    {
	        
	        if(q%2!=0)
	        {
	        System.out.println(fp);
	        int n=sc.nextInt();
	        a[fp-1]=n;
	        fp++;
	        }
	        else
	        {
	        System.out.println(bp);
	        int n=sc.nextInt();
	        a[bp-1]=n;
	        bp--;
	        c[fp-2]=(int)Math.abs(a[fp-2]-a[bp]);
	        }
	        q++;
	      }
	     while(q<=140)
	    {
	        System.out.println("1");
	         int n=sc.nextInt();
	         q++;
	    }
	    q=141;
	    while(q<=150)
	     {
	        System.out.println(q-140);
	        a[q-141]=sc.nextInt();
	        a[160-q]=a[q-141]+c[q-141];
	        if(a[160-q]>1)
	        a[160-q]=0;
	        q++;
	       }
	    for(int i=0;i<20;i++)
	    System.out.print(a[i]);
	    System.out.println();
	     String s=sc.next();
	    String s1="Y";
	    if(s.equals(s1))
	    continue;
	    else
	    break;   
	   }
	}
	}
	}

