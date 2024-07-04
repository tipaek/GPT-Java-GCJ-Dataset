

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		sc.nextLine();
		for(int t=1;t<=T;t++)
		{
		    String s=sc.nextLine();
		    int n=s.length();
		    String result="";
		    Stack<String>stack=new Stack<>();
		    int diff=0;
		    for(int i=0;i<s.charAt(0)-'0';i++)
		    {
		        result+="(";
		        stack.push(")");
		    }		 
		    result+=Character.toString(s.charAt(0));
		    for(int i=1;i<n;i++)
		    {
		        if(s.charAt(i)-'0'>s.charAt(i-1)-'0')
		        {
		            diff=(s.charAt(i)-'0')-(s.charAt(i-1)-'0');
		            for(int j=1;j<=diff;j++)
		            {
		                stack.push(")");
		                result+="(";
		                
		            }
		            result+=Character.toString(s.charAt(i));
		        }
		        else
		        {
		            diff=(s.charAt(i-1)-'0')-(s.charAt(i)-'0');
		            for(int j=1;j<=diff;j++)
		            {
		                result+=stack.pop();
		            }
		            result+=Character.toString(s.charAt(i));
		        }
		    }
		    
		    while(!stack.isEmpty())
		    {
		        result+=stack.pop();
		    }
		    System.out.println("Case #"+t+": "+result);
		    
		}
	}
}
