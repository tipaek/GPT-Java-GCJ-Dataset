import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int test=in.nextInt();
		
		for(int t=0;t<test;t++)
		{
			int n=in.nextInt();
			int[][] matrix=new int[n][n];
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					matrix[i][j]=in.nextInt();
				}
			}
			
			int[][] freq=new int[n+1][n+1];
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					freq[i][matrix[i][j]]++;
				}
			}
			
			int countR=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n+1;j++)
				{
					if(freq[i][j]>1)
					{
						countR++;
						break;
					}
				}
			}
			
			for(int[] row: freq)
			{
				Arrays.fill(row,0);
			}
			
			for(int j=0;j<n;j++)
			{
				for(int i=0;i<n;i++)
				{
					freq[matrix[i][j]][j]++;
				}
			}
			
			int countC=0;
			for(int j=0;j<n;j++)
			{
				for(int i=0;i<n+1;i++)
				{
					if(freq[i][j]>1)
					{
						countC++;
						break;
					}
				}
			}
			
			int trace=0;
			for(int i=0;i<n;i++)
			{
				trace=trace+matrix[i][i];
			}
			
			System.out.println("Case #"+(t+1)+": "+trace+" "+countR+" "+countC);
			
		}

	}

}
