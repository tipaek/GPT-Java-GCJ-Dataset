import java.io.*;
import java.util.*;

class Solution {
	public static class Pair implements Comparable<Pair> {
		public int a, b,index;

		public Pair(int x, int y, int i) {
			a = x;
			b = y;
			index=i;
		}

		public int compareTo(Pair e) {
			if (a != e.a)
				return a - e.a;
			else
				return b - e.b;
		}
		
		public boolean equals(Object other) {
			// see if we are referring the same object
			if (this==other) return true;
			// see if a null is passed in or an object that is not a tester
			if ((other==null)||!(other instanceof Pair)) return false;
			Pair otherPair = (Pair) other;
			// check each attribute the otherPair passed in
			boolean result = (a==otherPair.a)&&(b==otherPair.b);
			return result;
		}
	}
	
	public static class Assign implements Comparable<Assign> {
		public int index;
		public char name;

		public Assign(int i, char c) {
			index=i;
			name=c;
		}

		public int compareTo(Assign a) {
			return index-a.index;
		}
	}
	
	public static void main(String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int c=1;c<=t;c++) {
			st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			Pair [] intervals = new Pair [n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(f.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				intervals[i]=new Pair(a,b,i);
			}
			Arrays.sort(intervals);
			Assign [] assign = new Assign [n];
			boolean impossible=false;
			int c_max=0, j_max=0;
			for(int i=0;i<n;i++) {
				if (intervals[i].a>=c_max) {
					assign[i] =new Assign(intervals[i].index,'C');
					c_max=Math.max(c_max, intervals[i].b);
					}
				else if (intervals[i].a>=j_max) {
					assign[i] =new Assign(intervals[i].index,'J');
					j_max=Math.max(j_max, intervals[i].b);
				}
				else {impossible=true;break;}
			}
			
			String result="Case #"+c+": ";
			if (impossible) result=result+"IMPOSSIBLE";
			else {
				Arrays.sort(assign);
				for(int i=0;i<n;i++) result=result+assign[i].name;
			}
			System.out.println(result);
		}
	}
}