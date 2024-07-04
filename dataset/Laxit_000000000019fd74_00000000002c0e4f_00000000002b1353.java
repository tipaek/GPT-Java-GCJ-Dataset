/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		int temp=1;
		while(temp<=test)
		{
		    int n = sc.nextInt();
		    int count=1;
		    
		    int i=1,j=1;
		    System.out.println("Case #"+temp+":");
		    System.out.println(i+" "+j);
		    i++;
		    n-=1;
		    while(n>0)
		    {
		        System.out.println(i+" "+j);
		        n=n-count;
		        count++;
		        if(n-count<0)
		           break;
		        i++;
		        j++;
		    }
		    j++;
		    while(n>0)
		    {
		        System.out.println(i+" "+j);
		        i++;
		        j++;
		        n--;
		    }
		    
		    temp++;
		}
	}
}
















