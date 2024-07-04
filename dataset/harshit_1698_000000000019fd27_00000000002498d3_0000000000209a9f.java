// package codejam_2020;
import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		for(int p=1;p<=t;p++)
		{
			String s=br.readLine();
			
			int[] a=new int[s.length()];
			
			for(int i=0;i<s.length();i++)
			{
				a[i]=Integer.parseInt(String.valueOf(s.charAt(i)));
			}
			
			StringBuffer sb=new StringBuffer();
			
			if(a.length>0)
			{
			
			int max=a[0];
			int open=a[0];
			int close=a[0];
			int last=a[0];
			
			for(int i=0;i<open;i++)
			{
				sb.append("(");
			}
			sb.append(a[0]);
			for(int i=1;i<a.length;i++)
			{
				if(a[i]==0)
				{
					for(int j=0;j<close;j++)
					{
						sb.append(")");
					}
					sb.append(0);
					max=0;
					open=0;
					close=0;
				}
				
				else if(a[i]==last) {
					sb.append(a[i]);
				}
				else if(a[i]<max)
				{
					sb.append(")");
					close--;
					sb.append(a[i]);
				}
				else if(a[i]>max)
				{
					int diff=a[i]-max;
					
					for(int j=0;j<diff;j++)
					{
						sb.append("(");
					}
					sb.append(a[i]);
					open=a[i];
					max=a[i];
					close=a[i];
				}
				
				last=a[i];
				
			}
			for(int i=0;i<close;i++)
			{
				sb.append(")");
			}
			
			}
			System.out.println("Case #"+p+": "+sb.toString());
			
			
			
		}

	}

}
