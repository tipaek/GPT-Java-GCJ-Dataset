
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
			char[] s = ns().toCharArray();
			char[] t = ns().toCharArray();
			int[][] ed = editDistance(s, t, 1, 1, 1);
			int r = s.length, c = t.length;
			int rem = ed[r][c] / 2;
			
			int[][] route = new int[70][];
			int p = 0;
			route[p++] = new int[]{r, c};
			while(true){
				if(ed[r][c] == rem)break;
				boolean done = false;
				if(r-1 >= 0 && c-1 >= 0){
					if(s[r-1] == t[c-1] && ed[r-1][c-1] == ed[r][c]){
						r--; c--;
						done = true;
					}else if(s[r-1] != t[c-1] && ed[r-1][c-1] == ed[r][c] - 1){
						r--; c--;
						done = true;
					}
				}
				if(!done){
					if(r-1 >= 0 && ed[r-1][c] + 1 == ed[r][c]){
						r--;
						done = true;
					}
				}
				if(!done){
					c--;
				}
				route[p++] = new int[]{r, c};
			}
			String ans = new String(s, 0, r) + new String(t, c, t.length-c);
//			tr(ans);
//			tr(editDistancev(s, ans.toCharArray(), 1, 1, 1), editDistancev(t, ans.toCharArray(), 1, 1, 1));
			out.println(ans);
		}
	}
	
	public static int[][] editDistance(char[] a, char[] b, int add, int erase, int change)
	{
		int INF = Integer.MAX_VALUE / 3;
		int n = a.length;
		int m = b.length;
		int[][] dp = new int[n+1][m+1];
		for(int i = 0;i <= n;i++){
			for(int j = 0;j <= m;j++){
				if(i == 0 && j == 0)continue;
				int min = INF;
				if(i-1 >= 0)min = Math.min(min, dp[i-1][j] + erase);
				if(j-1 >= 0)min = Math.min(min, dp[i][j-1] + add);
				if(i-1 >= 0 && j-1 >= 0)min = Math.min(min, dp[i-1][j-1] + (a[i-1] != b[j-1] ? change : 0));
				dp[i][j] = min;
			}
		}
		return dp;
	}

	
	public static int editDistancev(char[] a, char[] b, int add, int erase, int change)
	{
		int INF = Integer.MAX_VALUE / 3;
		int n = a.length;
		int m = b.length;
		int[][] dp = new int[n+1][m+1];
		for(int i = 0;i <= n;i++){
			for(int j = 0;j <= m;j++){
				if(i == 0 && j == 0)continue;
				int min = INF;
				if(i-1 >= 0)min = Math.min(min, dp[i-1][j] + erase);
				if(j-1 >= 0)min = Math.min(min, dp[i][j-1] + add);
				if(i-1 >= 0 && j-1 >= 0)min = Math.min(min, dp[i-1][j-1] + (a[i-1] != b[j-1] ? change : 0));
				dp[i][j] = min;
			}
		}
		return dp[n][m];
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
