


import java.io.*;





import java.util.*;



import java.lang.*;
import java.io.*;


public class Solution
{
	
	
	static Scanner s;
	static StringBuilder ans;
	public static void main (String[] args) throws java.lang.Exception
	{
		
		s=new Scanner(System.in);
		int t=s.nextInt();
		int Case=1;
		while(t-->0)
		{
			
			
			String[] arr=s.next().split("");
			ans=new StringBuilder();
			int first=Integer.parseInt(arr[0]);
			while(first-->0)
			{
				ans.append('(');
			}
			ans.append(arr[0]);
			int prev=Integer.parseInt(arr[0]);
			for(int i=1;i<arr.length;i++)
			{
				int curr=Integer.parseInt(arr[i]);
				if(curr==prev)
					ans.append(curr);
				else if(curr>prev)
				{
					int x=curr-prev;
					while(x-->0)
						ans.append('(');
					ans.append(curr);
					prev=curr;
				}
				else
				{
					int x=prev-curr;
					while(x-->0)
						ans.append(')');
					ans.append(curr);
					prev=curr;
				}
				
			}
			while(prev-->0)
			{
				ans.append(')');
			}
			
			System.out.println("Case #"+Case+": "+ans);
			Case++;
			}
			
		}
		    
		}

	
	


      
        	
        
        


	

	
	

