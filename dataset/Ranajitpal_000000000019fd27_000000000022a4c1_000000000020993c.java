import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class solution{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j] = sc.nextInt();
				}
			}
			
			Set<Integer> temp1 = new HashSet<Integer>();
			Set<Integer> temp2 = new HashSet<Integer>();
			
			int row =0;
			int col =0;
			int sum =0;
			for(int i=0;i<n;i++)
			{
				sum += a[i][i];
			}
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					temp1.add(a[i][j]);
					temp2.add(a[j][i]);
				}
				if(temp1.size()!=n)
				{
					row++;
				}
				if(temp2.size() !=n)
				{
					col++;
				}
				temp1.clear();
				temp2.clear();
			}
			
			System.out.println("Case #"+t+": "+sum+" "+row+" "+col);
		}
	}
}
