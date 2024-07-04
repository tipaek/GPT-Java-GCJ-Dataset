import java.io.*;
import java.util.*;
public class Solution
{
	StringBuilder ans;
	private void solve()throws IOException
	{
		String s=nextLine();
		int n=s.length();
		int a[]=new int[n+1];
		for(int i=1;i<=n;i++)
			a[i]=s.charAt(i-1)-'0';
		ans=new StringBuilder();
		for(int i=1;i<=n;i++)
		{
			if(a[i]>a[i-1])
				addLeft(a[i]-a[i-1]);
			else if(a[i]<a[i-1])
				addRight(a[i-1]-a[i]);
			ans.append(a[i]);
		}
		addRight(a[n]);
		out.println(ans);
	}
	void addLeft(int x)
	{
		while(x-->0)
			ans.append('(');
	}
	void addRight(int x)
	{
		while(x-->0)
			ans.append(')');
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