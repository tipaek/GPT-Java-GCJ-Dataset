import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; ++i)
		{
			func(i, sc);
		}
		
	}
	static void func(int tcase, Scanner sc) {
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int arr[][] = new int[n][k];
		int cnt = 0;
		int trace = 0;
		for(int i = 0; i< n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				arr[i][j] = cnt % n + 1;
				cnt++;
				if(i ==j)
					trace+= arr[i][j];
			}
			cnt++;
		}
		
		boolean can = false;
		if(trace != k)
		{
			for(int i = 0; i < n-1; i++)
			{
				for(int j = i+1; j < n; j++)
				{
					trace = trace - arr[i][i] - arr[j][j] + arr[i][j] + arr[j][i];
					if (trace == k)
					{
						can = true;
						swap(arr, i, j);
						break;
					}
				}
				if(can)
					break;
			}
		}
		else
		{
			can = true;
		}
		
		if(can)
		{
			System.out.println("POSSIBLE");
			for(int i = 0; i < n ; i++)
			{
				for(int j = 0; j <n; j++)
				{
					if(j> 0)
						System.out.print(" ");
					System.out.print(arr[i][j]);
					
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("IMPOSSIBLE");
		}
		
		//System.out.println("Case #" + ++tcase + ": " + res);
    }
	private static void swap(int[][] arr, int i, int j) {
		for(int k = 0; k < arr[0].length; k++)
		{
			int tmp = arr[i][k];
			arr[i][k] = arr[j][k];
			arr[j][k] = tmp;
		}
	}

}