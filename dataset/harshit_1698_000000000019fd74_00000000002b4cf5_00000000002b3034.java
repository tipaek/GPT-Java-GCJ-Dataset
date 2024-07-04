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
			
			ArrayList<String> al=new ArrayList<>();
			
			String res="a";
			
			
			
			for(int i=0;i<n;i++)
			{
				String s=br.readLine().substring(1);
				al.add(s);
				if(i==0)
				{
					res=s;
				}
				else {
					if(s.length()>res.length())
					{
					res=s;	
					}
					
				}
				
				
			}
			
			boolean flag=true;
			for(String x:al)
			{
				if(!res.contains(x))
				{
					flag=false;
					break;
				}
				
			}
			
			if(!flag)
			{
				System.out.println("Case #"+p+": *");
			}
			else {
				System.out.println("Case #"+p+": "+res);
			}
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
	}

}
