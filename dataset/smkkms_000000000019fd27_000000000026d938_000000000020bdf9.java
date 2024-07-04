import java.io.*;
import java.util.*;

class Solution
{
	static class Pair
	{
		int s,e,in;
		public Pair(int s,int e,int in)
		{
			this.s = s;
			this.e = e;
			this.in = in;
		}
	}
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
			 Pair pair[] = new Pair[n];

			 for(int i=0;i<n;i++)
			 {
			 	int a[] = br.readIntArray();
			 	pair[i] = new Pair(a[0],a[1],i);
			 }

			 char ans[] = new char[n];
			 Arrays.sort(pair,new Comparator<Pair>()
				{
					public int compare(Pair a,Pair b)
					{
						if(a.e==b.e)
							return b.s-a.s;
						else
							return a.e-b.e;
					}
				});

			 //System.out.println(pair);
			 ArrayList<Integer> index = new ArrayList<Integer>();
			 int last_time = -1;
			 for(int i=0;i<n;i++)
			 {
			 	if(last_time<=pair[i].s)
			 	{
			 		ans[pair[i].in] = 'C';
			 		last_time = pair[i].e;
			 	}
			 	else
			 	{
			 		index.add(i);
			 	}
			 }
			 //System.out.println(index);
			 last_time = -1;
			 boolean flag = true;
			 for(int i=0;i<index.size();i++)
			 {
			 	if(last_time<=pair[index.get(i)].s)
			 	{
			 		ans[pair[index.get(i)].in] = 'J';
			 		last_time = pair[index.get(i)].e;
			 	}
			 	else
			 	{
			 		flag = false;
			 		break;
			 	}
			 }

			 pw.print("Case #"+t+": ");
			 if(!flag)
			 	pw.println("IMPOSSIBLE");
			 else
			 {
			 	for(int i=0;i<ans.length;i++)
			 	{
			 		pw.print(ans[i]);
			 	}
			 	pw.println();
			 }

		}
		pw.close();
		br.close();
	}
}