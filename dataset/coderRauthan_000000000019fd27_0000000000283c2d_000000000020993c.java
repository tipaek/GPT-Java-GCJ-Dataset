import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();
		
		for(int i=0; i< testCases; i++)
		{
			int n = sc.nextInt();
			
			int[][] arr = new int[n][n];
			
			int trace = 0;
			int repeatedRows = 0;
			int repeatedCol  = 0;
			
			for(int r=0; r< n; r++)
			{
				for(int c =0; c<n; c++)
				{
					arr[r][c] = sc.nextInt();
					
					if(r == c)
					{
						trace += arr[r][c];
					}
				}
			}
			
			Set<Integer> rowSet = new HashSet<>();
			Set<Integer> columnSet = new HashSet<>();
			
			
			n:for(int m=0; m< n; m++)
			{
				for(int k=0; k< n; k++)
				{
					if(rowSet.contains(arr[m][k]))
					{
						repeatedRows++;
						rowSet.clear();
						continue n;
					}
					else
					{
						rowSet.add(arr[m][k]);
					}
					
					if(k == n-1)
					 {
						 rowSet.clear();
					 }
				}
			}
			
			n:for(int m=0; m< n; m++)
			{
				for(int k=0; k< n; k++)
				{
					if(columnSet.contains(arr[k][m]))
					{
						repeatedCol++;
						columnSet.clear();
						continue n;
					}
					else
					{
						columnSet.add(arr[k][m]);
					}
					
					if(k == n-1)
					 {
						columnSet.clear();
					 }
				}
			}
			
			
			int caseNo = i+1;
			System.out.println("Case #"+caseNo+": "+trace+" "+repeatedRows+" "+repeatedCol);
			
			
		}
	}
	
	

}
