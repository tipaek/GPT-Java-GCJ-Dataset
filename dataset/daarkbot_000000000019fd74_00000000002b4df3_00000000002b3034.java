package pattern;

import java.util.*;
import java.io.*;
public class Solution {
	
	public static void main(String [] args)
	{
		int T;
		Scanner sc=new Scanner(System.in);
		T = Integer.parseInt(sc.nextLine());
		
		int K=T;
		
		while(T-- >0)
		{
			 
			int N = Integer.parseInt(sc.nextLine());
			 
			String[] s = new String[N];
			
			int count=0;
			int index =0;
			for(int i=0;i<N;i++) {
				s[i]= sc.nextLine();
				if(count<s[i].length())
				{
					count=s[i].length();
					index=i;
				}
			}
			int flag=0;
			for(int i=0;i<N;i++)
			{
				if(s[index].contains(s[i].replace("*", ""))) {
					//System.out.println(s[index]+":"+count+":"+index+":"+N);
					continue;
				}
				else
				{
					//System.out.println(s[index]);
					flag=1;
					break;
				}
			}
			int res=K-T;
			
			if(flag==0)
			{
				System.out.println("Case #"+res+": "+s[index].replace("*", ""));
			}
			else
			{
				System.out.println("Case #"+res+": "+"*");
			}
			
			
		}
		
	}

}
