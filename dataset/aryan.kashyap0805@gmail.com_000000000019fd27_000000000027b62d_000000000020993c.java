import java.util.*;
public class Solution
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int t1=0;t1<t;t1++)
		{
			int n = sc.nextInt();
			int [][]arr = new int[n][n];
			int k = 0;
			int r = 0;
			int c = 0;
			for(int i=0;i<n;i++)
			{
				ArrayList al = new ArrayList();
				for(int j=0;j<n;j++)
				{
					arr[i][j] = sc.nextInt();
					if(!al.contains(arr[i][j]))
					{
						al.add(arr[i][j]);
					}
					if(i == j)
					{
						k += arr[i][j];
					}	
				}
				if(al.size() != n)
				{
					r++;
				}
			}
			for(int i=0;i<n;i++)
			{
				ArrayList al = new ArrayList();
				for(int j=0;j<n;j++)
				{
					if(!al.contains(arr[j][i]))
					{
						al.add(arr[j][i]);
					}
				}
				if(al.size() != n)
				{
					c++;
				}
			}
			System.out.println("Case #"+(t1+1)+": "+k+" "+r+" "+c);
		}
	}
}