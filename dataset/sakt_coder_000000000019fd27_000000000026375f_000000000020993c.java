import java.io.*;
import java.util.*;
public class Solution
{
	
	private void solve()throws IOException
	{
		int n=nextInt();
		int m[][]=new int[n+1][n+1];
		int r=0,c=0,d=0;
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
			{
				m[i][j]=nextInt();
				if(i==j)
					d+=m[i][j];
			}
		for(int i=1;i<=n;i++)
		{
			boolean visited[]=new boolean[n+1];
			for(int j=1;j<=n;j++)
				if(visited[m[i][j]])
				{
					r++;
					break;
				}
				else
					visited[m[i][j]]=true;
		}
		for(int i=1;i<=n;i++)
		{
			boolean visited[]=new boolean[n+1];
			for(int j=1;j<=n;j++)
				if(visited[m[j][i]])
				{
					c++;
					break;
				}
				else
					visited[m[j][i]]=true;
		}
		out.println(d+" "+r+" "+c);
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