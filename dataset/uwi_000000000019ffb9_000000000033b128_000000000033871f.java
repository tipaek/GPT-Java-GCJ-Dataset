import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

// Solution
public class Solution {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";
	
	static void solve()
	{
		for(int T = ni(), cas = 1;T > 0;T--,cas++){
			out.print("Case #" + cas + ": ");
			int n = ni(), m = ni();
			int[] a = new int[n];
			for(int i = 0;i < n-1;i++)a[i+1] = ni();
			int[] from = new int[m];
			int[] to = new int[m];
			for(int i = 0;i < m;i++){
				from[i] = ni()-1;
				to[i] = ni()-1;
			}
//			boolean[][] dom = new boolean[n][n];
//			for(int i = 0;i < n;i++){
//				DJSet ds = new DJSet(n);
//				for(int j = 0;j < m;j++){
//					if(from[j] != i && to[j] != i){
//						ds.union(from[j], to[j]);
//					}
//				}
//				for(int j = 0;j < n;j++){
//					if(i != j && !ds.equiv(0, j)){
//						dom[i][j] = true;
//					}
//				}
//			}
//			for(int i = 0;i < n;i++){
//				for(int j = 0;j < n;j++){
//					if(a[i] < 0 && a[j] < 0 && a[i] > a[j]){
//						dom[i][j] = true;
//					}
//				}
//			}
			int[][] ts = new int[n][];
			int p = 0;
			for(int i = 0;i < n;i++){
				if(a[i] >= 0){
					ts[p++] = new int[]{a[i], i};
				}
			}
			ts = Arrays.copyOf(ts, p);
			Arrays.sort(ts, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return a[0] - b[0];
				}
			});

			int[] ord = new int[n];
			Arrays.fill(ord, -1);
			for(int i = 0;i < n;i++){
				if(a[i] < 0){
					int k = -a[i];
					while(ord[k] != -1)k++;
					ord[k] = i;
				}
			}
			int q = 0;
			for(int i = 0;i < n;i++){
				if(ord[i] == -1){
					ord[i] = ts[q++][1];
				}
			}
//			tr(ord);
			for(int i = 0;i < n;i++){
				if(ord[i] == -1)throw new RuntimeException();
			}
			
			int[] ds = new int[n];
			Arrays.fill(ds, -1);
			int time = 0;
			for(int i = 0;i < n;i++){
				int cur = ord[i];
				if(ds[cur] >= 0)continue;
				if(a[cur] > 0){
					ds[cur] = a[cur];
					time = a[cur];
				}else{
					for(int j = 0;j < n;j++){
						if(a[cur] == a[j]){
							ds[j] = time;
						}
					}
				}
				time++;
			}
			
			// check
			for(int i = 0;i < n;i++){
				if(a[i] < 0){
					int ct = 0;
					for(int j = 0;j < n;j++){
						if(ds[j] < ds[i]){
							ct++;
						}
					}
					if(ct != -a[i])throw new RuntimeException();
//					assert ct == -a[i];
				}
			}
			
			for(int i = 0;i < m;i++){
				if(ds[from[i]] == ds[to[i]]){
					out.print(1000000 + " ");
				}else{
					out.print(Math.abs(ds[to[i]] - ds[from[i]]) + " ");
				}
			}
			out.println();
		}
	}
	
	public static void tf(boolean[]... b)
	{
		for(boolean[] r : b) {
			for(boolean x : r)System.out.print(x?'#':'.');
			System.out.println();
		}
		System.out.println();
	}
	
	public static int[] sortTopologically(boolean[][] g)
	{
		int n = g.length;
		int[] ec = new int[n];
		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++){
				if(g[i][j])ec[j]++;
			}
		}
		int[] ret = new int[n];
		int p = 0;
		int q = 0;
		
		ost:
		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++){
				if(g[j][i])continue ost;
			}
			ret[q++] = i;
		}
		
		for(;p < q;p++){
			int cur = ret[p];
			for(int i = 0;i < n;i++){
				if(g[cur][i]){
					ec[i]--;
					if(ec[i] == 0)ret[q++] = i;
				}
			}
		}
		for(int i = 0;i < n;i++){
			if(ec[i] > 0){
				return null;
			}
		}
		return ret;
	}

	
	public static class DJSet {
		public int[] upper;

		public DJSet(int n) {
			upper = new int[n];
			Arrays.fill(upper, -1);
		}

		public int root(int x) {
			return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
		}

		public boolean equiv(int x, int y) {
			return root(x) == root(y);
		}

		public boolean union(int x, int y) {
			x = root(x);
			y = root(y);
			if (x != y) {
				if (upper[y] < upper[x]) {
					int d = x;
					x = y;
					y = d;
				}
				upper[x] += upper[y];
				upper[y] = x;
			}
			return x == y;
		}

		public int count() {
			int ct = 0;
			for (int u : upper)
				if (u < 0)
					ct++;
			return ct;
		}
	}

	
	static int[][] packU(int n, int[] from, int[] to) {
		int[][] g = new int[n][];
		int[] p = new int[n];
		for (int f : from)
			p[f]++;
		for (int t : to)
			p[t]++;
		for (int i = 0; i < n; i++)
			g[i] = new int[p[i]];
		for (int i = 0; i < from.length; i++) {
			g[from[i]][--p[from[i]]] = to[i];
			g[to[i]][--p[to[i]]] = from[i];
		}
		return g;
	}
	
	public static void main(String[] args) throws Exception
	{
		long S = System.currentTimeMillis();
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		solve();
		out.flush();
		long G = System.currentTimeMillis();
		tr(G-S+"ms");
	}
	
	private static boolean eof()
	{
		if(lenbuf == -1)return true;
		int lptr = ptrbuf;
		while(lptr < lenbuf)if(!isSpaceChar(inbuf[lptr++]))return false;
		
		try {
			is.mark(1000);
			while(true){
				int b = is.read();
				if(b == -1){
					is.reset();
					return true;
				}else if(!isSpaceChar(b)){
					is.reset();
					return false;
				}
			}
		} catch (IOException e) {
			return true;
		}
	}
	
	private static byte[] inbuf = new byte[1024];
	static int lenbuf = 0, ptrbuf = 0;
	
	private static int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
//	private static boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
	private static int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private static double nd() { return Double.parseDouble(ns()); }
	private static char nc() { return (char)skip(); }
	
	private static String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private static char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private static char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private static int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private static int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private static long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }
}
