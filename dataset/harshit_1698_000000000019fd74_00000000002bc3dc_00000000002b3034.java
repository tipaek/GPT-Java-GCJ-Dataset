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
				String s=br.readLine();
//				int y=s.indexOf('*');
//				s=s.substring(0,y)+s.substring(y+1);
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
			
//			System.out.println(al);
			
			boolean flag=true;
			for(String x:al)
			{				
				int in=x.indexOf('*');
				
				int in2=res.indexOf('*');
				
				if(in==0&&in2==(res.length()-1))
				{
					res=res.substring(0,in2)+'*'+x.substring(1);
				}
				else if(in==(x.length()-1)&&in2==0)
				{
					res=x.substring(0,in+1)+'*'+res.substring(1);
					
				}
				
				else {
				String t1=x.substring(0,in);
				String p1=res.substring(0,in);
				String t2=x.substring(in+1);
				String p2=res.substring(in+1);
				
				if(!(p1.contains(t1)&&p2.contains(t2)))
				{
					flag=false;
					break;
				}
				}
//				
			}
			
			
			
			if(!flag)
			{
				System.out.println("Case #"+p+": *");
			}
			else {
				
//				System.out.println(res);
				
				int in=res.indexOf('*');
				res=res.substring(0,in)+res.substring(in+1);
				
				System.out.println("Case #"+p+": "+res);
			}
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
	}

}
