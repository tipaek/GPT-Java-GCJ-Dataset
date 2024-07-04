/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int x = sc.nextInt();
		for(int v=1;v<=x;v++){
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			int t=0;
			HashMap<Integer,Integer> row = new HashMap<>(), col =new HashMap<>();
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					{
						a[i][j]=sc.nextInt();
						if(i==j)t+=a[i][j];
					}
			int r=0,c=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					for(int k=0;k<n;k++){
						if(j!=k && a[i][j]==a[i][k]){
							if(row.get(i)==null){
								row.put(i,1);
								r++;
							}
						}
						if(k!=i && a[i][j]==a[k][j]){
							if(col.get(j) == null){
								col.put(j,1);
								c++;
							}
						}
					}
				}
			}
			sb.append("Case #"+v+": "+t+" "+r+" "+c+"\n");
		}
		System.out.println(sb);
	}
}