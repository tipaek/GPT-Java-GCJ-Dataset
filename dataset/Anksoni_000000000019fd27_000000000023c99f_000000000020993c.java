import java.util.*;
class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=1; i<=t; i++)
		{
			int n = in.nextInt();
			int[][] x = new int[n][n];
			for(int j=0; j<n; j++)
			{
				for(int k=0; k<n; k++)
				{
					x[j][k] = in.nextInt();
				}
			}
			HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> h2 = new HashMap<Integer, Integer>();
			int sum=0, row=0, col=0;
			for(int j=0; j<n; j++)
			{
				sum = sum+x[j][j];
				for(int k=0; k<n; k++)
				{
					int temp1 = x[j][k];
					int temp2 = x[k][j];
					if(h1.containsKey(temp1))
					{
						h1.put(temp1, h1.get(temp1)+1);
					}
					if(h2.containsKey(temp2))
					{
						h2.put(temp2, h2.get(temp2)+1);
					}
					if(!h1.containsKey(temp1))
					{
						h1.put(temp1, 1);
					}
					if(!h2.containsKey(temp2))
					{
						h2.put(temp2, 1);
					}
				}
				int MAX1 = Collections.max(h1.values());
				int MAX2 = Collections.max(h2.values());
				if(MAX1 > 1)
				{
					row++;
				}
				if(MAX2 > 1)
				{
					col++;
				}
				h1.clear();
				h2.clear();
			}
			System.out.println("Case #"+i+": "+sum+" "+row+" "+col);
		}
	}
}