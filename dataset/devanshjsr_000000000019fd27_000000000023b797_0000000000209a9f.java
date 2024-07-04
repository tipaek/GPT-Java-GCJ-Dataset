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
		    String s=sc.next();
		    
		    ArrayList<String> a1=new ArrayList<String>();
		    ArrayList<Integer> a2=new ArrayList<Integer>();
		    
		    String ch=s.substring(0,1);
		    
		    a1.add("");
		    a2.add(Integer.parseInt(ch));
		    
		    int index=0,sum=0;
		    
		    sum+=a2.get(index);
		    
		    
		    for(int i=0;i<s.length();i++)
		    {
		        if(s.substring(i,i+1).equals(ch)==false)
		        {
		            ch=s.substring(i,i+1);
		            a1.add(ch);
		            
		            String temp=a1.get(index).substring(0,1);
		            a2.add(Integer.parseInt(ch)-Integer.parseInt(temp));
		            index++;
		            sum+=a2.get(index);

		        }
		        else
		        {
		            
		            a1.set(index,a1.get(index)+s.substring(i,i+1));
		        }
		    }
		    
		    System.out.print("Case #"+st+": ");
		    
		    for(int i=0;i<a2.size();i++)
		    {
		        int x=a2.get(i);
		        
		        if(x>0)
		        {
		            for(int j=0;j<x;j++)
		            {
		                System.out.print("(");
		            }
		        }
		        else
		        {
		            x=-x;
		            
		            for(int j=0;j<x;j++)
		            {
		                System.out.print(")");
		            }
		            
		        }
		        
		        System.out.print(a1.get(i));
		        
		    }
		    
		    for(int i=0;i<sum;i++)
		    {
		        System.out.print(")");
		    }
		    
		    System.out.println();
		    
		   
		   
		   st++;
		   t--;
		    
		}
	}
}
