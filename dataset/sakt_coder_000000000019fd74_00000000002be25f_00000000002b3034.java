import java.io.*;
import java.util.*;
public class Solution
{
	
	private void solve()throws IOException
	{
		int n=nextInt();
		String s[][]=new String[n+1][];
		for(int i=1;i<=n;i++)
			s[i]=(nextLine()).split("\\*",-1);
		StringBuilder ans=new StringBuilder();
		boolean starred[]=new boolean[n+1];
		for(int j=0;;j++)
		{
			char ch='#';
			for(int i=1;i<=n;i++)
				if(!starred[i])
				{
					if(s[i][0].length()-1<j)
						starred[i]=true;
					else if(ch=='#')
						ch=s[i][0].charAt(j);
					else if(s[i][0].charAt(j)!=ch)
					{
						out.println("*");
						return;
					}
				}
			if(ch=='#')
				break;
			ans.append(ch);
		}
		for(int j=1;;j++)
		{
			boolean flag=false;
			for(int i=1;i<=n;i++)
			{
				if(s[i].length-2<j)
					continue;
				flag=true;
				ans.append(s[i][j]);
			}
			if(!flag)
				break;
		}
		Stack<Character> stack=new Stack<>();
		starred=new boolean[n+1];
		for(int j=0;;j++)
		{
			char ch='#';
			for(int i=1;i<=n;i++)
				if(!starred[i])
				{
					if(s[i][s[i].length-1].length()-1<j)
						starred[i]=true;
					else if(ch=='#')
						ch=s[i][s[i].length-1].charAt(s[i][s[i].length-1].length()-1-j);
					else if(s[i][s[i].length-1].charAt(s[i][s[i].length-1].length()-1-j)!=ch)
					{
						out.println("*");
						return;
					}
				}
			if(ch=='#')
				break;
			stack.push(ch);
		}
		while(!stack.isEmpty())
			ans.append(stack.pop());
		out.println(ans.length()==0?'A':ans);
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