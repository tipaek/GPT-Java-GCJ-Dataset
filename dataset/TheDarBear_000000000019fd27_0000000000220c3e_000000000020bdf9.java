import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception
	{
		new Solution().run();
	}
	
	public void run() throws Exception
	{
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(file.readLine());
		StringTokenizer st;
	loop:
		for(int z = 0;z<T;z++)
		{
			int N = Integer.parseInt(file.readLine());
			PriorityQueue<event> que = new PriorityQueue<event>();
			event[] starts = new event[N];
			for(int i = 0;i<N;i++)
			{
				st = new StringTokenizer(file.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				event start = new event(i, s, true);
				starts[i] = start;
				event end = new event(i, e, false);
				que.add(start);
				que.add(end);
			}
			PriorityQueue<Character> free = new PriorityQueue<Character>();
			free.add('C');
			free.add('J');
			while(!que.isEmpty())
			{
				event e = que.poll();
				if(e.start)
				{
					if(free.isEmpty())
					{
						System.out.printf("Case #%d: IMPOSSIBLE%n", z+1);
						continue loop;
					}else
					{
						e.assign = free.poll();
					}
				}else {
					free.add(starts[e.id].assign);
				}
			}
			StringBuilder ans = new StringBuilder();
			for(int i = 0;i<N;i++)
			{
				ans.append(starts[i].assign);
			}
			System.out.printf("Case #%d: %s%n", z+1, ans.toString());
		}
	}
	
	private class event implements Comparable<event>{
		
		int id;
		int t;
		boolean start;
		char assign;
		
		public event(int id, int t, boolean start){
			this.id = id;
			this.t = t;
			this.start = start;
		}

		@Override
		public int compareTo(event o) {
			int comp = Integer.compare(t, o.t);
			if(comp == 0)
			{
				return Boolean.compare(start, o.start);
			}
			return comp;
		}
		
	}
	
}
