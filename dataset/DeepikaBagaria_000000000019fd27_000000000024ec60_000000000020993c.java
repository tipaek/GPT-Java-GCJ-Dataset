import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution
{

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tt = 0; tt < t; tt++)
		{

			int n = Integer.parseInt(br.readLine());
			int trace = 0;
			int rows = 0;
			HashSet<Integer> col = new HashSet<Integer>();
			int arr[][] = new int[n][n];
			int b[] = new int[n];
			for (int i = 0; i < n; i++)
			{
				b = new int[n];
				boolean flag = false;
				StringTokenizer str = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
				{
					int val = Integer.parseInt(str.nextToken()) -1;
					if (i == j)
					{
						trace = trace + val;
					}
					arr[val][j]++;
					if (arr[val][j] > 1)
					{
						col.add(j);
					}
					if (!flag)
					{
						b[val]++;
						if (b[val] > 1)
							flag = true;
					}
				}
				if(flag)
				{
					rows++;
				}
			}
			trace+=n;
			System.out.println("Case #" + (tt+1) + ": " +trace+" "+rows+" "+col.size());
		}
        System.exit(0);
	}
}
