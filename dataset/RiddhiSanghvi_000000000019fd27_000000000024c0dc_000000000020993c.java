
import java.util.Scanner;
class Main
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0)
		{
			int n = sc.nextInt();
			int arr[][] =  new int[4][4];
			for(int i = 0 ;i<n ; i++)
			{
				for(int j = 0;j<n;j++)
				{
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0 ;i<n ; i++)
			{
				for(int j = 0;j<n;j++)
				{
					System.out.print(arr[i][j]+ " ");
				}
				System.out.println();
			}
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
		        for (int col = 0; col < arr[row].length; col++)
		        {
		            int num = arr[row][col];
		            for (int otherCol = col + 1; otherCol < arr.length; otherCol++)
		            {
		                if (num == arr[row][otherCol])
		                {
		                    r++;
		                }
		            }
		        }
		    }
			//System.out.println(r);
			
			int c=0;
			for(int row = 0;row<n ;row++)
			{
				for(int col=0; col<n; col++)
				{
					int num = arr[row][col];
					for(int otherRow = row+1; otherRow<arr.length ; otherRow++)
					{
						if(num == arr[otherRow][col])
						{
							c++;
						}
					}
				}
			}
			//System.out.println(c);
			t--;
			int cases=1;
			System.out.println("Case #"+cases+":"+trace+" "+r+" "+c);
		}
		
	}

}
