/*package whatever //do not write package name here */

import java.util.HashSet;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		int t=obj.nextInt();
		int num=0;
		while(t-->0)
		{
			num++;
			int n=obj.nextInt();
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j]=obj.nextInt();
				}
			}
			int r=0,c=0;
			for(int i=0;i<n;i++)	
			{
				HashSet<Integer> set=new HashSet<>();
				for(int j=0;j<n;j++)
				{
					if(set.contains(arr[i][j]))
					{
						r++;
						break;
					}
					set.add(arr[i][j]);
				}
			}
			for(int i=0;i<n;i++)	
			{
				HashSet<Integer> set2=new HashSet<>();
				for(int j=0;j<n;j++)
				{
					if(set2.contains(arr[j][i]))
					{
						c++;
						break;
					}
				set2.add(arr[j][i]);
				}
			}
			int sum=0;
			for(int i=0;i<n;i++)
			{
				sum+=arr[i][i];
			}
			System.out.println("Case #"+num+":"+" "+sum+" "+r+" "+c);
		}
	}
}

