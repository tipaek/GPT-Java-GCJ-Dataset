import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			int n=fs.nextInt();
			VecL[] points=new VecL[n];
			for (int i=0; i<n; i++) points[i]=new VecL(fs.nextLong(), fs.nextLong());
			System.out.println("Case #"+(tt+1)+": "+solve(n, points));
		}
	}
	
	static int solve(int n, VecL[] points) {
		if (n<3) return n;
		int max=0;
		for (VecL a:points) {
			for (VecL b:points) {
				if (a==b) continue;
				VecL dotWith=b.sub(a).rot90();
				TreeMap<Long, Integer> set=new TreeMap<>();
				for (VecL v:points) {
					long dot=v.dot(dotWith);
					set.put(dot, set.getOrDefault(dot, 0)+1);
				}
				ArrayList<Integer> counts=new ArrayList<>();
				for (Map.Entry<Long, Integer> e:set.entrySet()) {
					counts.add(e.getValue());
				}
				max=Math.max(max, solve(counts));
			}
		}
		return max;
	}
	
	static int solve(ArrayList<Integer> counts) {
		int sumNonOnes=0;
		int nOdds=0;
		int nOnes=0;
		for (int i:counts) {
			if (i%2==0) {
				sumNonOnes+=i;
				continue;
			}
			else {
				if (i==1) {
					nOnes++;
				}
				else {
					sumNonOnes+=i;
					nOdds++;
				}
			}
		}
		if (nOdds%2==0) {
			sumNonOnes+=Math.min(nOnes, 2);
		}
		else {
			sumNonOnes+=Math.min(nOnes, 1);
		}
		return sumNonOnes;
	}

	static class VecL implements Comparable<VecL> {
		long x, y;
		public VecL(long x, long y) {this.x=x;this.y=y;}
		public VecL add(VecL o) {return new VecL(x+o.x, y+o.y);}
		public VecL sub(VecL o) {return new VecL(x-o.x, y-o.y);}
		public VecL scale(long s) {return new VecL(x*s, y*s);}
		public long dot(VecL o) {return x*o.x+y*o.y;}
		public long cross(VecL o) {return x*o.y-y*o.x;}
		public long mag2() {return dot(this);}
		public VecL rot90() {return new VecL(-y, x);}
		public VecL rot270() {return new VecL(y, -x);}
		public String toString() {return "("+x+", "+y+")";}
		public int hashCode() {return Long.hashCode(x<<13^(y*57));}
		
		public boolean equals(Object oo) {
			VecL o=(VecL)oo;
			return x==o.x&&y==o.y;
		}
		
		public int compareTo(VecL o) {
			if (x!=o.x) return Long.compare(x, o.x);
			return Long.compare(y, o.y);
		}
		
		//origin->q1, axes-> quadrant in ccw direction
		public int quadrant() {
			if (x==0||y==0)
				if (y==0)
					if (x>=0)
						return 1;
					else
						return 3;
				else
					if (y>=0)
						return 2;
					else
						return 4;
			if (x>0)
				if (y>0)
					return 1;
				else
					return 4;
			else
				if (y>0)
					return 2;
				else
					return 3;
		}
		
		public int radialCompare(VecL o) {
			if (quadrant()==o.quadrant())
				return -Long.signum(cross(o));
			return Integer.compare(quadrant(), o.quadrant());
		}
	}

	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

	
}
