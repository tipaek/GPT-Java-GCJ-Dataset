// package codejam_2020;
import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		for(int p=1;p<=t;p++)
		{
			int n=Integer.parseInt(br.readLine());
			int[][] a=new int[n][n];
			int s1=0,r1=0,c1=0;
			for(int i=0;i<n;i++)
			{
				String s[]=br.readLine().split(" ");
				HashSet<Integer> hs=new HashSet<>();
				for(int j=0;j<n;j++)
				{
					a[i][j]=Integer.parseInt(s[j]);
					if(i==j)
					{
						s1+=a[i][j];
					}
					hs.add(a[i][j]);
				}
				
				if(hs.size()<n)
				{
					r1++;
				}
				
				
			}
			
			for(int i=0;i<n;i++)
			{
				HashSet<Integer> hs=new HashSet<>();
				for(int j=0;j<n;j++)
				{
					hs.add(a[j][i]);
					
				}
				if(hs.size()<n)
				{
					c1++;
				}
				
				
				
			}
			
			System.out.println("Case #"+p+": "+s1+" "+r1+" "+c1);
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

	
	
}
