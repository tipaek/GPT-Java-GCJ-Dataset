import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static long[][] nCk=new long[1000][1000];
	
	public static void main(String[] args) {
		precomp();
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int x=0; x<50; x++) {
//			System.out.println(x);
//			for (int y=0; y<50; y++) {
//				System.out.print(nCk[x][y]+" ");
//			}
//			System.out.println();
		}
		outer:for (int tt=1; tt<=T; tt++) {
			long target=fs.nextLong();
			System.out.println("Case #"+tt+":");
			if (target<100) {
				for (int i=1; i<=target; i++) {
					System.out.println(i+" "+1);
				}
			}
			else {
				ArrayList<Vec> toReturn=new ArrayList<>();
				long orig=target;
				for (int n=0; n<40; n++) {
					toReturn.add(new Vec(n, 0));
					target--;
				}
				solve(40, 0, toReturn, target);
				long got=0;
				for (Vec v:toReturn) {
					got+=nCk[v.x][v.y];
					System.out.println((v.x+1)+" "+(v.y+1));
				}
				if (got!=orig) {
					throw null;
				}
				if (toReturn.size()>500) {
					throw null;
				}
			}
		}
	}

	static void solve(int n, int k, ArrayList<Vec> toReturn, long target) {
		if (target==0) {
			return;
		}
//		System.out.println("At "+n+" "+k+" "+target);
		toReturn.add(new Vec(n, k));
		target-=nCk[n][k];
		if (target<150) {
			if (k>0) {
				solve(n, k-1, toReturn, target);
				return;
			}
			else {
				solve(n+1, k, toReturn, target);
			}
			return;
		}
		if (canWin(n, k+1, target)) {
			solve(n, k+1, toReturn, target);
			return;
		}
		else {
			solve(n, k-1, toReturn, target);
			return;
		}
		
	}
	
	static boolean canWin(int n, int k, long total) {
		long sum=0;
		while (k>=0) {
			sum+=nCk[n][k];
			k--;
		}
		return sum<=total;
	}
	
	static void precomp() {
		nCk[0][0]=1;
		for (int n=1; n<nCk.length; n++) {
			nCk[n][0]=nCk[n][n]=1;
			for (int k=1; k<n; k++) {
				nCk[n][k]=nCk[n-1][k]+nCk[n-1][k-1];
				nCk[n][k]=Math.min(nCk[n][k], (long)1e18);
			}
		}
	}

	static class Vec {
		int x,y;
		public Vec(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreElements()) {
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
