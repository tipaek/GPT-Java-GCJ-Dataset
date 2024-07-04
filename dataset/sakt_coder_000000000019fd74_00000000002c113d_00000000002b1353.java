import java.io.*;
import java.util.*;
public class Solution
{
	
	private void solve()throws IOException
	{
		int n=nextInt();
		ArrayList<String> ans=new ArrayList<>();
		int i=1;
		if(n==501)
		{
			ans.add("1 1");
			ans.add("2 1");
			ans.add("2 2");
			ans.add("3 2");
			n-=7;
			i=3;
		}
		for(;i<=500;i++)
		{
			n--;
			ans.add(i+" "+1);
			if(n==0)
				break;
		}
		for(String s:ans)
			out.println(s);
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
			out.println("Case #"+i+": ");
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