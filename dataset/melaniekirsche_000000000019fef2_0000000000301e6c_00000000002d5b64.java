import java.util.*;
public class Solution {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int T = input.nextInt();
	for(int t = 1; t<=T; t++)
	{
		int r = input.nextInt(), s = input.nextInt();
		int n = r*s;
		int[] a = new int[n];
		for(int i = 0; i<n; i++) a[i] = i;
			
		//System.out.println(Arrays.toString(a));
		
		if(r == 1 || s == 1)
		{
			System.out.println("Case #" + t + ": " + 0);
			continue;
		}
		else if(r == 2)
		{
			System.out.println("Case #" + t + ": " + (s-1));
			for(int i = 0; i<s-1; i++)
			{
				System.out.println((2*i+2) + " " + 1);
			}
			continue;
		}
		else if(s == 2)
		{
			System.out.println("Case #" + t + ": " + (r+1)/2);
			for(int i = 0; i<(r+1)/2; i++)
			{
				if(r%2 == 1 && i+1 == (r+1)/2)
				{
					System.out.println(1+" "+(r-1+2*i));
				}
				else System.out.println(2+" "+(r-1+2*i));
			}
			continue;
		}
		else if(r == 3 && s == 4)
		{
			System.out.println("Case #" + t + ": " + 5);
			System.out.println("1 2");
			System.out.println("2 3");
			System.out.println("4 3");
			System.out.println("5 4");
			System.out.println("6 5");
		}
		else if(s == 4 && s == 3)
		{
			System.out.println("Case #" + t + ": " + 4);
			System.out.println("2 3");
			System.out.println("2 5");
			System.out.println("4 5");
			System.out.println("4 7");
		}
		
		HashMap<Long, Long> visited = new HashMap<Long, Long>();
		HashMap<Long, Integer> lastMove = new HashMap<Long, Integer>();
		Queue<Long> q = new LinkedList<Long>();
		Queue<Integer> ds = new LinkedList<Integer>();
		visited.put(encode(a), (long) -1);
		lastMove.put(encode(a), -1);
		q.add(encode(a));
		ds.add(0);
		
		long place = -1;
		while(!q.isEmpty())
		{
			long val = q.poll();
			int[] at = decode(val, n);
			//System.out.println(Arrays.toString(at));
			int d = ds.poll();
			//System.out.println(Arrays.toString(at)+" "+d);
			boolean done = true;
			for(int i = 0; i<n; i++)
			{
				done &= at[i]%r == (i/s);
			}
			if(done)
			{
				place = val;
				System.out.println("Case #" + t + ": " + d);
				break;
			}
			for(int i = 1; i<=n-1; i++)
				for(int j = 1; j+i<=n; j++)
				{
					int[] na = new int[n];
					int idx = 0;
					for(int k = 0; k<j; k++)
					{
						na[idx++] = at[i+k];
					}
					for(int k = 0; k<i; k++)
					{
						na[idx++] = at[k];
					}
					for(int k = 0; k<n-j-i; k++)
					{
						na[idx++] = at[i+j+k];
					}
					if(!visited.containsKey(encode(na)))
					{
						visited.put(encode(na), val);
						q.add(encode(na));
						lastMove.put(encode(na), i*n + j);
						ds.add(d+1);
					}
				}
		}
		Stack<String> stk = new Stack<String>();
		while(place != -1)
		{
			int last = lastMove.get(place);
			place = visited.get(place);
			if(place != -1)
			{
				stk.push(last/n+" "+last%n);
			}
		}
		while(!stk.isEmpty())
		{
			System.out.println(stk.pop());
		}
	}
}
static int[] decode(long a, int n)
{
	int[] res = new int[n];
	for(int i = 0; i<n; i++)
	{
		res[n-1-i] = (int)(a%n);
		a /= n;
	}
	return res;
}
static long encode(int[] a)
{
	int n = a.length;
	long res = 0;
	for(int i = 0; i<n; i++)
	{
		res *= n;
		res += a[i];
	}
	return res;
}
}
