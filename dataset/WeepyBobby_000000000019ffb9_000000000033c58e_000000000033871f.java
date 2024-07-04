import java.util.*;
import java.math.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(st.readLine());
		int curc = 0;
		nextcase:
		while(curc++ < cases)
		{
			StringTokenizer s = new StringTokenizer(st.readLine());
			//int n = Integer.parseInt(st.readLine());
			int c = Integer.parseInt(s.nextToken());
			int d = Integer.parseInt(s.nextToken());
			int[][] order = new int[c][2];
			s = new StringTokenizer(st.readLine());
			for(int i = 1; i < c; i++)
			{
				order[i][0] = -Integer.parseInt(s.nextToken());
				order[i][1] = i;
			}
			Arrays.sort(order, new Comparator<int[]>()
			{
				public int compare(int[] a, int[] b)
				{
					return a[0]-b[0];
				}
			});
			ArrayList<int[]> map = new ArrayList<int[]>();
			boolean[][] graph = new boolean[c][c];
			for(int i = 0; i < d; i++)
			{
				s = new StringTokenizer(st.readLine());
				int u = Integer.parseInt(s.nextToken())-1;
				int v = Integer.parseInt(s.nextToken())-1;
				graph[u][v] = true;
				graph[v][u] = true;
				map.add(new int[]{u, v});
			}
			int[] time = new int[c];
			Arrays.fill(time, -1);
			time[0] = 0;
			int max = 0;
			int[][] ans = new int[c][c];
			for(int i = 1; i < c; i++)
			{
				int to = order[i][1];
				int min = Integer.MAX_VALUE;
				int from = -1;
				int inc = 1;
				if(order[i-1][0] == order[i][0])
					inc = 0;
				for(int j = 0; j < c; j++)
				{
					if(graph[to][j] && time[j] != -1)
					{
						if(max+inc-time[j] > 0 && max+inc-time[j] < min)
						{
							min = max+inc-time[j];
							from = j;
						}
					}
				}
				ans[to][from] = min;
				ans[from][to] = min;
				for(int j = 0; j < c; j++)
				{
					if(graph[to][j] && j != from)
					{
						ans[to][j] = 1000000;
						ans[j][to] = 1000000;
					}
				}
				time[to] = max+inc;
				max += inc;
			}
			System.out.print("Case #"+curc+": ");
			for(int[] elem:map)
			{
				System.out.print(ans[elem[0]][elem[1]]+" ");
			}
			System.out.println("");



		}
	}
	public static void print(String str)
	{
		System.out.println(str);
		System.out.flush();
		return;
	}
	public static void print(int str)
	{
		System.out.println(str);
		System.out.flush();
		return;
	}
}
