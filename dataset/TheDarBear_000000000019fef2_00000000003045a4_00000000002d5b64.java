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
4
2 3
-2 -3
3 0
-1 1
 */
	
	int N;
	HashMap<Long, Integer> fp;
	HashMap<Long, Long> pred;
	HashMap<Long, String> move;
	long goodHash;
	
	public void run() throws Exception
	{
		file = new BufferedReader(new InputStreamReader(System.in));
		int T = nextInt();
	loop:
		for(int z = 0;z<T;z++)
		{
			fp = new HashMap<>();
			pred = new HashMap<>();
			move = new HashMap<>();
			int R = nextInt();
			int S = nextInt();
			N = R*S;
			int[] ints = new int[N];
			for(int i = 0;i<ints.length;i++)
				ints[i] = i%R;
			int[] sorted = ints.clone();
			Arrays.sort(sorted);
			goodHash = hash(sorted);
			Queue<Long> que = new LinkedList<Long>();
			que.add(hash(ints));
			fp.put(hash(ints), 0);
			while(!que.isEmpty())
			{
				long hash = que.poll();
				int[] current = unhash(hash);
				if(hash == goodHash)
				{
					solve(hash, z+1);
					continue loop;
				}
				for(int a = 1;a<current.length;a++)
				{
					for(int b = 1;a+b<current.length;b++)
					{
						long move = move(current, a, b);
						if(!fp.containsKey(move))
						{
							fp.put(move, fp.get(hash)+1);
							pred.put(move, hash);
							this.move.put(move, a+" "+b);
							que.add(move);
						}
					}
				}
			}
		}
		
	}
	
	public void solve(long hash, int cas)
	{
		System.out.printf("Case #%d: %d%n", cas, fp.get(hash));
		ArrayList<String> moves = new ArrayList<String>();
		long curr = hash;
		while(fp.get(curr) != 0)
		{
			moves.add(move.get(curr));
			curr = pred.get(curr);
		}
		for(int i = moves.size() - 1;i>=0;i--)
			System.out.println(moves.get(i));
	}
	
	public long move(int[] ints, int a, int b)
	{
		int[] result = ints.clone();
		for(int i = 0;i<b;i++)
		{
			result[i] = ints[a+i];
		}
		for(int i = 0;i<a;i++)
		{
			result[b+i] = ints[i];
		}
		return hash(result);
	}
	
	public long hash(int[] ints)
	{
		long hash = 0;
		for(int i: ints)
		{
			hash *= 7;
			hash += i;
		}
		return hash;
	}
	
	public int[] unhash(long hash)
	{
		int[] ret = new int[N];
		for(int i = 0;i<ret.length;i++)
		{
			ret[ret.length - 1 - i] = (int) (hash % 7);
			hash /= 7;
		}
		return ret;
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
