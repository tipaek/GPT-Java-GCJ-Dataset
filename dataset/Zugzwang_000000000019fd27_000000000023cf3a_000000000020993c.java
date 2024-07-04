/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();int c=1;
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int mat[][]=new int[n][n];int trace=0;
		    for(int i=0;i<n;i++)
		    for(int j=0;j<n;j++)
		    {
		    mat[i][j]=sc.nextInt();
		    if(i==j)trace+=mat[i][j];
		    }
		    int rows=0;int columns=0;
		    for(int i=0;i<n;i++)
		    {
		        int an[]=find(mat,i,i);
		        rows+=an[0];columns+=an[1];
		    }
		    System.out.println("Case #"+c+":"+" "+trace+" "+rows+' '+columns);c++;
		}
	}
	public static int[] find(int[][]mat,int row,int column)
	{
	    int ans[]=new int[2];
	    Set<Integer>set=new HashSet<>();
	    for(int i=0;i<mat.length;i++)
	    {
	        set.add(mat[row][i]);
	    }
	    if(set.size()!=mat.length)ans[0]=1;
	    set=new HashSet<>();
	    for(int i=0;i<mat.length;i++)
	    {
	        set.add(mat[i][column]);
	    }
	    if(set.size()!=mat.length)ans[1]=1;
	    return ans;
	}
}