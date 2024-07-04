import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			PriorityQueue<Event> PQ = new PriorityQueue<Event>();
			for(int a=0;a<N;a++){
				PQ.add(new Event(sc.nextInt(),sc.nextInt()-1,a));
			}
			
			int cur = -1000;
			int other = -1000;
			char[] answer = new char[N];
			Arrays.fill(answer, 'J');
			boolean impossible = false;
			while(!PQ.isEmpty()){
				Event now = PQ.poll();
				if(now.s>cur){
					cur=now.e;
					answer[now.i]='C';
				}
				else {
					if (now.s>other){
						other=now.e;
					} else {
						impossible=true;
					}
				}
			}
			
			System.out.printf("Case #%d: %s%n", t, impossible ? "IMPOSSIBLE" : String.valueOf(answer));
		}
	}
	static class Event implements Comparable<Event>
	{
		int s,e,i;
		Event (int a, int b,int c){
			s=a;
			e=b;
			i=c;
		}
		@Override
		public int compareTo(Event that) {
			if (this.s == that.s) return Integer.compare(this.e, that.e);
			return Integer.compare(this.s, that.s);
		}
	}
}
