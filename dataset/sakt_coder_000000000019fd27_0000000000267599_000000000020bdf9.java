import java.io.*;
import java.util.*;
public class Solution
{
	private void solve()throws IOException
	{
		int n=nextInt();
		int l[]=new int[n+1];
		int r[]=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			l[i]=nextInt();
			r[i]=nextInt();
		}
		ArrayList<Integer> list[]=new ArrayList[n+1];
		for(int i=1;i<=n;i++)
			list[i]=new ArrayList<>();
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				if(i!=j && r[i]>l[j] && l[i]<r[j])
					list[i].add(j);
		int color[]=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			if(color[i]!=0)
				continue;
			color[i]=1;
			Queue<Integer> queue=new LinkedList<>();
			queue.add(i);
			while(!queue.isEmpty())
			{
				int v=queue.remove();
				for(int vv:list[v])
					if(color[vv]==0)
					{
						color[vv]=3-color[v];
						queue.add(vv);
					}
					else if(color[vv]!=3-color[v])
					{
						out.println("IMPOSSIBLE");
						return;
					}
			}
		}
		for(int i=1;i<=n;i++)
			out.print(color[i]==1?'C':'J');
		out.println();
	}

	 
	///////////////////////////////////////////////////////////

	public void run()throws IOException
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		st=null;
		out=new PrintWriter(System.out);

		int t=nextInt();
		for(int i=1;i<=t;i++)
		{
			out.print("Case #"+i+": ");
			solve();
		}

		br.close();
		out.close();
	}
	public static void main(String args[])throws IOException{
		new Solution().run();
	}
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	String nextToken()throws IOException{
		while(st==null || !st.hasMoreTokens())
		st=new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	String nextLine()throws IOException{
		return br.readLine();
	}
	int nextInt()throws IOException{
		return Integer.parseInt(nextToken());
	}
	long nextLong()throws IOException{
		return Long.parseLong(nextToken());
	}
	double nextDouble()throws IOException{
		return Double.parseDouble(nextToken());
	}
}