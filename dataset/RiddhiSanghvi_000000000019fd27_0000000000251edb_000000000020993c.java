
import java.util.Scanner;
import java.io.*;
class Main
{

	public static void main(String[] args) 
	{
		int cases=1;
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		while(t!=0)
		{
			int n = sc.nextInt();
			int arr[][] =  new int[n][n];
			for(int i = 0 ;i<n ; i++)
			{
				for(int j = 0;j<n;j++)
				{
					arr[i][j] = sc.nextInt();
				}
			}
			
			/*for(int i = 0 ;i<n ; i++)
			{
				for(int j = 0;j<n;j++)
				{
					System.out.print(arr[i][j]+ " ");
				}
				System.out.println();
			}*/
			int trace=0;
			for(int i = 0 ;i<n ; i++)
			{
				for(int j = 0;j<n;j++)
				{
					if(i==j)
					{
						trace +=arr[i][j];
					}
				}
			}
			//System.out.println(trace);
			
			int r=0;
			for (int row = 0; row < n; row++)
			{
		        	for (int col = 0; col < n; col++)
		        	{
		            		int num = arr[row][col];
					for (int otherCol = col + 1; otherCol < arr.length; otherCol++)
					{
		   				if (num == arr[row][otherCol])
						{
							r++;
							break;
						}
					}
					break;
				}
			}
			//System.out.println(r);
			
			int c=0;
			for(int row = 0;row<n ;row++)
			{
				for(int col=0; col<n; col++)
				{
					int num = arr[row][col];
					for(int otherRow = row+1; otherRow<n ; otherRow++)
					{
						if(num == arr[otherRow][col])
						{
							c++;
							break;
						}
					}
				}
				break;
			}
			//System.out.println(c);
			t--;
			System.out.println("Case #"+cases+": "+trace+" "+r+" "+c);
			cases++;
		}
		
	}

}