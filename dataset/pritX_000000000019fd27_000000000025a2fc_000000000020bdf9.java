//package com.codejam;

import java.util.Scanner;

class Solution {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		String[] ans = new String[t];
		
		for(int i=0;i<t;i++)
		{
			StringBuilder sb=new StringBuilder();
			int C_finish=0;
			int J_finish=0;
			int m=sc.nextInt();
			sc.nextLine();
			int[][] matrix=new int[m][2];
			for(int k=0;k<m;k++)
			{
				String str=sc.nextLine();
				String[] st=str.split(" ");
				matrix[k][0]=Integer.parseInt(st[0]);
				matrix[k][1]=Integer.parseInt(st[1]);
				if(k!=0)
				{
					if(matrix[k][1] > matrix[k-1][0] && matrix[k][0] < matrix[k-1][0])
					{
						if(sb.charAt(sb.length()-1) == 'C')
						{
							if(J_finish > matrix[k][0])
							{
								sb=sb.delete(0, sb.length());
								sb=sb.append("IMPOSSIBLE");
								break;
							}
							sb.append("J");
							J_finish=matrix[k][1];
						}
						else
						{
							if(C_finish > matrix[k][0])
							{
								sb=sb.delete(0, sb.length());
								sb=sb.append("IMPOSSIBLE");
								break;
							}
							//System.out.println("1");
							sb.append("C");
							C_finish=matrix[k][1];
						}
						
					}
					else if(matrix[k][1] > matrix[k-1][1] && matrix[k][0] < matrix[k-1][1])
					{
						if(sb.charAt(sb.length()-1) == 'C')
						{
							if(J_finish > matrix[k][0])
							{
								sb=sb.delete(0, sb.length());
								sb=sb.append("IMPOSSIBLE");
								break;
							}
							sb.append("J");
							J_finish=matrix[k][1];
						}
						else
						{
							if(C_finish > matrix[k][0])
							{
								sb=sb.delete(0, sb.length());
								sb=sb.append("IMPOSSIBLE");
								break;
							}
							//System.out.println("2");
							sb.append("C");
							C_finish=matrix[k][1];
						}
					}
					else if(matrix[k][0] < matrix[k-1][0] && matrix[k][1] > matrix[k-1][1])
					{
						if(sb.charAt(sb.length()-1) == 'C')
						{
							if(J_finish > matrix[k][0])
							{
								sb=sb.delete(0, sb.length());
								sb=sb.append("IMPOSSIBLE");
								break;
							}
							sb.append("J");
							J_finish=matrix[k][1];
						}
						else
						{
							if(C_finish > matrix[k][0])
							{
								sb=sb.delete(0, sb.length());
								sb=sb.append("IMPOSSIBLE");
								break;
							}
							//System.out.println("3");
							sb.append("C");
							C_finish=matrix[k][1];
						}
					}
					else if(matrix[k][0] >= matrix[k-1][0] && matrix[k][1] <= matrix[k-1][1])
					{
						if(sb.charAt(sb.length()-1) == 'C')
						{
							if(J_finish > matrix[k][0])
							{
								sb=sb.delete(0, sb.length());
								sb=sb.append("IMPOSSIBLE");
								break;
							}
							sb.append("J");
							J_finish=matrix[k][1];
						}
						else
						{
							if(C_finish > matrix[k][0])
							{
								sb=sb.delete(0, sb.length());
								sb=sb.append("IMPOSSIBLE");
								break;
							}
							//System.out.println("4");
							sb.append("C");
							C_finish=matrix[k][1];
						}
					}
					else
					{
						if(sb.charAt(sb.length()-1) == 'C')
						{
							sb.append("C");
							C_finish=matrix[k][1];
						}
						else
						{
							sb.append("J");
							J_finish=matrix[k][1];
						}
					}
				}
				else
				{
					sb.append("C");
					C_finish=matrix[k][1];
				}
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
