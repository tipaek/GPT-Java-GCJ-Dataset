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
		int test=sc.nextInt();
		int temp=1;
		while(temp<=test)
		{
		  //  int n=sc.nextInt();
		  //  int []arr = new int[n];
		  //  for(int i=0;i<n;i++)
		  //     arr[i]=sc.nextInt();
		    int x=sc.nextInt();
		    int y=sc.nextInt();
		    String str = sc.next();
		    
		    int count=0;
		    boolean isTrue=false;
		    for(int i=0;i<=str.length();i++)    
		    {
		        count++;
		        if((Math.abs(x)+Math.abs(y)) < count) {
		           isTrue=true; 
		           break; 
		        }
		        if(i==str.length())
		           break;
		        char ch=str.charAt(i);
		        if(ch=='N')  y++;
		        else if(ch=='S') y--;
		        else if(ch=='E') x++;
		        else x--;
		    }
		    count--;
		    String ans="";
		    if(isTrue)
		       ans+=count;
		    else
		       ans="IMPOSSIBLE";
		       
		    System.out.println("Case #"+temp+": "+ans);
		    temp++;
		}
	}
}












