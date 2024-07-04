
import java.io.*;
import java.util.*;
import java.lang.*;

class Solution 
{
public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine().trim());
		
		for(int t=1;t<=test;t++)
		{
			int n=Integer.parseInt(br.readLine().trim());
			
			ArrayList<ArrayList<Integer>> latin=new ArrayList<ArrayList<Integer>>();
			
			int trace=0,row=0,flag=0;
			
			for(int i=0;i<n;i++)
			{
				flag=0;
				
				String s[]=br.readLine().split(" ");
				
				ArrayList<Integer> al=new ArrayList<Integer>();
				
				for(int j=0;j<n;j++)
				{
					int y=Integer.parseInt(s[j]);
					if(al.contains(y))
					{
						flag=1;
						al.add(y);
					}
					else
					{
						al.add(y);
					}
					
					if(i==j)
					{
						trace+=y;
					}
				}
				latin.add(al);
				row=(flag==1)?row+1:row;
				al=null;
				s=null;
			}
			int col=0;
			
			for(int i=0;i<n;i++)
			{
				flag=0;
				ArrayList<Integer> al=new ArrayList<Integer>();
				for(int j=0;j<n;j++)
				{
					if(al.contains(latin.get(j).get(i)))
					{
						flag=1;
					}
					else
					{
						al.add(latin.get(j).get(i));
					}
				}
				col=(flag==1)?col+1:col;
				al=null;
			}
			if(t==1)
			{
				System.out.println("Case #"+t+": "+trace+" "+row+" "+col);
			}
			else
			{
				System.out.println("Case #"+t+": "+trace+" "+row+" "+col);
			}
				
			
		}
		
		br.close();
	}

}
