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
			boolean [] cam = new boolean[1441];
			boolean [] jack = new boolean[1441];
			StringBuilder sb = new StringBuilder();
			
			boolean flag = false;
			
			for(int i=0;i<n;i++)
			{
				int start = scan.nextInt();
				int end = scan.nextInt();
				
				if(start<0 || end<0 || start>1440 || end>1440 || end<start)
				{
					//sb = new StringBuilder("IMPOSSIBLE");
				}
				
				boolean flag1=true,flag2=true;
				
				for(int j=start;j<end;j++)
				{
					if(cam[j])
					{
						flag1 =false;
						break;
					}
				}
				
				if(flag1)
				{
					for(int j=start;j<end;j++)
						cam[j] = true;
					
					sb.append("C");
				}
				else
				{
					for(int j=start;j<end;j++)
					{
						if(jack[j])
						{
							flag2 =false;
							break;
						}
					}
					
					if(flag2)
					{
						for(int j=start;j<end;j++)
							jack[j] = true;
						
						sb.append("J");
					}
					else
					{
						flag = true;
					}
					
					
				}
				
			}
			
			if(flag)
				System.out.println("Case #"+test+": IMPOSSIBLE");	
			else
				System.out.println("Case #"+test+": "+sb.toString());	
			
		}
		
    }
}
