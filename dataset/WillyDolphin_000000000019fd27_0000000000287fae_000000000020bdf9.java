import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int n = sc.nextInt();
			ArrayList<Interval> jobs =new ArrayList();
			for(int j=0; j<n; j++) {
				jobs.add(new Interval(sc.nextInt(), sc.nextInt(), j));
			}
			Collections.sort(jobs);
			int concurr = 0;
			char last = 'J';
//			StringBuilder ans = new StringBuilder();
			char[] ans = new char[n];
			int last_end = 0;
			PriorityQueue<Integer> ends = new PriorityQueue();
			Boolean fail = false;
			for(Interval job: jobs) {
				while(!ends.isEmpty()) {
					if(ends.peek() <= job.start) {
						ends.poll();
					} else {
						break;
					}
				}
				ends.add(job.end);
				if(ends.size() > 2) {
					System.out.println("Case #"+i+": IMPOSSIBLE");
					fail = true;
					break;
				}
//				ans.append(last == 'J' ? 'C' : 'J');
				ans[job.idx] = last == 'J' ? 'C' : 'J';
				if(job.end > last_end) {
					last_end = job.end;
					last = last =='J' ? 'C' : 'J';
				}
			}
			if(!fail)
				System.out.println("Case #"+i+": "+charLStr(ans));
			
		}
	}
	
	public static StringBuilder charLStr(char[] raw) {
		StringBuilder sb = new StringBuilder();
		for(char c: raw) {
			sb.append(c);
		}
		return sb;
	}
}

class Interval implements Comparable<Interval>{
	int start;
	int end;
	int idx;
	
	public Interval(int s, int t, int idx) {
		start = s;
		end = t;
		this.idx = idx;
	}
	
	public int compareTo(Interval others) {
		if(this.start < others.start)
			return -1;
		if(this.start > others.start)
			return 1;
		return 0;
	}
}