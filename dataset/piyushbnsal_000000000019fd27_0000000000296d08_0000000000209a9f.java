package codeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<t;i++)
		{
			StringBuilder ans=new StringBuilder();
			String str=br.readLine();
			
			if(str.length()==1)
			{
				int n=str.charAt(0)-48;
				for(int k=0;k<n;k++)
					ans.append("(");
				ans.append(str.charAt(0));
				for(int k=0;k<n;k++)
					ans.append(")");
			}
			else
			{
				int n=str.charAt(0)-48;
				for(int k=0;k<n;k++)
				{
					ans.append("(");
				}
				
				for(int j=0;j<str.length()-1;j++)
				{
				
					ans.append(str.charAt(j));
				
					if(str.charAt(j)>str.charAt(j+1))
					{
						int diff=str.charAt(j)-str.charAt(j+1);
					
						for(int a=0;a<diff;a++)
						{
							ans.append(")");
						}
					}
				
					else if(str.charAt(j)<str.charAt(j+1))
					{
						int diff=str.charAt(j+1)-str.charAt(j);
					
						for(int a=0;a<diff;a++)
						{
							ans.append("(");
						}	
					}
					else if(str.charAt(j)==str.charAt(j+1))
					{
						ans.append(str.charAt(j));
						j++;
					}
				}
				
				ans.append(str.charAt(str.length()-1));
				 n=str.charAt(str.length()-1)-48;
				 for(int k=0;k<n;k++)
				 {
					ans.append(")");
				 }
				
			}
			
			System.out.println("Case #"+(int)(i+1)+": "+ans);
		}

	}

}
