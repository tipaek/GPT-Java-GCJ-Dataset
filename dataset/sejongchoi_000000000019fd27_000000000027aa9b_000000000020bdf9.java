import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static class Work implements Comparable<Work> {
		public int start;
		public int end;
		public Work(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
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
			int[] endtime = new int[2];
			int n = sc.nextInt();
			char[] res = new char[n];
			Map<Work, Integer> order = new HashMap<Work,Integer>();
			List<Work> list = new ArrayList<Work>();
			for(int i=0;i<n;i++) {
				l = sc.nextInt();
				r = sc.nextInt();
				Work work = new Work(l,r);
				list.add(work);
				order.put(work,i);
			}
			list.sort(null);
			for (Work e : list) {
				if(e.start < endtime[0] && e.start < endtime[1]) {
					System.out.println(e.start + " " + endtime[0] + " " + endtime[1]);
					flag = -1;
					break;
				}
				else if(e.start >= endtime[flag]) {
					endtime[flag] = e.end;
					if(flag==0) res[order.get(e)] = 'C';
					else res[order.get(e)] = 'J';
				}else {
					flag = (flag+1)%2;
					endtime[flag] = e.end;
					if(flag==0) res[order.get(e)] = 'C';
					else res[order.get(e)] = 'J';
				}
			}
			if(flag == -1) System.out.println("Case #" + t + ": IMPOSSIBLE");
			else System.out.println("Case #" + t + ": " + String.valueOf(res));
		}
	}
}
