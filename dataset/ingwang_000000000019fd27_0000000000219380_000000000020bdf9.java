import java.util.*;
import java.io.*;

public class Solution {
	public static class MyScanner {
		BufferedReader bf;
		StringTokenizer st;

		MyScanner() {
			bf = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(bf.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	
	static class Job implements Comparable<Job>{
		public Job(int s, int e,int idx) {
			super();
			this.s = s;
			this.e = e;
			this.idx = idx;
		}
		int s;
		int e;
		int idx;
		@Override
		public int compareTo(Job o) {
			// TODO Auto-generated method stub
			if(this.s==o.s) return this.e-o.e;
			else return this.s-o.s;
		}
		@Override
		public String toString() {
			return "Job [s=" + s + ", e=" + e + "]";
		}
		
	}
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int T= sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for(int tc =1; tc<=T;tc++) {
			sb.append("Case #").append(tc).append(": ");
			int N = sc.nextInt();
			ArrayList <Job> jobs = new ArrayList<Job>();
			for(int i=0;i<N;i++) {
				int s= sc.nextInt();
				int e = sc.nextInt();
				jobs.add(new Job(s,e,i));
			}
			Collections.sort(jobs);
			
			
			PriorityQueue <Job> c = new PriorityQueue <Job>();
			PriorityQueue <Job> j = new PriorityQueue <Job>();
			char answer[] = new char[N+1];
			boolean possible = true;
			for(int i =0 ;i <N;i++) {
				Job now = jobs.get(i);
				if(c.isEmpty()||c.peek().e<now.s) {
					answer[now.idx] = 'C';
					c.add(now);
				}
				else if(j.isEmpty()||j.peek().e<now.s) {
					answer[now.idx] = 'J';
					j.add(now);
				}
				else {
					possible = false;
					break;
				}
			}
			
			if(!possible) {
				sb.append("IMPOSSIBLE");
			}
			else sb.append(String.valueOf(answer));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
