import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int l;
		l=t;
		int[] arr2 = new int[101];
		int[] arr1 = new int[101];
		for(int k=0;k<t;k++)
		{
			int n,row=0,coloumn=0;
			n = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int i=0;i<n;i++)
			{
				for (int j=0;j<101;j++)
				{
					arr2[j]=0;
				}
				for (int j=0;j<n;j++)
				{
					int x = sc.nextInt();
					arr[i][j]=x;
					arr2[x]++;
				}
				for (int j=0;j<101;j++)
				{
					if(arr2[j]>1)
					{
						row++;
						break;
					}
				}
			}
			for (int i=0;i<n;i++)
			{
				for (int j=0;j<101;j++)
				{
					arr1[j]=0;
				}
				for (int j=0;j<n;j++)
				{
					arr1[arr[j][i]]++;
				}
				for (int j=0;j<101;j++)
				{
					if(arr1[j]>1)
					{
						coloumn++;
						break;
					}
				}
			}
			int trace =0;
			for (int i=0;i<n;i++)
			{
				trace+=arr[i][i];
			}
			System.out.println("Case #"+(k+1)+": "+trace+" "+row+" "+coloumn);
		}
	}
}