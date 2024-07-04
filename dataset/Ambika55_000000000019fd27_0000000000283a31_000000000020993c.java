import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		for (int i = 1; i <= t; i++) {
			int n = scn.nextInt();

		int tr=0;
			int[][] matrix = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					matrix[j][k] = scn.nextInt();
					if(j==k)
						tr+=matrix[j][k];
				}
			}
			
			
			int[] row=new int[n+1];
			int[] col=new int[n+1];
			int r=0,c=0;
			for(int j=0;j<n;j++)
			{
				Arrays.fill(row,0);
				for(int k=0;k<n;k++)
				{
					if(row[matrix[j][k]]==0)
						row[matrix[j][k]]=1;
					else
					{
						r++;
						break;
					}
				}
			}
			
			for(int j=0;j<n;j++)
			{
				Arrays.fill(col,0);
				for(int k=0;k<n;k++)
				{
					if(row[matrix[k][j]]==0)
						row[matrix[k][j]]=1;
					else
					{
						c++;
						break;
					}
				}
			}
			
			
			System.out.println("Case #" + i + ": " + tr + " " + r + " " + c);

		}
	}

}
