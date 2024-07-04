import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
	for(int k=1;k<=t;k++)
		{
			int n=scan.nextInt();
			int[][]matrix=new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					matrix[i][j]=scan.nextInt();
				}
			}
			find(n,k,matrix);
		
		}
	}

	private static void find(int n,int t, int[][] matrix) {
		// TODO Auto-generated method stub
		int rowcount=0;
		int colcount=0;
		int sum=0;
		  
		for(int i=0;i<n;i++)
		{
			boolean row=false;
			boolean col=false;
			HashSet<Integer> rowset = new HashSet<>(); 
			  HashSet<Integer> colset = new HashSet<>(); 
			for(int j=0;j<n;j++)
			{
				if(i==j)
				{
					sum+=matrix[i][j];
				}
				if(row==false && rowset.contains(matrix[i][j]))
				{
					rowcount++;
					row=true;
				}
				if(col==false && colset.contains(matrix[j][i]))
				{
					colcount++;
					col=true;
				}
				rowset.add(matrix[i][j]);
				colset.add(matrix[j][i]);
			}
		}
		System.out.println("Case #"+t+": " +sum+" "+rowcount+" "+colcount);
	}

}
