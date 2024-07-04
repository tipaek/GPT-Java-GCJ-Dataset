import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
class Solution {
	
	static class Interval
	{
		int start;
		int end;
		
		public Interval(int start,int end)
		{
			this.start = start;
			this.end = end;
		}
	}
	
    public static void main(String args[] ) throws Exception 
	{
        
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
		int t = scan.nextInt();
		
		for(int test=1;test<=t;test++)
		{
			int n = scan.nextInt();
			
			Interval [] arr = new Interval[n];
			
			
			boolean flag = false;
			
			for(int i=0;i<n;i++)
			{
				int start = scan.nextInt();
				int end = scan.nextInt();
				
						
				arr[i] = new Interval(start,end);
			}
			
			ArrayList<Interval> cl = new ArrayList<>();
			ArrayList<Interval> jl = new ArrayList<>();
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("C");
			cl.add(arr[0]);
			
			
			
			for(int i=1;i<n;i++)
			{
				boolean flag1 = true,flag2=true;
				
				for(int j=0;j<cl.size();j++)
				{
				if((arr[i].start>=cl.get(j).start && arr[i].start<cl.get(j).end) ||
				   (arr[i].end>=cl.get(j).start && arr[i].end<cl.get(j).end))
					{
						flag1 = false;
						break;
					}
				}
				
				if(!flag1)
				{
					for(int j=0;j<jl.size();j++)
					{
						if((arr[i].start>=jl.get(j).start && arr[i].start<jl.get(j).end) ||
						(arr[i].end>=jl.get(j).start && arr[i].end<jl.get(j).end))
						{
							flag2 = false;
							break;
						}
					}
				}
				
				if(flag1)
				{
					sb.append("C");
					cl.add(arr[i]);
				}
				else if(flag2)
				{
					sb.append("J");
					jl.add(arr[i]);
				}
				else
				{
					flag = true;
				}
			}
					
			if(flag)
				System.out.println("Case #"+test+": IMPOSSIBLE");	
			else
				System.out.println("Case #"+test+": "+sb.toString());	
			
		}
		
    }
}
