import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	
	StringTokenizer st;
	BufferedReader file;
	
	public static void main(String[] args) throws Exception
	{
		new Solution().run();
	}	
	
/*
3
1 2
2 2
8 11
 */
	
	public void run() throws Exception
	{
		file = new BufferedReader(new InputStreamReader(System.in));
		int T = nextInt();
	loop:
		for(int z = 0;z<T;z++)
		{
			long L = nextLong();
			long R = nextLong();
			long min = Math.min(L,R);
			long max = Math.max(L,R);
			long diff = max - min;
			long turns = floor1(diff);
			long change = turns*(turns+1)/2;
			max -= change;
			boolean leftMax = L >= R || max == min;
			boolean swap = max == min;
			long nextEven;
			long nextOdd;
			long getOdd;
			long getEven;
			boolean oddFirst;
			if(turns%2==0)
			{
				oddFirst = true;
				getOdd = max;
				getEven = min;
				nextOdd = turns+1;
				nextEven = turns+2;
			}else {
				oddFirst = false;
				getOdd = min;
				getEven = max;
				nextEven = turns+1;
				nextOdd = turns+2;
			}
			long O = (nextOdd+1)/2;
			long E = (nextEven)/2;
			long oddTurns = floor2(getOdd, O);
			long evenTurns = floor3(getEven, E);
			long realOddTurns = Math.max(0, oddTurns - O + 1);
			long realEvenTurns = Math.max(0,evenTurns - E + 1);
			long totalTurns = turns;
			if(oddFirst)
			{
				if(realOddTurns <= realEvenTurns)
					totalTurns += realEvenTurns*2;
				else
					totalTurns += realEvenTurns*2+1;
			}else {
				if(realEvenTurns <= realOddTurns)
					totalTurns += realOddTurns*2;
				else
					totalTurns += realOddTurns*2 + 1;
			}
			long remainingL = L;
			long remainingR = R;
			if(leftMax)
			{
				remainingL = max;
				if(swap)
					remainingR = L;
				if(oddFirst)
				{
					if(evenTurns != 0)
						remainingR -= (evenTurns)*(evenTurns+1) - (E-1)*(E);
					if(oddTurns != 0)
						remainingL -= oddTurns*oddTurns - (O-1)*(O-1);
				}else {
					if(evenTurns != 0)
						remainingL -= (evenTurns)*(evenTurns+1) - (E-1)*(E);
					if(oddTurns != 0)
						remainingR -= oddTurns*oddTurns - (O-1)*(O-1);
				}
			}else {
				remainingR = max;
				if(swap)
					remainingL = R;
				if(oddFirst)
				{
					if(evenTurns != 0)
						remainingL -= (evenTurns)*(evenTurns+1) - (E-1)*(E);
					if(oddTurns != 0)
						remainingR -= oddTurns*oddTurns - (O-1)*(O-1);
				}else {
					if(evenTurns != 0)
						remainingR -= (evenTurns)*(evenTurns+1) - (E-1)*(E);
					if(oddTurns != 0)
						remainingL -= oddTurns*oddTurns - (O-1)*(O-1);
				}
			}
			System.out.printf("Case %d: %d %d %d%n",z+1, totalTurns,remainingL, remainingR );
		}
	}
	
	//find largest (n^2+n)/2 not to exceded diff
	public long floor1(long diff)
	{
		long L = -1;
		long R = 1414213562;//careful
		long M = (L+R)/2;
		long ans = 0;
		while(R-L > 1)
		{
			M = (L+R)/2;
			long amt = M*(M+1)/2;
			if(amt <= diff)
			{
				ans = M;
				L = M;
			}else {
				R = M;
			}
		}
		return ans;
	}
	
	//find largest (n^2) not to exceded diff
	public long floor2(long diff, long firstTerm)
	{
		long L = -1;
		long R = 1000000000L;//careful
		long M = (L+R)/2;
		long ans = 0;
		while(R-L > 1)
		{
			M = (L+R)/2;
			long amt = M*M - (firstTerm-1)*(firstTerm-1);
			if(amt <= diff)
			{
				ans = M;
				L = M;
			}else {
				R = M;
			}
			//System.out.println(M+" "+firstTerm+" "+diff+" "+amt+" "+ans);
		}
		if(ans - firstTerm + 1 > 0)
			return ans;
		return 0;
	}
	
	//find largest (n^2+n) not to exceded diff
	public long floor3(long diff, long firstTerm)
	{
		long L = -1;
		long R = 1000000000L;//careful
		long M = (L+R)/2;
		long ans = 0;
		while(R-L > 1)
		{
			M = (L+R)/2;
			long amt = M*(M+1) - (firstTerm-1)*(firstTerm);
			if(amt <= diff)
			{
				ans = M;
				L = M;
			}else {
				R = M;
			}
		}
		if(ans - firstTerm + 1 > 0)
			return ans;
		return 0;
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
