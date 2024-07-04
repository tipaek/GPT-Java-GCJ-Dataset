
import java.util.Scanner;
import java.io.*;
class Solution
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
			int check1[] = new int[n];
			for (int row = 0; row < n; row++)
			{
	        	for (int col = 0; col < n; col++)
	        	{
	            	int num = arr[row][col];
	            	if(check1[row]==0)
	            	{
	            		for (int otherCol = col + 1; otherCol <n; otherCol++)
						{
			   				if (num == arr[row][otherCol])
							{
			   					check1[row]=1;
								r++;
								break;
							}
						}
	            	}
	            	else
	            		continue;
				}
			}
			//System.out.println(r);
			
			int c=0;
			int check[] = new int[n];
			for(int row = 0;row<n ;row++)
			{
				for(int col=0; col<n; col++)
				{
					int num = arr[row][col];
					if(check[col]==0)
					{
						for(int otherRow = row+1; otherRow<n ; otherRow++)
						{
							if(num == arr[otherRow][col])
							{
								check[col] = 1;
								c++;
								break;
							}
						}
					}
					else
					{
						continue;
					}
					
				}
				//break;
			}
			//System.out.println(c);
			t--;
			System.out.println("Case #"+cases+": "+trace+" "+r+" "+c);
			cases++;
		}
		
	}

}