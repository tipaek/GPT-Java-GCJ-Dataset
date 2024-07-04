//package com.codejam;

import java.util.Scanner;

class NestingDepth {
	
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		
		int t=sc.nextInt();
		sc.nextLine();
		String[] ans=new String[t];
		
		for(int i=0;i<t;i++)
		{
			String str=sc.nextLine();
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<str.length();j++)
			{
				int temp=Character.getNumericValue(str.charAt(j));
				if(j!=0)
				{
					if(temp==Character.getNumericValue(str.charAt(j-1)))
					{
						//sb.insert(sb.length()-1, str.charAt(j));
						sb.append(str.charAt(j));
					}
					else if(temp<Character.getNumericValue(str.charAt(j-1)))
					{
						int diff=(Character.getNumericValue(str.charAt(j-1)))-temp;
						for(int q=0;q<diff;q++)
						{
							//sb.insert(sb.length()-1, ")");
							sb.append(")");
						}
						//sb.insert(sb.length()-1, str.charAt(j));
						sb.append(str.charAt(j));
					}
					else if(temp>Character.getNumericValue(str.charAt(j-1)))
					{
						int prev=(Character.getNumericValue(str.charAt(j-1)));
						for(int k=0;k<prev;k++)
						{
							//sb.insert(sb.length()-1, ")");
							sb.append(")");
						}
						for(int k=0;k<temp;k++)
						{
							//sb.insert(0, "(");
							sb.append("(");
						}
						//sb.insert(sb.length()-1, str.charAt(j));
						sb.append(str.charAt(j));
					}
				}
				else 
				{
					for(int k=0;k<temp;k++)
					{
						sb.insert(0, "(");
					}
					//sb.insert(sb.length()-1, str.charAt(j));
					sb.append(str.charAt(j));
				}
			}
			int close=Character.getNumericValue(sb.charAt(sb.length()-1));
			for(int l=0;l<close;l++)
			{
				sb.append(")");
			}
			ans[i]=sb.toString();
		}
		for(int i=0;i<ans.length;i++)
		{
			int m=i+1;
			System.out.println("Case #"+ m +": "+ ans[i]);
		}
		sc.close();
	}
}
