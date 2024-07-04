

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Random;

// Solution
public class Solution {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";
	
	static void solve()
	{
		for(int T = ni(), cas = 1;T > 0;T--,cas++){
			out.print("Case #" + cas + ": ");
			int n = ni();
			int K = ni();
			tr(n, K);
			if(n <= 4){
				int[][] a = new int[n][n];
				if(dfs(a, 0, 0, K-n)){
					for(int i = 0;i < n;i++){
						for(int j = 0;j < n;j++){
							a[i][j]++;
						}
					}
					print(a);
				}else{
					out.println("IMPOSSIBLE");
				}
				continue;
			}
			if(K == 1+n || K == n*n-1){
				out.println("IMPOSSIBLE");
				continue;
			}
			
			Random gen = new Random();
			inner:
			while(true){
				int[][] a = new int[n][n];
				for(int i = 0;i < n;i++)a[i][i] = 1;
				for(int i = 0;i < K-n;i++){
					while(true){
						int x = gen.nextInt(n);
						if(a[x][x] == n)continue;
						a[x][x]++;
						break;
					}
				}
				int[] f = new int[n+1];
				for(int i = 0;i < n;i++){
					f[a[i][i]]++;
				}
				int[][] fi = new int[n][];
				for(int i = 0;i < n;i++){
					fi[i] = new int[]{f[i+1], i+1};
				}
				Arrays.sort(fi, new Comparator<int[]>() {
					public int compare(int[] a, int[] b) {
						return -(a[0] - b[0]);
					}
				});
				
				for(int z = 0;z < n;z++){
					int j = fi[z][1];
					boolean[][] g = new boolean[n][n];
					for(int k = 0;k < n;k++){
						for(int l = 0;l < n;l++){
							if(k != l){
								g[k][l] = a[k][l] == 0 && a[k][k] != j && a[l][l] != j;
							}else{
								g[k][l] = a[k][k] == j;
							}
						}
					}
					int[] mat = doBipartiteMatching(g);
					for(int k = 0;k < n;k++){
						if(mat[k] == -1)continue inner;
					}
					for(int k = 0;k < n;k++){
						a[k][mat[k]] = j;
					}
				}
				
				print(a);
				break;
			}
//			if(n >= 7){
//				for(int i = 2;i <= n-i;i++){
//					for(int j = i;i+j <= n;j++){
//						int k = n-i-j;
//						if(j <= k){
//							for(int u = 0;u < n;u++){
//								for(int v = 0;v < n;v++){
//									for(int w = 0;w < n;w++){
//										if(u*i+v*j+w*k == K){
//											
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//				
//				
//				boolean[] hey = new boolean[(n-1)*n+1];
//				for(int i = 2;i <= n-i;i++){
//					int j = n-i;
//					for(int k = 0;k < n;k++){
//						for(int l = 0;l < n;l++){
//							hey[k*i+l*j] = true;
//						}
//					}
//				}
//				for(int i = 0;i < hey.length;i++){
//					if(i == 1 || i == hey.length-2)continue;
//					assert hey[i];
//				}
//			}
		}
	}
	
	public static int[] doBipartiteMatching(boolean[][] g)
	{
		int n = g.length;
		if(n == 0)return new int[0];
		int m = g[0].length;
		if(m == 0){
			int[] ret = new int[n];
			Arrays.fill(ret, -1);
			return ret;
		}
		int[] im = new int[m];
		Arrays.fill(im, -1);
		boolean[] visited = new boolean[n];
		int matched = 0;
		for(int i = 0;i < n;i++){
			if(visit(g, i, visited, im)) {
				Arrays.fill(visited, false);
				matched++;
			}
		}

		int[] ret = new int[n];
		Arrays.fill(ret, -1);
		for(int i = 0;i < m;i++){
			if(im[i] != -1)ret[im[i]] = i;
		}
		return ret;
	}

	public static boolean visit(boolean[][] g, int cur, boolean[] visited, int[] im)
	{
		if(cur == -1)return true;

		for(int i = 0;i < visited.length;i++){
			if(g[cur][i] && !visited[i]){
				visited[i] = true;
				if(visit(g, im[i], visited, im)){
					im[i] = cur;
					return true;
				}
			}
		}
		return false;
	}
	
	static void print(int[][] a)
	{
		int n = a.length;
		out.println("POSSIBLE");
		for(int i = 0;i < n;i++){
			for(int j = 0;j < n;j++){
				out.print(a[i][j] + " ");
			}
			out.println();
		}
	}
	
	static boolean dfs(int[][] a, int r, int c, int K)
	{
		int n = a.length;
		if(r == n){
			int s = 0;
			for(int i = 0;i < n;i++){
				s += a[i][i];
			}
			if(s == K){
				return true;
			}
			return false;
		}
		if(c == n){
			return dfs(a, r+1, 0, K);
		}
		
		int ptn = 0;
		for(int j = 0;j < c;j++){
			ptn |= 1<<a[r][j];
		}
		for(int j = 0;j < r;j++){
			ptn |= 1<<a[j][c];
		}
		
		for(int i = 0;i < n;i++){
			if(ptn<<~i<0)continue;
			a[r][c] = i;
			if(dfs(a, r, c+1, K))return true;
			a[r][c] = 0;
		}
		return false;
	}
	
	
	public static void main(String[] args) throws Exception
	{
		int n = 100, m = 99999;
		Random gen = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append(21 + " ");
		for(int k = 5;k <= 25;k++){
			sb.append(5 + " ");
			sb.append(k + " ");
//			sb.append(50 + " ");
//			sb.append(1145 + " ");
		}
		INPUT = sb.toString();

		
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
