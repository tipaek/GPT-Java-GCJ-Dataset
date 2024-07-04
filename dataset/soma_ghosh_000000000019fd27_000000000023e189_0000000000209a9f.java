import java.lang.*;
import java.util.*;
import java.io.*;

class Solution 
{
public static void main(String[] args) throws IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine().trim());
		
		for(int t=1;t<=test;t++)
		{
			String s=br.readLine().trim();
			String res="";
			
			if(s.length()>1)
			{
				int x=Integer.parseInt(s.charAt(0)+"");
				for(int j=0;j<x;j++)
				{
					res+="(";
				}
				res+=x;
				
				int y=Integer.parseInt(s.charAt(1)+"");
				for(int j=0;j<x-y;j++)
				{
					res+=")";
				}
				
				for(int i=1;i<s.length()-1;i++)
				{
					int w=Integer.parseInt(s.charAt(i-1)+"");
					x=Integer.parseInt(s.charAt(i)+"");
					y=Integer.parseInt(s.charAt(i+1)+"");
				
					for(int j=0;j<x-w;j++)
					{
						res+="(";
					}
					res+=x;
					for(int j=0;j<x-y;j++)
					{
						res+=")";
					}
				}
				
				x=Integer.parseInt(s.charAt(s.length()-1)+"");
				int w=Integer.parseInt(s.charAt(s.length()-2)+"");
				
				for(int j=0;j<x-w;j++)
				{
					res+="(";
				}
				
				
				res+=x;
				for(int j=0;j<x;j++)
				{
					res+=")";
				}
			}
			
			else
			{
				int x=Integer.parseInt(s.charAt(0)+"");
				for(int j=0;j<x;j++)
				{
					res+="(";
				}
				res+=x;
				for(int j=0;j<x;j++)
				{
					res+=")";
				}
			}
			
			
			
			
			
			
			
			System.out.println("Case #"+t+": "+res);
		}
		br.close();
	}

}
