import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		int x = 1;
		
		while(t > 0)
		{
			int n = s.nextInt();
			int sum = 0;
			int countRow = 0;
			int countCol = 0;
			int[][] arr = new int[n][n];
			
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<n; j++)
				{
					arr[i][j] = s.nextInt();
					if(i == j)
					{
						sum += arr[i][j];
					}
				}
			}
			
			for(int i = 0; i<n; i++)
			{
				int r = 0;
				for(int j = 0; j<n; j++)
				{
					int c = arr[i][j];
					for(int k = j+1; k<n-1; k++ )
					{
						if(c == arr[i][k])
						{
							r ++;
						}
					}
				}
				if(r > 0)
					countRow ++;
			}
			
			int e = 0;
			int y = 0;
			
			while(y < n)
			{
				int r = 0;
				for(int k = 0; k<n; k++)
				{
				   int c = arr[k][e];
				
				   for(int b = k+1; b<n; b++)
				   	{
					   if(c == arr[b][e])
					   {
						   r ++;
					   }
				   	}
				}
				
				if(r > 0)
					 countCol ++;
				e++;
				y++;
				
			}
			
			System.out.print("Case #" + x + ": " + sum + " " + countRow + " " + countCol);
		    x++;
		    t--;
		}
	}

}
