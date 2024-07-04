import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	
	public static final String[] NAMES = {"C","J"};
	
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());
		int counter = 1;

		while(T-->0) {
			 
			int n = Integer.parseInt(in.readLine());
			
			PriorityQueue<Activity> pq = new PriorityQueue<Activity>();
			StringTokenizer stk;
			
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(in.readLine());
				Activity current = new Activity(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
				pq.offer(current);
			}
			
			boolean possible = true;
			StringBuilder sb = new StringBuilder();
			// track parent n is busy until x time
			int[] parents = new int[2];
			Arrays.fill(parents, -1);
			
			
			while (!pq.isEmpty() && possible) {
				Activity current = pq.poll();
				boolean activityExecuted = false;
				
				for (int i = 0; i < parents.length && !activityExecuted; i++) {
					if(parents[i] <= current.startTime) {
						parents[i] = current.endTime;
						activityExecuted = true;
						sb.append(NAMES[i]);
					}
				}
				possible = activityExecuted;
			}
			
			String ans = possible ? sb.toString() : "IMPOSSIBLE";
			
			out.write("Case #"+counter+": "+ans+"\n");
			counter++;
		}

		out.flush();
		in.close();
		out.close();
	}
	
	static class Activity implements Comparable<Activity>{	
		int startTime;
		int endTime;	
		
		public Activity(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Activity a) {
			return startTime - a.startTime;
		}
		
		@Override
		public String toString() {
			return startTime+"";
		}
			
	}
	
	
}
