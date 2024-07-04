import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Rename to Solution!!!
/*
1
2 2
0 1
184 330

1
3 2
0 1
184 330

1
10 3
1 5 9
184 200 330

1
3 2
0 1
184 330

1
20 4
0 3 5 7
1 2 1 2

1
20 4
0 3 8 15
1 2 1 2
 */
public class Solution {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			int size=fs.nextInt(), n=fs.nextInt();
			long[] partSizes=new long[n];
			
			int[] positions=fs.readArray(n);
			fs.readArray(n);//skip the temps
			for (int i=1; i<n; i++) partSizes[i]=positions[i]-positions[i-1];
			partSizes[0]=positions[0]+size-positions[n-1];
			positions=null;
			
			long[] posts=new long[n+1];
			for (int i=1; i<posts.length; i++) posts[i]=posts[i-1]+partSizes[i-1];
			
			if (possibleInN(n, posts, partSizes, size)) {
				System.out.println("Case #"+(tt+1)+": "+n);
				continue;
			}
//			System.err.println("Real:");
			int ans=2*n;
			for (int start=0; start<n; start++) {
				long[] partSizesOffset=new long[n];
				for (int i=0; i<n; i++) partSizesOffset[i]=partSizes[(i+start)%n];
				long[] postsOffset=new long[n+1];
				for (int i=1; i<=n; i++) postsOffset[i]=postsOffset[i-1]+partSizesOffset[i-1];
				ans=Math.min(ans, tryForStart(n, postsOffset, partSizesOffset, size));
			}
			System.out.println("Case #"+(tt+1)+": "+ans);
		}
	}
	
	static int tryForStart(int n, long[] posts, long[] partSizes, int size) {
		int nSections=1;
		Range cur=new Range(0, posts[1]);
		for (int i=1; i<=n; i++) {
			long post=posts[i];
			cur=cur.flipOver(post);
			cur.boundLeft(post);
			if (i<n) cur.boundRight(posts[i+1]);
			else cur.boundRight(posts[1]+size);
			if (!cur.valid() && i<n) {
				nSections++;
				cur=new Range(posts[i], posts[i+1]);
			}
		}
		return nSections+n;
	}
	
	static boolean possibleInN(int n, long[] posts, long[] partSizes, int size) {
		Range cur=new Range(0, partSizes[0]);
		for (int i=0; i<n; i++) {
			cur=cur.flipOver(posts[i+1]);
			cur.boundLeft(posts[i+1]);
			if (i+1<n) cur.boundRight(posts[i+2]);
			else cur.boundRight(posts[1]+size);
			if (!cur.valid()) {
				return false;
			}
		}
		long startL=cur.l-size;
		long startR=cur.r-size;
//		System.out.println("Starting at "+startL+" "+startR);
		Range cur1=new Range(startL, startL);
		Range cur2=new Range(startR, startR);
		for (int i=0; i<n; i++) {
			cur1=cur1.flipOver(posts[i+1]);
			cur2=cur2.flipOver(posts[i+1]);
		}
		cur1.l-=size;
		cur2.l-=size;
		if (cur1.l>=startL && cur2.l<=startR) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static class Range {
		long l, r;
		public Range(long l, long r) {
			this.l=l;
			this.r=r;
		}
		
		public Range flipOver(long x) {
			long newR=x+(x-l);
			long newL=x+(x-r);
			return new Range(newL, newR);
		}
		
		public boolean valid() {
			return l<=r;
		}
		
		public void boundLeft(long l) {
			this.l=Math.max(this.l, l);
		}
		public void boundRight(long r) {
			this.r=Math.min(this.r, r);
		}
		public String toString() {
			return l+" to "+r;
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
