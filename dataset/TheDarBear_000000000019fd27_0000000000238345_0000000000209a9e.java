import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception
	{
		new Solution().run();
	}
	
	int B;
	int Q;
	ArrayList[] representations;
	int[] originalQueries;
	BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pout = new PrintWriter(System.out);
	
	public void run() throws Exception
	{
		StringTokenizer st = new StringTokenizer(file.readLine());
		int T = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		for(int z = 0;z<T;z++)
		{
			Q = 0;
			originalQueries = new int[B];
			for(int i = 0;i<B/10;i++)
			{
				for(int j = 0;j<5;j++)
				{
					originalQueries[i*5+j] = Integer.parseInt(interact(i*5+j+1+""));
					originalQueries[B-1-(i*5+j)] = Integer.parseInt(interact(B-(i*5+j)+""));
				}
			}
			representations = new ArrayList[B/10];
			for(int i = 0;i<representations.length;i++)
			{
				HashSet<String> reps = new HashSet<String>();
				reps.add(rep(i));
				reps.add(reverse(i));
				reps.add(flip(i));
				reps.add(flipReverse(i));
				representations[i] = new ArrayList<String>(reps);
			}
			int size = 1;
			int rootIndex = 0;
			for(int i = 1;i<representations.length;i++)
			{
				if(representations[i].size() > representations[rootIndex].size())
				{
					rootIndex = i;
				}
			}
			boolean[] connected = new boolean[B/10];
			connected[rootIndex] = true;
			int leafIndex = 0;
			String rootState = getState(rootIndex);
			HashMap<String, String> map = new HashMap<String, String>();
			while(size != connected.length)
			{
				while(connected[leafIndex])
					leafIndex++;
				if(Q % 10 == 9)
				{
					interact("1");
					rootState = getState(rootIndex);
				}
				String leafState = getState(leafIndex);
				map.put(rootState+" "+leafIndex, leafState);
				map.put(reverseRelative(rootIndex, rootState)+" "+leafIndex, reverseRelative(leafIndex, leafState));
				map.put(flipRelative(rootIndex, rootState)+" "+leafIndex, flipRelative(leafIndex, leafState));
				map.put(flipReverseRelative(rootIndex, rootState)+" "+leafIndex, flipReverseRelative(leafIndex, leafState));
				connected[leafIndex] = true;
				size++;
			}
			int[] currentState = new int[B];
			for(int i = 0;i<B/10;i++)
			{
				String state = null;;
				if(i == rootIndex)
				{
					state = rootState;
				}else {
					state = map.get(rootState+" "+i);
				}
				for(int j = 0;j<5;j++)
				{
					currentState[i*5+j] = state.charAt(j)-'0';
				}
			}
			for(int i = 0;i<B/2;i++)
			{
				currentState[B-1-i] = currentState[i]^originalQueries[i]^originalQueries[B-1-i];
			}
			StringBuilder sb = new StringBuilder();
			for(int x: currentState)
				sb.append(x);
			String interact = interact(sb.toString());
			if(!interact.equals("Y"))
			{
				return;
			}
		}
	}
	
	public String reverseRelative(int block, String current)
	{
		String mirror = "";
		int mirrorBlock = B/5-block-1;
		for(int i = 0;i<5;i++)
			mirror += (current.charAt(i) - '0')^originalQueries[block*5+i]^originalQueries[(mirrorBlock+1)*5-1-i];
		return mirror;
	}
	
	public String flipRelative(int block, String current)
	{
		StringBuilder sb = new StringBuilder();
		for(char ch: current.toCharArray())
			if(ch == '1')
				sb.append('0');
			else
				sb.append('1');
		return sb.toString();
	}
	
	public String flipReverseRelative(int block, String current)
	{
		String mirror = "";
		int mirrorBlock = B/5-block-1;
		for(int i = 0;i<5;i++)
			mirror += (current.charAt(i) - '0')^originalQueries[block*5+i]^originalQueries[(mirrorBlock+1)*5-1-i];
		StringBuilder sb = new StringBuilder();
		for(char ch: mirror.toCharArray())
			if(ch == '1')
				sb.append('0');
			else
				sb.append('1');
		return sb.toString();
	}
	
	public String getState(int block) throws IOException
	{
		ArrayList<String> reps  = representations[block];
		HashSet<String> set = new HashSet<String>();
		int[] dist = null;
		for(int i = 0;i<5;i++)
		{
			for(int j = i+1;j<5;j++)
			{
				for(int k = j+1;k<5;k++)
				{
					set.clear();
					for(String s: reps)
					{
						set.add(s.charAt(i)+""+s.charAt(j)+""+s.charAt(k));
					}
					if(set.size() == reps.size())
					{
						dist = new int[] {i,j,k};
					}
				}
			}
		}
		String str = "";
		for(int i: dist)
		{
			str += interact(block*5+i+1+"");
		}
		for(String s: reps)
		{
			String test = "";
			for(int i: dist)
				test += s.charAt(i);
			if(test.equals(str))
				return s;
		}
		return null;
	}
	
	public String rep(int block)
	{
		String ret = "";
		for(int j = 0;j<5;j++)
		{
			ret += originalQueries[block*5+j];
		}
		return ret;
	}
	
	public String flip(int block)
	{
		String s = rep(block);
		StringBuilder sb = new StringBuilder();
		for(char ch: s.toCharArray())
			if(ch == '1')
				sb.append('0');
			else
				sb.append('1');
		return sb.toString();
	}
	
	public String reverse(int block)
	{
		return new StringBuffer(rep(B/5-block-1)).reverse().toString();
	}
	
	public String flipReverse(int block)
	{
		String s = reverse(block);
		StringBuilder sb = new StringBuilder();
		for(char ch: s.toCharArray())
			if(ch == '1')
				sb.append('0');
			else
				sb.append('1');
		return sb.toString();
	}
	
	public String interact(String request) throws IOException
	{
		Q++;
		pout.println(request);
		pout.flush();
		return file.readLine();
	}
	
}
