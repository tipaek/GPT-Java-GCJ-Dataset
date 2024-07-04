import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static class Work implements Comparable<Work> {
		public int start;
		public int end;
		public int order;
		public Work(int start, int end,int order) {
			this.start = start;
			this.end = end;
			this.order = order;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result + order;
			result = prime * result + start;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Work other = (Work) obj;
			if (end != other.end)
				return false;
			if (order != other.order)
				return false;
			if (start != other.start)
				return false;
			return true;
		}
		@Override
		public int compareTo(Work o) {
			return this.start - o.start;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int t=1;t<=test_case;t++) {
			int l,r,flag=0;
			Work[] works = new Work[2];
			works[0] = new Work(0,0,-1);
			works[1] = new Work(0,0,-1);
			int n = sc.nextInt();
			char[] res = new char[n];
			List<Work> list = new ArrayList<Work>();
			for(int i=0;i<n;i++) {
				l = sc.nextInt();
				r = sc.nextInt();
				Work work = new Work(l,r,i);
				list.add(work);
			}
			list.sort(null);
			for (Work e : list) {
				if(e.start < works[0].end && e.start < works[1].end) {
					flag = -1;
					break;
				}
				else if(e.start >= works[flag].end) {
					works[flag] = e;
					if(flag==0) res[e.order] = 'C';
					else res[e.order] = 'J';
				}else {
					flag = (flag+1)%2;
					works[flag] = e;
					if(flag==0) res[e.order] = 'C';
					else res[e.order] = 'J';
				}
			}
			if(flag == -1) System.out.println("Case #" + t + ": IMPOSSIBLE");
			else System.out.println("Case #" + t + ": " + String.valueOf(res));
		}
	}
}
