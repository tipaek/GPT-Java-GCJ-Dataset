import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner fs=new Scanner(System.in);
		int T=fs.nextInt();
		outer:for (int tt=1; tt<=T; tt++) {
			int n=fs.nextInt();
			Event[] events=new Event[n];
			for (int i=0; i<n; i++) events[i]=new Event(fs.nextInt(), fs.nextInt(), i);
			Arrays.sort(events);
			int[] free=new int[2];
			boolean[] a=new boolean[n];
			for (Event e:events) {
				if (free[0]<=e.from) {
					free[0]=e.to;
					a[e.index]=false;
				}
				else if (free[1]<=e.from) {
					free[1]=e.to;
					a[e.index]=true;
				}
				else {
					System.out.println("Case #"+tt+": IMPOSSIBLE");
					continue outer;
				}
			}
			System.out.print("Case #"+tt+": ");
			for (boolean b:a) System.out.print(b?'C':'J');
			System.out.println();
		}
	}
	
	static class Event implements Comparable<Event> {
		int from, to, index;
		
		public Event(int from, int to, int index) {
			this.from=from;
			this.to=to;
			this.index=index;
		}
		
		public int compareTo(Event o) {
			return Integer.compare(from, o.from);
		}
	}

}
