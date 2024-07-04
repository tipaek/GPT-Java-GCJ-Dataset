import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


public class Solution
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for(int j =0; j<N; j++)
		{
			int x = in.nextInt();
			int[][] sch = new int[x][2];
			for(int i =0; i<x; i++)
			{
				sch[i][0] = in.nextInt();
				sch[i][1] = in.nextInt();
			}
			System.out.print("Case #"+(j+1)+": ");
			int i = 0;
			boolean go = true;
			for(i =0; i<(Math.pow(2, x)); i++)
			{
				if (works(i,sch,x))
				{
					go=false;
					break;
				}
					
			}
			if(go)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println();
			
			
		}
	}
	
	
	public static boolean works(int a, int[][] sch, int x)
	{
		String s = Integer.toBinaryString(a);
		Map<Integer,Integer>  c = new HashMap<>();
		Map<Integer,Integer>  j = new HashMap<>();
		
		for(int i = s.length(); i<x; i++)
			s = "0"+s;
	
		
		for(int i =0; i<x; i++)
		{
			if(s.substring(i,i+1).equals("1"))
			{
				int b = sch[i][0];
				int q = sch[i][1];
				for(int r = b; r<q; r++)
				{
					if(j.containsKey(r))
						return false;
					else
						j.put(r,0);
				}
			}
			if(s.substring(i,i+1).equals("0"))
			{
				int b = sch[i][0];
				int q = sch[i][1];
				for(int r = b; r<q; r++)
				{
					if(c.containsKey(r))
						return false;
					else
						c.put(r,0);
				}
			}
			
		}
	
		
		for(int m = 0; m<x; m++)
		{
			if(s.substring(m,m+1).equals("1"))
				System.out.print("J");
			if(s.substring(m,m+1).equals("0"))
				System.out.print("C");
		}
		return true;
	}
}