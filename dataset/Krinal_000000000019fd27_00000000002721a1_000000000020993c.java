import java.util.Scanner;

class Solution
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int ii=1;ii<=t;ii++)
		{
			int n = sc.nextInt();
			int arr[][]= new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j]=sc.nextInt();
				}
			}
			int row = 0;
			for(int i=0;i<n;i++)
			{
				int a[] = new int[n];
				for(int j=0;j<n;j++)
				{
					a[j]=0;
				}
				for(int j=0;j<n;j++)
				{
					if(a[arr[i][j]-1]==0)
						a[arr[i][j]-1]=1;
					else
					{
						row++;
						break;
					}
				}
			}
			int col = 0;
			for(int i=0;i<n;i++)
			{
				int a[] = new int[n];
				for(int j=0;j<n;j++)
				{
					a[j]=0;
				}
				for(int j=0;j<n;j++)
				{
					if(a[arr[j][i]-1]==0)
						a[arr[j][i]-1]=1;
					else
					{
						col++;
						break;
					}
				}
			}
			int trace=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
					if(i==j)
					trace+=arr[i][j];
			}
			System.out.println("Case #"+(ii)+": "+trace+" "+row+" "+ col);
		}
	}
}
