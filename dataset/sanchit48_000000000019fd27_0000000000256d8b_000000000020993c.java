import java.util.*;
class Solution
{
	public static void main(String[] args)
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			int pos = t;
			while(t-- > 0)
			{
				int n = sc.nextInt();
				int r = 0;
				int c = 0;
				int trace = 0;

				int arr[][] = new int[n][n];

				Set<Integer> set = new HashSet<>();


				for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					arr[i][j] = sc.nextInt();

				int sum = 0;
				for(int i=1;i<=n;i++)
					sum += i;

				for(int i=0;i<n;i++)
				{
					int val = 0;
					for (int k= 1; k <= n; k++)
						set.add(k);
					for(int j=0;j<n;j++)
					{
						if(set.contains(arr[i][j]))
							val += arr[i][j];

						set.remove(arr[i][j]);
						if(i==j)
							trace+=arr[i][j];
					}

					if(val!=sum)
						r++;
				}
				set.clear();

				for (int j = 0; j < n; j++)
				{
					int val = 0;
					for (int k = 1; k <= n; k++)
						set.add(k);
					for (int i = 0; i < n; i++)
					{
						if (set.contains(arr[i][j]))
							val += arr[i][j];

						set.remove(arr[i][j]);
					}

					if (val != sum)
						c++;
				}

				System.out.println("Case #"+(pos-t)+": "+trace+" "+r+" "+c);
			}

		}
		catch (Exception e) {}
	}
}
