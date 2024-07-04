import java.io.*;
import java.util.*;
public class Solution
{
	final int inf=(int)(1e9+1);
	private void solve()throws IOException
	{
		int x=nextInt();
		int y=nextInt();
		ArrayList<Point> list=new ArrayList<>();
		list.add(new Point(x,y));
		String M=nextToken();
		for(int i=0;i<M.length();i++)
		{
			switch(M.charAt(i))
			{
				case 'N':y++;break;
				case 'E':x++;break;
				case 'S':y--;break;
				case 'W':x--;break;
			}
			list.add(new Point(x,y));
		}
		int ans=inf;
		for(int time=0;time<list.size();time++)
		{
			Point p=list.get(time);
			int dist=Math.abs(p.x)+Math.abs(p.y);
			if(dist<=time)
				ans=Math.min(ans,time);
		}
		out.println(ans==inf?"IMPOSSIBLE":ans);
	}
	class Point{
	    int x,y;
	    Point(int a,int b){
	        x=a;
	        y=b;
	    }
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