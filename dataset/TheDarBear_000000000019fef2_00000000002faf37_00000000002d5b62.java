import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	StringTokenizer st;
	BufferedReader file;
	
	public static void main(String[] args) throws Exception
	{
		new Solution().run();
	}	
	
/*
4
2 3
-2 -3
3 0
-1 1
 */
	
	public void run() throws Exception
	{
		file = new BufferedReader(new InputStreamReader(System.in));
		int T = nextInt();
		for(int z = 0;z<T;z++)
		{
			int X = nextInt();
			int Y = nextInt();
			boolean xneg = X < 0;
			boolean yneg = Y < 0;
			String sol = solve(Math.abs(X), Math.abs(Y), 1);
			if(sol == null)
				System.out.printf("Case #%d: IMPOSSIBLE%n", z+1);
			else {
				if(xneg)
					sol = sol.replace('W', 'X').replace('E', 'W').replace('X', 'E');
				if(yneg)
					sol = sol.replace('N', 'X').replace('S', 'N').replace('X', 'S');
				System.out.printf("Case #%d: %s%n", z+1, sol);
			}			
		}
		
	}
	
	//assume x both positive, we can flip directions otherwise
	public String solve(int x, int y, int smallStep)
	{
		if(x == 0 && y == 0)
			return "";
		boolean xodd = (x&smallStep) != 0;
		boolean yodd = (y&smallStep) != 0;
		if(xodd == yodd)
			return null;
		if(xodd)
		{
			String xleft = solve(Math.abs(x-smallStep), y, smallStep*2);
			boolean neg = x - smallStep < 0;
			if(xleft != null)
			{
				if(neg)
				{
					String flip = xleft.replace('W', 'X').replace('E', 'W').replace('X', 'E');
					return 'E'+flip;
				}
				return 'E'+xleft;
			}
			String xright = solve(Math.abs(x+smallStep),y, smallStep*2);
			if(xright != null)
			{
				return 'W' + xright;
			}
		}else {
			String yup = solve(x, y + smallStep, smallStep * 2);
			String ydown = solve(x, Math.abs(y-smallStep), smallStep * 2);
			boolean neg = y - smallStep < 0;
			if(ydown != null)
			{
				if(neg)
				{
					String flip = ydown.replace('N', 'X').replace('S', 'N').replace('X', 'S');
					return 'N'+flip;
				}
				return 'N'+ydown;
			}
			if(yup != null)
			{
				return 'S' + yup;
			}
		}
		return "mystery";
	}
	
	public void sort(Object[] comps)
	{
		Arrays.sort(comps);
	}
	
	public void newst()
	{
		try {
			st = new StringTokenizer(file.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String readLine() throws IOException
	{
		return file.readLine();
	}
	
	public String next()
	{
		if(st == null || !st.hasMoreTokens())
			newst();
		return st.nextToken();
	}
	
	public int nextInt()
	{
		if(st == null || !st.hasMoreTokens())
			newst();
		return Integer.parseInt(st.nextToken());
	}
	
	public long nextLong()
	{
		if(st == null || !st.hasMoreTokens())
			newst();
		return Long.parseLong(st.nextToken());
	}
	
	public int[] readInts(int N)
	{
		int[] ints = new int[N];
		for(int i = 0;i<N;i++)
		{
			ints[i] = nextInt();
		}
		return ints;
	}
	
	public long[] readLongs(int N)
	{	
		long[] ints = new long[N];
		for(int i = 0;i<N;i++)
		{
			ints[i] = nextLong();
		}
		return ints;
	}
	
}
