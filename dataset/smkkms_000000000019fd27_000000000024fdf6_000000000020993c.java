import java.io.*;
import java.util.*;

class Vesigium
{
	static class InputReader
	{
		BufferedReader br;
		public InputReader() throws IOException
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public int readInt() throws IOException
		{
			return Integer.parseInt(br.readLine());
		}
		public long readLong() throws IOException
		{
			return Long.parseLong(br.readLine());
		}
		public String readLine() throws IOException
		{
			return br.readLine();
		}
		public int[] readIntArray() throws IOException
		{
			return Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		}
		public long[] readLongArray() throws IOException
		{
			return Arrays.asList(br.readLine().split(" ")).stream().mapToLong(Long::parseLong).toArray();
		}
		public void close() throws IOException
		{
			br.close();
		}
	}
	public static void main(String[] args) throws IOException
	{
		InputReader br = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);

		int test = br.readInt();
		for(int t=1;t<=test;t++)
		{
			int n = br.readInt();
			int a[][] = new int[n][n];
			for(int i=0;i<n;i++)
			{
				a[i] = br.readIntArray();
			}

			int sum = 0,row_d = 0,col_d=0;
			int count[] = new int[101];


			for(int i=0;i<n;i++)
			{
				sum += a[i][i];
			}

			for(int i=0;i<n;i++)
			{
				Arrays.fill(count,0);
				for(int j=0;j<n;j++)
				{
					count[a[i][j]]++;
					if(count[a[i][j]]==2)
					{
						row_d++;
						break;
					}
				}
			}

			for(int i=0;i<n;i++)
			{
				Arrays.fill(count,0);
				for(int j=0;j<n;j++)
				{
					count[a[j][i]]++;
					if(count[a[j][i]]==2)
					{
						col_d++;
						break;
					}
				}
			}

			pw.println("Case #"+t+": "+sum+" "+row_d+" "+col_d);
		}
		pw.close();
		br.close();
	}
}