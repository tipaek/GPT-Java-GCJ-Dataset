import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

//Rename to Solution!!!
/*
4
XYZZY ZZYZX
Y Z
YYXXYZ ZYYXXY
XZXZXZ YZ
 */
public class Solution {
	
	static char[] a, b;
	
	static Random random=new Random(5);
	static int[][] dp;

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		for (int tt=0; tt<T; tt++) {
			a=fs.next().toCharArray();
			b=fs.next().toCharArray();
//			a=getRandom();
//			b=getRandom();
//			System.out.println();
//			System.out.println(a);
//			System.out.println(b);
			dp=new int[a.length+1][b.length+1];
			for (int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
			int editDist=go(0, 0);
			ArrayList<String> res=new ArrayList<>();
			buildback(0, 0, res);
			StringBuilder sb=new StringBuilder();
			int aInd=0, bInd=0, movesLeft=editDist/2;
			for (String s:res) {
				if (movesLeft<=0) break;
				if (s.equals("INSERT")) {
					sb.append(b[bInd]);
					bInd++;
					movesLeft--;
				}
				else if (s.equals("DELETE")) {
					aInd++;
					movesLeft--;
				}
				else if (s.equals("MATCH")) {
					sb.append(a[aInd]);
					if (a[aInd]!=b[bInd]) throw null;
					aInd++;
					bInd++;
				}
				else if (s.equals("CHANGE")) {
					sb.append(b[bInd]);
					aInd++;
					bInd++;
					movesLeft--;
				}
				else throw null;
			}
			while (aInd<a.length) sb.append(a[aInd++]);
			System.out.println("Case #"+(tt+1)+": "+sb.toString());
		}
	}
	
	static char[] getRandom() {
		int len=1+random.nextInt(6);
		char[] res=new char[len];
		for (int i=0; i<len; i++) res[i]=(char)('X'+random.nextInt(3));
		return res;
	}
	
	static int go(int aInd, int bInd) {
		if (aInd==a.length) return (b.length-bInd);
		if (bInd==b.length) return (a.length-aInd);
		if (dp[aInd][bInd]!=-1) {
			return dp[aInd][bInd];
		}
		if (a[aInd]==b[bInd]) return go(aInd+1, bInd+1);
		int best=Integer.MAX_VALUE;
		best=Math.min(best, 1+go(aInd+1, bInd));
		best=Math.min(best, 1+go(aInd, bInd+1));
		best=Math.min(best, 1+go(aInd+1, bInd+1));
		return dp[aInd][bInd]=best;
	}
	
	
	//edits to turn a into b
	static void buildback(int aInd, int bInd, ArrayList<String> transitions) {
		if (aInd==a.length) {
			for (int i=bInd; i<b.length; i++) transitions.add("INSERT");
			return;
		}
		if (bInd==b.length) {
			for (int i=aInd; i<a.length; i++) transitions.add("DELETE");
			return;
		}
		if (a[aInd]==b[bInd]) {
			transitions.add("MATCH");
			buildback(aInd+1, bInd+1, transitions);
			return;
		}
		if (go(aInd, bInd)==1+go(aInd+1, bInd)) {
			transitions.add("DELETE");
			buildback(aInd+1, bInd, transitions);
			return;
		}
		if (go(aInd, bInd)==1+go(aInd, bInd+1)) {
			transitions.add("INSERT");
			buildback(aInd, bInd+1, transitions);
			return;
		}
		if (go(aInd, bInd)==1+go(aInd+1, bInd+1)) {
			transitions.add("CHANGE");
			buildback(aInd+1, bInd+1, transitions);
			return;
		}
		throw null;
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
