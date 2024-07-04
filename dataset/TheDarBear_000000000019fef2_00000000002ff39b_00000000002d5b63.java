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
		int A = nextInt();
		int B = nextInt();
		int[] firstX = new int[] {-1000000000/2, -1000000000/2, 1000000000/2, 1000000000/2};
		int[] firstY = new int[] {-1000000000/2,  1000000000/2,-1000000000/2, 1000000000/2};
	loop:
		for(int z = 0;z<T;z++)
		{
			int insideX = -1;
			int insideY = -1;
			for(int i = 0;i<4;i++)
			{
				String s = interact(firstX[i] +" "+ firstY[i]);
				if(s.equals("HIT"))
				{
					insideX = firstX[i];
					insideY = firstY[i];
					break;
				}
				if(s.equals("CENTER"))
				{
					continue loop;
				}
			}
			
			//find x left
			long L = -1000000001;
			long R =  insideX;
			long M = (L+R)/2;
			while(R-L > 1)
			{
				M = (L+R)/2;
				String interact = M+" "+insideY;
				String response = interact(interact);
				if(response.equals("MISS"))
				{
					L = M;
				}
				else if(response.equals("CENTER"))
				{
					continue loop;
				}else {
					R = M;
				}
			}
			long xLeft = L;
			
			//find x right
			L = insideX;
			R =  1000000001;
			M = (L+R)/2;
			while(R-L > 1)
			{
				M = (L+R)/2;
				String interact = M+" "+insideY;
				String response = interact(interact);
				if(response.equals("MISS"))
				{
					R = M;
				}
				else if(response.equals("CENTER"))
				{
					continue loop;
				}else {
					L = M;
				}
			}
			long xRight = R;
			
			//find y down
			L = -1000000001;
			R =  insideY;
			M = (L+R)/2;
			while(R-L > 1)
			{
				M = (L+R)/2;
				String interact = insideX+" "+M;
				String response = interact(interact);
				if(response.equals("MISS"))
				{
					L = M;
				}
				else if(response.equals("CENTER"))
				{
					continue loop;
				}else {
					R = M;
				}
			}
			long yDown = L;
			
			//find y up
			L = insideY;
			R =  1000000001;
			M = (L+R)/2;
			while(R-L > 1)
			{
				M = (L+R)/2;
				String interact = insideX+" "+M;
				String response = interact(interact);
				if(response.equals("MISS"))
				{
					R = M;
				}
				else if(response.equals("CENTER"))
				{
					continue loop;
				}else {
					L = M;
				}
			}
			long yup = R;
			long cx = (xLeft+xRight)/2;
			long cy = (yup + yDown)/2;
			interact(cx+" "+cy);
		}
		
	}
	
	public String interact(String output)
	{
		System.out.println(output);
		System.out.flush();
		try {
			return file.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
