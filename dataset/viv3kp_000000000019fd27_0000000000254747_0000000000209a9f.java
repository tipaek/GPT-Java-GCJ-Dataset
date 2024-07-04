
import java.io.*;
import java.util.*;
class Solution {
	
	static StringBuilder res;
	static int open;
	static int close;
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		
		
		int test=sc.nextInt();
		sc.nextLine();
		int caseNo=1;
		StringBuilder str=new StringBuilder("");
		
		while(test-->0)
		{
			
			
			res=new StringBuilder("");
			open =0;
			close=0;
			
			String s=sc.nextLine();
			
			
			
			for(int i=0;i<s.length();i++)
			{
				int a=Integer.parseInt(s.charAt(i)+"");
				
				add(a);
			}
			close();
			
			
			
			str.append("Case #"+caseNo+": "+res.toString()+"\n");
			
			
			
			caseNo++;
			
			
			
		}
		
		System.out.println(str.toString());
		
	}
	
	static void add(int a)
	{
		int k=a-open;
		if(k>=0)
		for(int i=0;i<k;i++)
		{
				res.append('(');
				open++;
		}
		else
		{
			k=k*-1;
			
			for(int i=0;i<k;i++)
			{
				res.append(')');
				open--;
			}
		}
		
		res.append(a);
		
		
	}
	
	static void close()
	{
		for(int i=0;i<open;i++)
			res.append(')');
	}

}
