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
		int b1=sc.nextInt();
	while(t1-->0)
	{
	    
	   
	    int q=1;
	    int arr[]=new int[10];
	    int  p=1;
	    while(q<=150)
	    {
	       System.out.println(pos);
	       int n=sc.nextInt();
	       arr[pos-1]=n;
	       p++;
	       if(p>10)
	       p=1;
	       q++;
	    }
	    for(int i=0;i<10;i++)
	    System.out.print(arr[i]);
	    System.out.println();
	    String str=sc.next();
	    if(str=="Y")
	    continue;
	    else
	    break;
	    
	}
	}
}