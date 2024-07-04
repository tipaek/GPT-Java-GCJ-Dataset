// package codejam_2020;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		for(int p=1;p<=t;p++)
		{
			String s=br.readLine();
			
			ArrayList<Integer> al=new ArrayList<>();
//			int last=-1;
			
			for(int i=0;i<s.length();i++)
			{
				int x=Integer.parseInt(String.valueOf(s.charAt(i)));
				al.add(x);
			}
			int remain=0;
			int last=0;
			StringBuffer sb=new StringBuffer();
			
			
			for(int i=0;i<al.size();i++)
			{
				int x=al.get(i);
				if(x==last)
				{
					sb.append(x);
				}
				else {
					
					for(int j=1;j<=remain;j++)
					{
						sb.append(")");
					}
					
					remain=x;
					for(int j=1;j<=x;j++)
					{
						sb.append("(");
					}
					sb.append(x);
					last=x;
				}
				
				
			}
			
			for(int i=1;i<=remain;i++)
			{
				sb.append(")");
			}
			
			
			
			
			
			System.out.println("Case #"+p+": "+sb.toString());
			
			
			
		}
		
		

	}

}
