

import java.io.*;
import java.util.*;
import java.lang.*;
class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine().trim());
		
		for(int t=1;t<=test;t++)
		{
			String s[]=br.readLine().split(" ");
			int n=Integer.parseInt(s[0].trim());
			int k=Integer.parseInt(s[1].trim());
			if((double)k/n==k/n)
			{
				System.out.println("Case #"+t+": POSSIBLE");
				printLatin(n,k);
			}
			else
			{
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}
		}
		br.close();
	}
	private static void printLatin(int n,int k)
	{
		int trace=k/n;
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		for(int i=1;i<=n;i++)
		{
			al.add(i);
		}
		int temp;
		while(al.get(0)!=trace)
		{
			temp=al.get(0);
			al.remove(0);
			al.add(temp);
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.print(al.get(i)+" ");
		}
		System.out.println();
		
		for(int i=0;i<n-1;i++)
		{
			temp=al.get(n-1);
			al.remove(n-1);
			al.add(0,temp);
			for(int j=0;j<n;j++)
			{
				System.out.print(al.get(j)+" ");
			}
			System.out.println();
		}
	}

}
